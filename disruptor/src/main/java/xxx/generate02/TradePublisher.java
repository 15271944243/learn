package xxx.generate02;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TradePublisher implements Runnable{

    private Disruptor<Trade> disruptor;
    private CountDownLatch latch;
    private static int LOOP = 10;

    public TradePublisher(Disruptor<Trade> disruptor, CountDownLatch latch) {
        this.disruptor = disruptor;
        this.latch = latch;
    }

    @Override
    public void run() {
        TradeEventTranslator translator = new TradeEventTranslator();
        for(int i=0;i<LOOP;i++){
            disruptor.publishEvent(translator);
        }
        latch.countDown();
    }
}

class TradeEventTranslator implements EventTranslator<Trade>{
    private Random random = new Random();

    @Override
    public void translateTo(Trade trade, long l) {
        genreateTrade(trade);
    }

    private Trade genreateTrade(Trade trade){
        trade.setPrice(random.nextDouble() * 9999);
        return trade;
    }
}