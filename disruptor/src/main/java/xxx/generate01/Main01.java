package xxx.generate01;

import com.lmax.disruptor.*;

import java.util.concurrent.*;

public class Main01 {
    public static void main(String[] args) {
        int BUFFER_SIZE = 1024;
        int THREAD_NUMBERS = 4;
        /*
         * createSingleProducer创建一个单生产者的RingBuffer，
         * 第一个参数叫EventFactory，从名字上理解就是"事件工厂"，其实它的职责就是产生数据填充RingBuffer的区块。
         * 第二个参数是RingBuffer的大小，它必须是2的指数倍 目的是为了将求模运算转为&运算提高效率
         * 第三个参数是RingBuffer的生产都在没有可用区块的时候(可能是消费者（或者说是事件处理器） 太慢了)的等待策略
         */
        final RingBuffer<Trade> ringBuffer = RingBuffer.createSingleProducer(new EventFactory<Trade>() {
            @Override
            public Trade newInstance() {
                return new Trade();
            }
        },BUFFER_SIZE,new YieldingWaitStrategy());

        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBERS);
        //创建SequenceBarrier
        SequenceBarrier barrier = ringBuffer.newBarrier();
        // 创建消息处理器
        BatchEventProcessor<Trade> processor = new BatchEventProcessor<Trade>(ringBuffer,barrier,new TradeHandler());
        // 这一步的目的就是把消费者的位置信息引用注入到生产者    如果只有一个消费者的情况可以省略
        ringBuffer.addGatingSequences(processor.getSequence());
        // 把消息处理器提交到线程池
        executor.submit(processor);

        Future<?> future = executor.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                long seq;
                for(int i=0;i<10;i++){
                    seq = ringBuffer.next();   // 占个坑 --ringBuffer一个可用区块
                    ringBuffer.get(seq).setPrice(Math.random()*9999);// 给这个区块放入 数据
                    ringBuffer.publish(seq);   // 发布这个区块的数据使handler(consumer)可见
                }
                return null;
            }
        });
        try {
            future.get();               // 等待生产者结束
            Thread.sleep(1000);  // 等上1秒，等消费都处理完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        processor.halt();               //通知事件(或者说消息)处理器 可以结束了（并不是马上结束!!!）
        executor.shutdown();            //终止线程
    }
}
