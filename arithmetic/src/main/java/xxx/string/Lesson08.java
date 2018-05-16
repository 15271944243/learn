package xxx.string;


/**
 * @description: 数数并说
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n ，输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 * 示例 1: 输入: 1  输出: "1"
 * 示例 2: 输入: 4 输出: "1211"
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson08 {

    public String countAndSay(int n) {
        String s = "1";
        int i = 1;
        while (i < n){
            StringBuffer sb = new StringBuffer();
            int j = 0;
            int c = 1;
            while(j<s.length()){
                if(j+1<s.length() && s.charAt(j) == s.charAt(j+1)){
                    c++;
                }else{
                    sb.append(c).append(s.charAt(j));
                    c = 1;
                }
                j++;
            }
            s = sb.toString();
            i++;
        }
        return s;
    }

    public static void main(String[] args) {
        int n = 7;
        Lesson08 lesson08 = new Lesson08();
        String x = lesson08.countAndSay(n);
        System.out.println(x);
    }
}
