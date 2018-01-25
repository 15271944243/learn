package xxx.java8Interface.defaultInterface;

/**
 * @description: Java8 interface default method
 * Default方法是指，在接口内部包含了一些默认的方法实现（也就是接口中可以包含方法体，这打破了Java之前版本对接口的语法限制），
 * 从而使得接口在进行扩展的时候，不会破坏与接口相关的实现类代码。
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
public interface InterfaceC extends InterfaceA,InterfaceB{
    /**
     * InterfaceC 如果只继承InterfaceA,不会编译错误
     * InterfaceC 如果只继承InterfaceB,不会编译错误
     * InterfaceC 如果同时继承如果只继承InterfaceA,InterfaceB,编译错误
     * 这时候,要在InterfaceC里面重写say(),才不会报错
     */

    @Override
    default String say(String name) {
        return "InterfaceC  " + name;
    }
}
