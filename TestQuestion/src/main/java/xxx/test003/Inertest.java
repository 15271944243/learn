package xxx.test003;



import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/8
 */
public class Inertest {
    public static void main(String[]args) throws Exception{
        Enclosingone eo = new Enclosingone();
        Enclosingone.InsideOne is = eo.new InsideOne();

/*
        FileInputStream fis = new FileInputStream("F:\\t0.png");
        BufferedInputStream bis = new BufferedInputStream(fis);
        java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            bos.write(buff, 0, len);
        }
        // 得到图片的字节数组
        byte[] result = bos.toByteArray();
        System.out.println(Arrays.toString(result));
*/
        String[] a1 = {"1","2","3","4"};
        System.arraycopy(a1,2,a1,1,2);
        a1[3] = null;
        System.out.println(11111);

        List<Integer> NumberList =new ArrayList<Integer>();
        NumberList.add(2);
        NumberList.add(4);
        NumberList.add(1);
        NumberList.add(3);
        NumberList.add(5);
        for(int i =0;i<NumberList.size();++i) {
            int v = NumberList.get(i);
            if(v%2==0) {
                NumberList.remove(v);
            }
        }
        System.out.println(NumberList);
    }
}
