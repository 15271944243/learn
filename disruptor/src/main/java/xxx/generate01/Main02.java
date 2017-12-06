package xxx.generate01;

import com.lmax.disruptor.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main02 {

    public static void main(String[] args) {
        int BUFFER_SIZE = 1024;
        int THREAD_NUMBERS = 4;
        EventFactory<Trade> eventFactory = new EventFactory<Trade>() {
            @Override
            public Trade newInstance() {
                return new Trade();
            }
        };
        final RingBuffer<Trade> ringBuffer = RingBuffer.createSingleProducer(eventFactory,BUFFER_SIZE,new YieldingWaitStrategy());
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBERS);
        SequenceBarrier barrier = ringBuffer.newBarrier();
        WorkHandler<Trade> workHandler = new TradeHandler();
        WorkerPool<Trade> workerPool = new WorkerPool<Trade>(ringBuffer,barrier,new IgnoreExceptionHandler(),workHandler);
        workerPool.start(executor);
        for(int i=0;i<8;i++){
            long seq=ringBuffer.next();
            ringBuffer.get(seq).setPrice(Math.random()*9999);
            ringBuffer.publish(seq);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        workerPool.halt();
        executor.shutdown();
    }
}
