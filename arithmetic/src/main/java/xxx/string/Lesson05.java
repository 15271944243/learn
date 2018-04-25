package xxx.string;


/**
 * @description: 验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson05 {

    public boolean isPalindrome(String s) {

        return true;
    }

    public static void main(String[] args) {
        String s = "aabbcdd";
        Lesson05 lesson05 = new Lesson05();
        boolean x = lesson05.isPalindrome(s);
        System.out.println(x);
    }
}
