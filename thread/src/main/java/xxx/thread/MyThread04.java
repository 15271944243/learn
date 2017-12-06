package xxx.thread;

/**
 * 脏读
 * 在我们对一个对象的方法加锁时,需要考虑到业务的整体性,
 * 即setValue/getValue方法同时加上synchronized关键字,保持业务的原子性,
 * 不然会出现业务错误(可以把getValue方法的synchronized关键字去掉,然后看看运行结果)
 */
public class MyThread04 {

    private String username = "xxx";
    private String password = "123456";

    public synchronized void setValue(String username,String password){
        this.username = username;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
        System.out.println("setValue最终结果: username = " + username + ",password = " + password);
    }

    public synchronized void getValue(){
        System.out.println("getValue最终结果: username = " + this.username + ",password = " + this.password);
    }

    public static void main(String[] args) throws InterruptedException {
        final MyThread04 mo = new MyThread04();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.setValue("asdf","sdf");
            }
        });
        t1.start();
        Thread.sleep(1000);
        mo.getValue();
    }
}
