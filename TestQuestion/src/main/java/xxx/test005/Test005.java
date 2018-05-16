package xxx.test005;

/**
 * @description: What will happen when you attempt to compile and run the following code?
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/14
 */
public class Test005 {
    static{
        // JVM加载class文件时，就会执行静态代码块，静态代码块中初始化了一个变量x并初始化为5，
        // 由于该变量是个局部变量，静态代码快执行完后变被释放。不影响静态变量x的值。
        int x=5;
    }
    static int x,y;
    public static void main(String args[]){
        int i;
        x--;                               // -1
        myMethod();
        System.out.println(x+y+ ++x);     // 1 + 0 + 2
    }
    public static void myMethod(){
        y=x++ + ++x;              // y = -1 + 1 = 0  x = 1
    }
}
