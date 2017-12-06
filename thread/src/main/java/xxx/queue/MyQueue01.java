package xxx.queue;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用wait和notify模拟queue
 * 创建一个queue,支持阻塞的机制阻塞的放入和得到数据
 * put(anObject):把anObject放入到queu中,如果queue没有空间,则调用此方法的线程被阻塞,直到queue里有空间再继续
 * take:取走queue里排在首位的对象,若queue为空,阻塞进入等待状态直到queue有新数据加入
 */
public class MyQueue01 {
    // 1.需要一个承装元素的集合
    private final LinkedList<Object> list = new LinkedList<>();
    // 2.需要一个计数器,记录集合大小
    private AtomicInteger count = new AtomicInteger(0);
    // 3.需要集合上限和下限
    private final int minSize = 0;
    private final int maxSize;
    // 4.初始化一个对象,用于加锁
    private final Object lock = new Object();

    public MyQueue01(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(Object obj){
        synchronized (lock){
            try {
                while (count.get() == this.maxSize){
                    lock.wait();
                }
                list.add(obj);
                System.out.println("新添加的元素为:" + obj);
                count.incrementAndGet();
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Object take(){
        Object obj = null;
        synchronized (lock){
            try {
                while (count.get() == this.minSize){
                    lock.wait();
                }
                obj = list.removeFirst();
                count.decrementAndGet();
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    public int getSize(){
        return this.count.get();
    }

    public static void main(String[] args) {
        try {
            final MyQueue01 mq = new MyQueue01(5);
            mq.put("a");
            mq.put("b");
            mq.put("c");
            mq.put("d");
            mq.put("e");
            System.out.println("当前容器的长度:"+mq.getSize());
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    mq.put("f");
                    mq.put("g");
                }
            },"t1");
            t1.start();

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Object o1 = mq.take();
                    System.out.println("移除的元素为:" + o1);
                    Object o2 = mq.take();
                }
            },"t2");
            TimeUnit.SECONDS.sleep(2);
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
