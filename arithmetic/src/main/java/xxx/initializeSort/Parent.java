package xxx.initializeSort;

/**
 * @Description:
 * @Auther: xiaoxiaoxiang
 * @Date: 2018/10/8 18:20
 */
public class Parent {

    void doSomething() {
        System.out.println("Parent.doSomething()");
    }

    public Parent() {
        System.out.println("before Parent.doSomething()");
        doSomething();
        System.out.println("after Parent.doSomething()");
    }
}
