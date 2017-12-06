package xxx.thread;

public class MyThread02 {
    /**
     * 关键字synchronized取得的锁都是对象锁,而不是把一段代码(方法)当作锁
     * 所以哪个线程先执行synchronized关键字修饰的方法,哪个线程就持有该方法所属对象的锁
     *
     * 在静态方法上加上synchronized关键字,表示锁定.class类,类一级别的锁(独占.class类)
     * 可以在将下面printNum方法和num属性都加上static试试
     */
    private int num = 0;

    public synchronized void printNum(String tag){
        try {
            if("a".equals(tag)){
                num = 100;
                System.out.println("tag a,set num over!");
                Thread.sleep(1000);
            }else{
                num = 200;
                System.out.println("tag b,set num over!");
            }
            System.out.println("tag " + tag + ", num = " + num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 注意观察run方法的输出顺序
        // 两个不同对象,线程获得的就是不同的锁,他们互不影响
        final MyThread02 m1 = new MyThread02();
        final MyThread02 m2 = new MyThread02();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }
}
