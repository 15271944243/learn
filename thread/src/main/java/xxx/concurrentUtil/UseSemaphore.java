package xxx.concurrentUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class UseSemaphore {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semaphore = new Semaphore(5);
        // 模拟20个客户端访问
        for(int i=0;i<20;i++){
            final int NO = i;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        //获得许可
                        semaphore.acquire();
                        System.out.println("Accessint: " + NO);
                        // 模拟实际业务逻辑
                        Thread.sleep((long)(Math.random() * 10000));
                        // 访问完后,释放
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executor.execute(run);
        }
        executor.shutdown();
    }
}
