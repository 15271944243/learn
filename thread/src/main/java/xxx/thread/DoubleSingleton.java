package xxx.thread;

/**
 * 单例模式,最常见的就是饥饿模式和懒汉模式,一个直接实例化对象,一个在调用方法时进行实例化对象。
 * 在多线程模式中,考虑到性能和线程安全问题,我们一般选择下面两种比较经典的单例模式,
 * 在性能提高的同时,又保证了线程安全:double check instance  static inner class
 * 当前类就是ouble check instance
 */
public class DoubleSingleton extends Thread{

    private static DoubleSingleton ds;

    public static DoubleSingleton getDs() {
        if(ds == null){
            try {
                // 模拟初始化对象的准备时间
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DoubleSingleton.class){
                // 可以把这个if判断去掉试试,看看打印出来的hashCode是否一样
                //ds = new DoubleSingleton();
                if(ds == null){
                    ds = new DoubleSingleton();
                }
            }
        }
        return ds;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DoubleSingleton.getDs().hashCode());
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DoubleSingleton.getDs().hashCode());
            }
        },"t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DoubleSingleton.getDs().hashCode());
            }
        },"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
