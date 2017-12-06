package xxx.generate02;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class Handle04 implements EventHandler<Trade>,WorkHandler<Trade>{
    @Override
    public void onEvent(Trade trade, long l, boolean b) throws Exception {
        this.onEvent(trade);
    }

    @Override
    public void onEvent(Trade trade) throws Exception {
        System.out.println("handler4: get name : " + trade.getName());
        trade.setName(trade.getName() + "h4");
    }
}
