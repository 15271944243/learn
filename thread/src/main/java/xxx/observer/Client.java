package xxx.observer;

/**
 * @description:
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject obj = new ConcreteSubject();
        MyObserver myObserver = new MyObserver();
        obj.addObserver(myObserver);
        obj.set(123);
    }
}
