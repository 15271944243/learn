package xxx.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  volatile关键字不具备synchronized关键字的原子性。
 *  要实现原子性建议使用atomic类的系列对象,支持原子性操作
 */
public class MyThread12 extends Thread{
    /** 替换掉注释的代码试试运行结果 **/
    //private static volatile int count;
    private static AtomicInteger count = new AtomicInteger(0);

    private static void addCount(){
        for(int i=0;i<1000;i++){
            //count++;
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] args) {
        MyThread12[] arr = new MyThread12[10];
        for(int i=0;i<10;i++){
            arr[i] = new MyThread12();
        }
        for(int i=0;i<10;i++){
            arr[i].start();
        }
    }
}
