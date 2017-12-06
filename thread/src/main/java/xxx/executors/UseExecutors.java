package xxx.executors;

import java.util.concurrent.*;

public class UseExecutors {
    public static void main(String[] args) {
        /**
         * 该方法返回一个固定数量的线程池,线程池内的线程数始终不变
         * 当有一个任务提交时,若线程池中有空闲线程,则立即执行,
         * 若没有,则会被暂缓在一个任务队列中等待空闲线程去执行它
         */
        //ExecutorService pool = Executors.newFixedThreadPool(10);
        /**
         * 该方法返回一个只有一个线程的线程池
         * 当有一个任务提交时,若线程池中有空闲线程,则立即执行,
         * 若没有,则会被暂缓在一个任务队列中等待空闲线程去执行它
         */
        //ExecutorService pool = Executors.newSingleThreadExecutor();
        /**
         * 该方法返回一个可根据实际情况调整线程个数的线程池,不限制最大线程数量
         * 当有一个任务提交时,若有空闲线程则用空闲线程执行任务,若无空闲线程则创建线程
         * 若无任务则不创建线程
         * 每一个空闲线程会在60秒内自动回收
         */
        //ExecutorService pool = Executors.newCachedThreadPool();
        /**
         *
         */
        //Executors.newScheduledThreadPool(10);

    }
}
