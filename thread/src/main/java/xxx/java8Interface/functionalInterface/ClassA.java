package xxx.java8Interface.functionalInterface;

/**
 * @description: 如果一个类实现了某个拥有default方法的接口的话，在该类中则不需要自己再次实现该default方法了。
 * 但是如果该类实现接口时，还继承了某个抽象类，该抽象类拥有一个和default签名一样的抽象方法，则在该类中必须重写抽象方法(也是接口中的该default方法)：
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
public class ClassA extends ClassB implements FunctionalInterfaceDemo{

    /**
     * 只需要实现抽象方法就行了
     */
    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    @Override
    public void study() {
        System.out.println("hello study");
    }

    public static void aaa(){
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        ((ClassA)null).aaa();
        ((ClassA)null).sayHello();
    }
}
