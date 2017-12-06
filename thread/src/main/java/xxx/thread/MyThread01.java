package xxx.thread;

public class MyThread01 extends Thread{
    private int count = 5;

    // synchronized加锁
    @Override
    public synchronized void run() {
        count--;
        System.out.println(this.currentThread().getName() + " count= " + this.count);
    }

    public void main(String[] args) {
        /**
         * 当多个线程访问MyThread01的run方法时,以排队的方式进行处理(这里的排队时安装CPU分配的先后顺序而定)
         * 一个线程想要执行synchronized修饰的方法时:
         *    1.尝试得到锁
         *    2.如果拿到锁,执行synchronized代码体内容;拿不到锁,这个线程就会不断尝试获得这把锁,直到拿到为止,
         *    而且是多个线程同时去竞争这把锁.(也就是会有锁竞争问题)
         */
        MyThread01 myThread01 = new MyThread01();
        Thread t1 = new Thread(myThread01,"t1");
        Thread t2 = new Thread(myThread01,"t2");
        Thread t3 = new Thread(myThread01,"t3");
        Thread t4 = new Thread(myThread01,"t4");
        Thread t5 = new Thread(myThread01,"t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
