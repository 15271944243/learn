package xxx.thread;

/**
 *  不要使用String的常量去加锁
 */
public class MyThread09 {

    public void method(){
        synchronized ("字符串常量") { // 这里可以替换成 new String("字符串常量") 去看看效果
            try {
                while (true){
                    System.out.println("当前线程: "+ Thread.currentThread().getName() + " 开始");
                    Thread.sleep(1000);
                    System.out.println("当前线程: "+ Thread.currentThread().getName() + " 结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final MyThread09 mo = new MyThread09();
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
        t2.start();
    }
}
