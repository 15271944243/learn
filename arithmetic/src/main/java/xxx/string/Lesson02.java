package xxx.string;

import java.util.Stack;

/**
 * @description: 颠倒整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2的31次方,  2的31次方 − 1]。
 * 根据这个假设，如果反转后的整数溢出，则返回0
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson02 {

    /**
     * 思路:通过字符串反转实现
     * @param x
     * @return
     */
    public int reverseM1(int x) {
        String s = String.valueOf(x);
        StringBuffer sb = new StringBuffer(s);
        sb = sb.reverse();
        if(sb.indexOf("-") > -1) sb = sb.insert(0,"-").deleteCharAt(sb.length()-1);
        long r = Long.valueOf(sb.toString());
        if(r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) r = 0;
        return (int)r;
    }

    /**
     * 思路:
     * 不断将一个数字%10和/10，可以得到该数字各位分离的数字。
     * 因为都是用int型的，如果超出了范围，其除以10的结果就不会跟之前的结果一致
     * @param x
     * @return
     */
    public int reverseM2(int x) {
        int r = 0;
        while (x != 0){
            int tmp = r * 10 + x % 10;
            if(tmp / 10 != r) return 0;
            r = tmp;
            x = x / 10;
        }
        return r;
    }


    public static void main(String[] args) {
        int x = 1234567899;
        Lesson02 lesson02 = new Lesson02();
        int s = lesson02.reverseM2(x);
        System.out.println(String.valueOf(s));
    }
}
