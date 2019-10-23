package xxx.initializeSort;

/**
 * @Description:
 * @Auther: xiaoxiaoxiang
 * @Date: 2018/10/8 18:20
 */
public class Child extends Parent {

    private int radius = 1;

    void doSomething() {
        System.out.println("Child.doSomething(). radius = " + radius);
    }

    public Child(int radius) {
        this.radius = radius;
        System.out.println("Child.doSomething(). radius = " + radius);
    }
}
