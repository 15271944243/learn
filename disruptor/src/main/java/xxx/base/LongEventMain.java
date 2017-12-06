package xxx.base;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://ifeve.com/disruptor-getting-started/
 */
public class LongEventMain {

    public static void main(String[] args) throws Exception {
        // 创建线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        // 创建工厂
        LongEventFactory factory = new LongEventFactory();
        // 创建BufferSize,也就是RingBuffer的大小,必须是2的n次方
        int ringBufferSize = 1024 * 1024;
        // 创建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory,ringBufferSize,executor,ProducerType.SINGLE,new YieldingWaitStrategy());

        // ProducerType.SINGLE  一个生产者,用ProducerType.SINGLE
        // ProducerType.MULTI   多个生产者的时候,用ProducerType.MULTI

        // 生产端和消费端效率不一致时(生产快,消费慢/生产慢,消费快)的一种协调(等待)策略
        // BlockingWaitStrategy 是最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现
        // WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
        // SleepingWaitStrategy 的性能表现跟BlockingWaitStrategy差不多，对CPU的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景
        // WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
        // YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于CPU逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性
        // WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();

        // 连接消费事件
        disruptor.handleEventsWith(new LongEventHandler());
        // 启动
        disruptor.start();
        // 开始发布事件
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        // LongEventProducer producer = new LongEventProducer(ringBuffer);     // 可以换成下面注释代码的方式
        LongEventProducerWithTranslator producer = new LongEventProducerWithTranslator(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for(long l = 0;l<100L;l++){
            bb.putLong(0,l);
            producer.onData(bb);
        }
        disruptor.shutdown();//关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
        executor.shutdown(); //关闭 disruptor 使用的线程池；如果需要的话，必须手动关闭， disruptor 在 shutdown 时不会自动关闭；
    }
}
