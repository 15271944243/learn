package xxx.thread;

import java.util.*;

/**
 * 同步类容器:如古老的Vector、HashTable。这些容器的同步功能都是由JDK的Collections.synchronized***等工厂方法去创建的。
 * 其底层的机制无非就是用传统的synchronized关键字对每个公用的方法都进行同步,使得每次只有一个线程能访问容器的状态。
 * 这很明显不满足我们今天互联网时代高并发的需求,在保证线程安全的同时,也必须有足够好的性能。
 * 同步类容器都是线程安全的,但在某些场景下需要用加锁来保护复合操作。
 * 复合类操作如:迭代(反复访问元素,遍历完容器所有元素)、跳转(根据指定的顺序找到当前元素的下一个元素)、
 * 以及条件运算。这些复合操作在多线程并发的修改容器时,可能表现出意外的行为,
 * 最经典的便是ConcurrentModificationException,原因是当容器迭代的过程中,
 * 被并发地修改了内容,这是由于早期迭代器设计的时候并没有考虑并发修改的问题。
 */
public class MyThread16 {

    public static void main(String[] args) {
        // 初始化火车票池并添加火车票:避免线程同步可以采用Vector代替ArrayList  HashTable代替HashMap

        final Vector<String> tickets = new Vector<String>();

        // Map<String,String> map = Collections.synchronizedMap(new HashMap<String,String>());

        for(int i=0;i<100;i++){
            tickets.add("火车票"+i);
        }

        for(Iterator iterator = tickets.iterator(); iterator.hasNext();){
            String ticket = (String)iterator.next();
            tickets.remove(20);
        }

        /*for(int i=0;i<10;i++){
            new Thread("线程"+i){
                @Override
                public void run() {
                    while (true){
                        if(tickets.isEmpty()) break;
                        System.out.println(Thread.currentThread().getName()+"----"+tickets.remove(0));
                    }
                }
            }.start();
        }*/
    }
}
