package xxx.thread;

import java.util.Date;

public class Test4 extends Date{
    private static final long serialVersionUID = 1L;
    private void test(){
        System.out.println(super.getClass().getName());
    }

    public static void main(String[]args){
        new Test4().test();
    }
}
