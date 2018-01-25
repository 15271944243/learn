package xxx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test extends App{


    // 面试题1:下列代码编译是否报错，如果不报错,输出的x值是多少
    /*private static int x= 100;

    public static void main(String[] args) {
        Test t1 = new Test();
        t1.x++;
        Test t2 = new Test();
        t2.x++;
        t1 = new Test();
        t1.x++;
        Test.x--;
        System.out.println("x="+x);
    }*/

    // 面试题2:下列代码运行结果是什么
    /*public static int aMethod(int i)throws Exception {
        try{
            return i / 10;
        } catch (Exception ex) {
            throw new Exception("exception in a Method");
        } finally{
            System.out.printf("finally");
        }
    }

    public static void main(String [] args) {
        try {
            aMethod(0);
        } catch (Exception ex) {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }*/

    // 面试题3:下列代码运行结果是什么
    /*static int arr[] = new int[5];
    public static void main(String[] args) {
        int x,y;
        int arr2[] = new int[5];
        x=5>>2;
        y=x>>>2;
        System.out.println(y);
        // 数组无论是在定义为实例变量还是局部变量，若没有初始化，都会被自动初始化
        System.out.println(arr[0]);
        System.out.println(arr2[0]);
    }*/

    /*public static void main(String[] args) {
        int x=1;
        float y = 2;
        System.out.println(x/y);
        // Arrays.asList();
        char[] chars = new char[]{'a','b','c'};
        String a = "abc";
        a.toLowerCase();
        System.out.println(a.equals(chars));
    }*/

    /*class Two{
        Byte x;
    }
    public static void main(String[] args){
        //Test p=new Test();
        //p.start();
        Test a = new Test();
        Test b = new Test();
        a.equals(b);
    }
    void start(){
        Two t=new Two();
        System.out.print(t.x+"");
        Two t2=fix(t);
        System.out.print(t.x+"" +t2.x);
    }
    Two fix(Two tt){
        tt.x=42;
        return tt;
    }*/

    static boolean Paddy;
    static byte[] src,dst;


    public static void main(String[] args) {
        /*ReentrantLock a = new ReentrantLock();
        a.notify();*/
        // Integer i = new Integer(59);
        //Integer.valueOf();
        // System.out.println(Paddy);
        /*try {
            dst = new String(src,"GBK").getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        // 这里会出现数组越界异常,因为int[] a = new int[]{};相当于int[] a = new int[0];
//        int[] a = new int[]{};
//        a[0] = 1;
//        a[1] = 2;
        Test a0 = new Test();
        Test a1 = new Test2();
        Test a2 = new Test3();

        short a = 128; byte b = (byte) a;
        System.out.println("a="+a+",b="+b);

        System. out. println(10 % 3 * 2);

        int i = 0;
        for ( foo('A'); foo('B') && (i < 2); foo('C'))
        {
            i++ ;
            foo('D');
        }

        Test2 t1 = new Test2("a");
        Test2 t2 = new Test2("b");
        Test2 t3 = new Test2("c");
        List<Test2> l = new ArrayList<>();
        l.add(t1);
        l.add(t2);
        l.add(t3);
        Test2[] arr = l.toArray(new Test2[]{});
        System.out.println(arr);

        String[] arr2 = new String[]{"a","v","c"};
        List<String> strList = Arrays.asList(arr2);
        strList.add("f");
        System.out.println("----------");
    }

    static boolean foo(char c)
    {
        System.out.print(c);
        return true;
    }
}
