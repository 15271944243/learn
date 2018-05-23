package xxx.test009;

import xxx.test010.Test010;

/**
 * @description: 子类构造方法在调用时必须先调用父类的，由于父类没有无参构造，必须在子类中显式调用，在子类构造方法加入： super(s);
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/17
 */
public class Derived extends Base{
    public Derived (String s) {
        super(s);
        System.out.print("D");
    }
    public static void main(String[] args){
        new Derived("C");
    }
}
