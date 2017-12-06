package xxx.thread;

/**
 * 对象锁的同步和异步
 */
public class MyThread03 {
    public synchronized void method1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public /*synchronized*/ void method2(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        final MyThread03 mo = new MyThread03();
        // t1线程先持有object对象的Lock锁,t2线程如果在这个时候调用object对象中的同步(synchronized)方法则需等待,这就是同步
        // t1线程先持有object对象的Lock锁,t2线程可以以异步的方式代用object对象中的非synchronized修饰的方法
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method1();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method2();
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
