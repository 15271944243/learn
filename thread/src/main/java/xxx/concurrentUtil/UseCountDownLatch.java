package xxx.concurrentUtil;

import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch {
    /**
     * CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能,
     * 能够使一个线程等待其他线程完成各自的工作后再执行。
     * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了
     */
    public static void main(String[] args) {
        final CountDownLatch countDown = new CountDownLatch(2);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入线程t1,等待其他线程处理完成...");
                    countDown.await();
                    System.out.println("t1线程继续执行...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入线程t2,等待其他线程处理完成...");
                    countDown.await();
                    System.out.println("t2线程继续执行...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t3线程进行操作...");
                    Thread.sleep(3000);
                    System.out.println("t3线程操作完毕,通知t1/t2线程继续执行...");
                    countDown.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t4线程进行操作...");
                    Thread.sleep(4000);
                    System.out.println("t4线程操作完毕,通知t1/t2线程继续执行...");
                    countDown.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
