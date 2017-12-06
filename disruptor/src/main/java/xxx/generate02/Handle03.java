package xxx.generate02;

import com.lmax.disruptor.EventHandler;

public class Handle03 implements EventHandler<Trade>{

    @Override
    public void onEvent(Trade trade, long l, boolean b) throws Exception {
        System.out.println("handler3: name: " + trade.getName() + " , price: " + trade.getPrice() + ";  instance: " + trade.toString());
    }
}
