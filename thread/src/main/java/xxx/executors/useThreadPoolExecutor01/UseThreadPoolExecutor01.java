package xxx.executors.useThreadPoolExecutor01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UseThreadPoolExecutor01 {
    public static void main(String[] args) {
        /**
         * 若Executors工厂类无法满足我们的需求,可以自己去创建自定义线程池;
         * Executors工厂类创建线程池的方法均是用了ThreadPoolExecutor类,
         * 可以使用ThreadPoolExecutor去自定义线程池
         */

        /**
         * ThreadPoolExecutor类的构造方法里,BlockingQueue<Runnable> workQueue这个参数很关键
         * 在workQueue使用有界队列时(比如ArrayBlockingQueue),若有新的任务需要执行,如果线程池里的实际线程数小于corePoolSize,
         * 则优先去创建线程执行任务,若大于corePoolSize,则会将任务放入workQueue中,若workQueue已满,
         * 则在总线程数不大于maximumPoolSize前提下,创建新的线程,若总线程数大于maximumPoolSize，
         * 则执行拒绝策略(RejectedExecutionHandler handler)
         */
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(3);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,
                2,
                60,
                TimeUnit.SECONDS,
                arrayBlockingQueue,
                new MyRejected());
        MyTask task01 = new MyTask(1,"任务1");
        MyTask task02 = new MyTask(2,"任务2");
        MyTask task03 = new MyTask(3,"任务3");
        MyTask task04 = new MyTask(4,"任务4");
        MyTask task05 = new MyTask(5,"任务5");
        MyTask task06 = new MyTask(6,"任务6");

        pool.execute(task01);
        pool.execute(task02);
        pool.execute(task03);
        pool.execute(task04);
        pool.execute(task05);
        pool.execute(task06);
        pool.shutdown();
    }
}
