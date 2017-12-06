package xxx.thread;

/**
 *  锁对象的改变问题,当使用一个对象进行加锁的时候,要注意对象本身发生改变的时候,
 *  那么持有的锁就不同。如果对象本身不发生改变,那么依然是同步的,及时对象的属性发生了改变
 */
public class MyThread10 {
    private String lock = "lock";

    public void method(){
        synchronized (lock) {
            try {
                System.out.println("当前线程: "+ Thread.currentThread().getName() + " 开始");
                lock = "change lock";
                Thread.sleep(1000);
                System.out.println("当前线程: "+ Thread.currentThread().getName() + " 结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final MyThread10 mo = new MyThread10();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method();
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
