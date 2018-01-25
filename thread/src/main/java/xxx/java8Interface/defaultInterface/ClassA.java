package xxx.java8Interface.defaultInterface;

/**
 * @description:
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/1/25
 */
public class ClassA implements InterfaceA,InterfaceB{

    /**
     * ClassA 如果只继承InterfaceA,不会编译错误
     * ClassA 如果只继承InterfaceB,不会编译错误
     * ClassA 如果同时继承如果只继承InterfaceA,InterfaceB,编译错误
     * 这时候,要在ClassA里面重写say(),才不会报错
     */
    @Override
    public String say(String name) {
        return "ClassA  " + name;
    }
}
