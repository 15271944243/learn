package xxx.concurrentUtil;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseCyclicBarrier {
    /**
     * CyclicBarrier类位于java.util.concurrent包下。
     * 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。
     * 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。
     * 我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。
     * CyclicBarrier 可以重复利用，这个是CountDownLatch做不到的
     */

    /**
     * 假设有一个场景:每个线程代表一个跑步运动员,当运动员都准备好后,发令枪响,所以运动员一起起跑,
     * 只要发令枪没有响,那么所有运动员都等着,不允许起泡
     */
    static class Runner implements Runnable{
        private CyclicBarrier cyclicBarrier;
        private String name;

        public Runner(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * (new Random()).nextInt(5));
                System.out.println(name + "准备OK");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + " GO!");
        }
    }
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new Thread(new Runner(barrier,"张三")));
        executor.execute(new Thread(new Runner(barrier,"李四")));
        executor.execute(new Thread(new Runner(barrier,"王五")));
        executor.shutdown();
    }
}
