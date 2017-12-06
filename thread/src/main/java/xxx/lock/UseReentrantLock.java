package xxx.lock;

import java.util.concurrent.locks.ReentrantLock;

public class UseReentrantLock {
    private ReentrantLock lock = new ReentrantLock();

    public void method01(){
        try {
            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method01...");
            Thread.sleep(1000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method01...");
            Thread.sleep(1000);
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
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method02...");
            Thread.sleep(2000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method02...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 一定要释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final UseReentrantLock ur = new UseReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ur.method01();
                ur.method02();
            }
        },"t1");
        t1.start();
    }
}
