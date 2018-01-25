package xxx.java8Interface.functionalInterface;

/**
 * @description: @FunctionalInterface 表明该接口是一个函数式接口,只能拥有一个抽象方法
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
@FunctionalInterface
public interface FunctionalInterfaceDemo {

    /**
     * 只能有一个抽象方法
     */
    void sayHello();

    /**
     * default方法必须有具体的实现
     */
    default void study(){
        System.out.println("xxx love study");
    }

    /**
     * 可以拥有多个default方法
     */
    default void study2(){
        System.out.println("xxx love study2");
    }

    /**
     * static方法必须有具体的实现
     */
    static void sleep(){
        System.out.println("xxx is sleeping");
    }

    /**
     * 可以拥有多个static方法
     */
    static void sleep2(){
        System.out.println("xxx is sleeping2");
    }
}
