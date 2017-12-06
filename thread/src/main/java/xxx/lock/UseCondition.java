package xxx.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UseCondition {
    /**
     * 我们之前在学习使用Synchronized的时候,多线程间的等待和通知是通过Object的wait()和notify()、notifyAll()去实现
     * 我们再使用Lock的时候,是使用Condition类去实现等待和通知操作
     */

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void method01(){
        try {
            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入等待状态...");
            Thread.sleep(3000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "释放锁...");
            condition.await();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "继续执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 一定要释放锁
            lock.unlock();
        }
    }

    public void method02(){
        try {
            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
            Thread.sleep(3000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "发出唤醒...");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 一定要释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final UseCondition uc = new UseCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.method01();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.method02();
            }
        },"t2");
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
