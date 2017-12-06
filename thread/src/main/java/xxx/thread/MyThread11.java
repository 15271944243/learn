package xxx.thread;

/**
 *  volatile：volatile修饰的变量不允许线程内部缓存和重排序，即直接修改内存。所以对其他线程是可见的。
 *  但是这里需要注意一个问题，volatile只能让被他修饰内容具有可见性，但不能保证它具有原子性。
 *  比如 volatile int a = 0；之后有一个操作 a++；这个变量a具有可见性，但是a++ 依然是一个非原子操作，也就是这个操作同样存在线程安全问题。
 *  （简要说volatile关键字的作用是使变量在多个线程间可见）
 */
public class MyThread11 extends Thread{
    /** 这里把isRunning的volatile关键字去掉试试运行结果 **/
    private volatile boolean isRunning = true;
    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void run(){
        System.out.println("进入run方法...");
        while(isRunning){

        }
        System.out.println("线程停止");
    }



    public static void main(String[] args) {
        try {
            MyThread11 mo = new MyThread11();
            mo.start();
            Thread.sleep(3000);
            mo.setRunning(false);
            System.out.println("isRunning的值被设置成了false");
            Thread.sleep(1000);
            System.out.println(mo.isRunning);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
