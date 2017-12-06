package xxx.thread;

/**
 * 单例模式,最常见的就是饥饿模式和懒汉模式,一个直接实例化对象,一个在调用方法时进行实例化对象。
 * 在多线程模式中,考虑到性能和线程安全问题,我们一般选择下面两种比较经典的单例模式,
 * 在性能提高的同时,又保证了线程安全:double check instance  static inner class
 * 当前类就是static inner class
 */
public class InnerSingleton extends Thread{

    private static class Singleton{
        private static Singleton single = new Singleton();
    }

    public static Singleton getInstance(){
        return Singleton.single;
    }

}
