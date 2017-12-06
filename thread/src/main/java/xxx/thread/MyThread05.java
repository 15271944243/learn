package xxx.thread;

/**
 * synchronized的可重入性
 * 当线程请求一个由其它线程持有的对象锁时，该线程会阻塞，
 * 而当线程请求由自己持有的对象锁时，如果该锁是重入锁,请求就会成功,否则阻塞。
 * java中获取锁的操作的粒度是“线程”，而不是“调用”，即不是每一次调用都是建立一个锁。
 */
public class MyThread05 {
    public synchronized void method01(){
        System.out.println("method01...");
        method02();
    }

    public synchronized void method02(){
        System.out.println("method02...");
        method03();
    }

    public synchronized void method03(){
        System.out.println("method03...");
    }

    public static void main(String[] args) {
        final MyThread05 mo = new MyThread05();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method01();
            }
        });
        t1.start();
    }
}
