package xxx.executors.useThreadPoolExecutor02;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UseThreadPoolExecutor02 implements Runnable{

    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            int temp = count.incrementAndGet();
            System.out.println("任务"+temp);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /**
         * 在workQueue使用有无队列时(比如LinkedBlockingQueue)。与有界队列相比,除非系统资源耗尽,
         * 否则无界队列不存在任务入队失败的情况。当有新任务需要执行时,如果线程池里的实际线程数小于corePoolSize,
         * 则优先去创建线程执行任务;当线程池里的实际线程数等于corePoolSize后,线程池就不会去继续创建线程,
         * 若后续有新任务需要执行,而没有空闲的线程资源,则会将任务放入workQueue中。若任务的生产和消费速度差异很大,
         * workQueue会保持快速增长,直到耗尽系统内存。
         */
        // ExecutorService
        try {
            // ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
            LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
            ThreadPoolExecutor pool = new ThreadPoolExecutor(5,10,120L, TimeUnit.SECONDS,queue);
            for(int i=0;i<20;i++){
                pool.execute(new UseThreadPoolExecutor02());
            }
            Thread.sleep(1000);
            System.out.println("queue size:" + queue.size());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
