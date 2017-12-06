package xxx.generate01;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

import java.util.UUID;

public class TradeHandler implements EventHandler<Trade>,WorkHandler<Trade>{

    @Override
    public void onEvent(Trade trade, long l, boolean b) throws Exception {
        this.onEvent(trade);
    }

    @Override
    public void onEvent(Trade trade) throws Exception {
        //这里做具体的消费逻辑
        trade.setId(UUID.randomUUID().toString());//简单生成下ID
        System.out.println(trade.getId());
    }
}
