package xxx.generate02;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        int bufferSize = 1024;
        ExecutorService executor = Executors.newFixedThreadPool(8);
        EventFactory<Trade> eventFactory = new EventFactory<Trade>() {
            @Override
            public Trade newInstance() {
                return new Trade();
            }
        };
        Disruptor<Trade> disruptor = new Disruptor<Trade>(eventFactory,bufferSize,executor, ProducerType.SINGLE,new BusySpinWaitStrategy());
        // 菱形操作
        // 使用disruptor创建消费者组c1,c2(c1,c2并行执行)
        // EventHandlerGroup<Trade> handlerGroup = disruptor.handleEventsWith(new Handle01(),new Handle02());
        // 声明在c1,c2完事之后执行JMS消息发送操作 也就是流程走到c3
        // handlerGroup.then(new Handle03());

        //顺序操作
        /**
         disruptor.handleEventsWith(new Handler1()).
         handleEventsWith(new Handler2()).
         handleEventsWith(new Handler3());
         */

        //六边形操作.
        Handle01 h1 = new Handle01();
        Handle02 h2 = new Handle02();
        Handle03 h3 = new Handle03();
        Handle04 h4 = new Handle04();
        Handle05 h5 = new Handle05();
        disruptor.handleEventsWith(h1, h2);
        disruptor.after(h1).handleEventsWith(h4);
        disruptor.after(h2).handleEventsWith(h5);
        disruptor.after(h4, h5).handleEventsWith(h3);


        // 启动
        disruptor.start();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        // 生产者准备
        executor.submit(new TradePublisher(disruptor,countDownLatch));
        countDownLatch.await();
        disruptor.shutdown();
        executor.shutdown();
        System.out.println("总耗时:"+(System.currentTimeMillis()-beginTime));
    }
}
