package xxx.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UseManyCondition {
    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public void method01(){
        try {
            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入方法method01等待...");
            c1.await();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "在方法method01继续执行...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 一定要释放锁
            lock.unlock();
        }
    }

    public void method02(){
        try {
            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入方法method02等待...");
            c1.await();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "在方法method02继续执行...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 一定要释放锁
            lock.unlock();
        }
    }

    public void method03(){
        try {
            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入方法method03等待...");
            c2.await();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "在方法method03继续执行...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 一定要释放锁
            lock.unlock();
        }
    }

    public void method04(){
        try {
            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "唤醒...");
            c1.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 一定要释放锁
            lock.unlock();
        }
    }

    public void method05(){
        try {
            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "唤醒...");
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 一定要释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final UseManyCondition uc = new UseManyCondition();
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
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.method03();
            }
        },"t3");
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.method04();
            }
        },"t4");
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.method05();
            }
        },"t5");
        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t4.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t5.start();
    }
}
