package xxx.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UseReadWriteLock {
    /**
     * ReentrantReadWriteLock:读写锁,其核心就是实现读写分离的锁。
     * 在高并发访问下,尤其是读多写少的情况下,性能要远高于重入锁。
     * 之前学习Synchronized、ReentrantLock时,我们知道,在同一时间内,
     * 只能有一个线程访问被锁定的代码,但是读写锁不同,其本质是两个锁,
     * 即读锁、写锁。在读锁下,多线程可以并发的进行访问,但是在写锁下,
     * 只能一个一个的顺序访问。
     * 口诀:读读共享、写写互斥、读写互斥
     */

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock  readLock = rwLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    public void read(){
        try {
            readLock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
            Thread.sleep(3000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void write(){
        try {
            writeLock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
            Thread.sleep(3000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        final UseReadWriteLock uc = new UseReadWriteLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.read();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.read();
            }
        },"t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.write();
            }
        },"t3");
        t1.start();
        t2.start();

        /*t1.start();
        t3.start();*/
    }
}
