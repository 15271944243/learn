package xxx.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * notify和wait必须配合synchronized使用
 * wait方法释放锁,notify不释放锁
 */
public class MyThread14 extends Thread{

    private volatile static List list = new ArrayList();

    public void add(){
        list.add("bjsxt");
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        final MyThread14 mt = new MyThread14();
        // 实例化出一个lock
        // 当使用wait和notify的时候,一定要配合synchronized关键字去使用
        final Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        for(int i=0;i<10;i++){
                            mt.add();
                            System.out.println("当前线程: " + Thread.currentThread().getName() + " 添加了一个元素");
                            Thread.sleep(500);
                            if(mt.size() == 5){
                                System.out.println("已经发出通知...");
                                lock.notify();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    if(mt.size() != 5){
                        try {
                            System.out.println("当前线程: " + Thread.currentThread().getName() + " 进入");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前线程: " + Thread.currentThread().getName() + " size 为" + mt.size());
                    System.out.println("当前线程: " + Thread.currentThread().getName() + " 收到通知线程停止...");
                    throw new RuntimeException();
                }

            }
        },"t2");

        // 使用CountDownLatch替代notify和wait,更实时的返回结果
        /*final CountDownLatch countDownLatch = new CountDownLatch(1);
        thread t1 = new thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<10;i++){
                        mt.add();
                        System.out.println("当前线程: " + thread.currentThread().getName() + " 添加了一个元素");
                        thread.sleep(500);
                        if(mt.size() == 5){
                            System.out.println("已经发出通知...");
                            countDownLatch.countDown();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");
        thread t2 = new thread(new Runnable() {
            @Override
            public void run() {
                if(mt.size() != 5){
                    try {
                        System.out.println("当前线程: " + thread.currentThread().getName() + " 进入");
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("当前线程: " + thread.currentThread().getName() + " size 为" + mt.size());
                System.out.println("当前线程: " + thread.currentThread().getName() + " 收到通知线程停止...");
                throw new RuntimeException();
            }
        },"t2");*/

        t2.start();
        t1.start();
    }
}
