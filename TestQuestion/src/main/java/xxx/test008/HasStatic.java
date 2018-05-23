package xxx.test008;

/**
 * @description:
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/17
 */
public class HasStatic {
    private static int x = 100;
    public static void main(String args[ ]){
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1=new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println( "x=" +x);

        String s1="abc"+"def";//1
        String s2=new String(s1);//2
    }
}
