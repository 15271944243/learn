package xxx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App<T> {
    public int i1=0;
    int i2=0;
    protected int i3=0;
    private int i4=0;

    public void method1(){

    }
    void method2(){

    }
    protected void method3(){

    }
    private void method4(){

    }

    public static void main(String[] args) {
        String str = UUID.randomUUID().toString();
        long d1 = System.currentTimeMillis();
        // str += "_1";
        new StringBuffer(str).append("_1");
        long d2 = System.currentTimeMillis();
        System.out.println(d2 - d1);
        /*String MOBILEPHONE_CONTAINS = "1[3|4|5|7|8][0-9]{9}";
        String WECHART_CONTAINS = "[a-zA-Z]{1}[-_a-zA-Z0-9]{5,19}";
        String msg = "微信号wx234234ffsf234342423";
        Pattern mbPattern = Pattern.compile(WECHART_CONTAINS);
        Matcher mbMatcher = mbPattern.matcher(msg);
        if(mbMatcher.find()) {
            String xxx = mbMatcher.group();
            System.out.println(mbMatcher.groupCount());
            System.out.println(xxx);
            System.out.println(msg.indexOf(xxx));
            int startIndex = msg.indexOf(xxx);
            if(startIndex > 0){
                String prev = msg.substring(startIndex-1,startIndex);
                String ch = "^[A-Za-z0-9]$";
                Pattern chPattern = Pattern.compile(ch);
                Matcher chMatcher = chPattern.matcher(prev);
                if(chMatcher.matches()){
                    System.out.println("前面有字符串或数字:" + prev);
                }
            }
            int endIndex = startIndex + xxx.length();
            if(endIndex < msg.length()){
                String next = msg.substring(endIndex,endIndex+1);
                String ch = "^[A-Za-z0-9]$";
                Pattern chPattern = Pattern.compile(ch);
                Matcher chMatcher = chPattern.matcher(next);
                if(chMatcher.matches()){
                    System.out.println("后面有字符串或数字:" + next);
                }
            }
        }*/
    }
}
