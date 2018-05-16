package xxx.test006;

/**
 * @description: 下面的程序输出的结果是()
 * 实现类能使用接口的常量  为什么?
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/16
 */
public class B implements A{

    public static void main(String[] args) {
        int i;
        B b = new B();
        i = b.k;
        System.out.println("i="+i);
    }
}
