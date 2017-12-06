package xxx.thread;

/**
 * 对于web应用程序,异常释放锁的情况,如果不及时处理,很可能对你的应用程序业务逻辑产生严重的错误,
 * 比如你现在执行一个队列任务,很多对象都在等待第一个对象正确的执行完毕再去释放锁,
 * 但是第一个对象由于异常出现,导致业务逻辑没有正常执行完毕,就释放了锁,那么很可能对后续的对象产生影响
 * 就相当于队列任务中的某个对象生产异常,那么是否整个队列都需要回滚呢,这就是开发者需要考虑的问题
 */
public class MyThread07 {
    private int i = 0;
    public synchronized void operation(){
        while (true){
            try {
                i++;
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + " ,i = " + i);
                if(i == 10){
                    Integer.parseInt("a");
                    // throw new RuntimeException();
                }
            } catch (Exception e) { // InterruptedException
                e.printStackTrace();
                System.out.println("log info i = " + i);
                // throw new RuntimeException();
                // continue;
            }
        }
    }

    public static void main(String[] args) {
        final MyThread07 mo = new MyThread07();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.operation();
            }
        },"t1");
        t1.start();
    }
}
