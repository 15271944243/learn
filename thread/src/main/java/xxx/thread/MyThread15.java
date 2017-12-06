package xxx.thread;

/**
 * ThreadLocal:线程局部变量,是一种多线程间并发访问变量的解决方案。
 * 与synchronized等加锁的方式不用,ThreadLocal完全不提供锁,
 * 而是使用空间换时间的手段,为每个线程提供变量的独立副本,以保证线程安全。
 * 从性能上来说,ThreadLoacl不具有绝对的优势,在并发不是很高的时候,加锁的性能会更好,
 * 但作为一套与锁完全无关的线程安全解决方案,在高并发量或者锁竞争激烈的场景,
 * 使用ThreadLocal可以一定程度上减少锁竞争。（可以去看看Spring的事务管理部分的源码,有用到）
 */
public class MyThread15 extends Thread{

    public static ThreadLocal<String> th = new ThreadLocal<>();

    public void getTh() {
        System.out.println(Thread.currentThread().getName() + " : " + th.get());
    }

    public void setTh(String value) {
        th.set(value);
    }

    public static void main(String[] args) {
        final MyThread15 mt = new MyThread15();
        // 实例化出一个lock
        // 当使用wait和notify的时候,一定要配合synchronized关键字去使用
        final Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mt.setTh("张三");
                mt.getTh();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    mt.getTh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"t2");
        t2.start();
        t1.start();
    }
}
