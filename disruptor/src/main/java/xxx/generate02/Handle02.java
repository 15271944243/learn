package xxx.generate02;

import com.lmax.disruptor.EventHandler;

public class Handle02 implements EventHandler<Trade> {

    @Override
    public void onEvent(Trade trade, long l, boolean b) throws Exception {
        System.out.println("handler2: set price");
        trade.setPrice(17.0);
        Thread.sleep(1000);
    }
}
