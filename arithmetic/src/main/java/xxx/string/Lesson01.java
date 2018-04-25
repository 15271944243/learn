package xxx.string;

import java.util.Stack;

/**
 * @description: 反转字符串
 * 请编写一个函数，其功能是将输入的字符串反转过来。
 * 示例：
 * 输入：s = "hello"
 * 返回："olleh"
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson01 {

    /**
     * 方法一:
     * 常规方法,将字符串转换为char数组,遍历循环给一个新char数组赋值
     * @param s
     * @return
     */
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return s;
        char [] array = s.toCharArray();
        int length = s.length();
        for(int i=0;i<length/2;i++){
            array[i] = s.charAt(length - 1 - i);
            array[length - 1 - i] = s.charAt(i);
        }
        return new String(array);
    }

    /**
     * 方法二:
     * 利用Stringbuffer的reverse()
     * @param s
     * @return
     */
    public String reverseStringM2(String s) {
        if(s == null || s.length() == 0) return s;
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }

    /**
     * 方法三:
     * 利用栈的"后进先出(LIFO)"的特点
     * 将字符串转换为char数组
     * 将char数组中的字符依次压入栈中
     * 将栈中的字符依次弹出赋值给char数组
     * @param s
     * @return
     */
    public String reverseStringM3(String s) {
        if(s == null || s.length() == 0) return s;
        Stack<Character> stack = new Stack<>();
        char [] array = s.toCharArray();
        for(Character c : array){
            stack.push(c);
        }
        for(int i=0;i<array.length;i++){
            array[i] = stack.pop();
        }
        return new String(array);
    }

    public static void main(String[] args) {
        String s = "hello";
        Lesson01 lesson01 = new Lesson01();
        String s2 = lesson01.reverseString(s);
        System.out.println(s2);
    }
}
