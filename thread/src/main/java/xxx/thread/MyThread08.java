package xxx.thread;

/**
 *  使用synchronized代码块进行加锁(synchronized的其他使用语法)
 */
public class MyThread08 {

    public void method01(){
        synchronized (this) {   // 对象锁
            // this指当前MyThread08这个对象
            try {
                System.out.println("do method01...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void method02(){
        synchronized (MyThread08.class){  // 类锁
            try {
                System.out.println("do method02...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Object lock = new Object();
    public void method03(){
        synchronized (lock){  // 任何对象锁
            try {
                System.out.println("do method03...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final MyThread08 mo = new MyThread08();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method01();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method02();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method03();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
