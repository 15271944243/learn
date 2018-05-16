package xxx.string;


/**
 * @description: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:  输入: ["flower","flow","flight"]  输出: "fl"
 * 示例 2:  输入: ["dog","racecar","car"]     输出: ""    解释: 输入不存在公共前缀。
 * 说明:    所有输入只包含小写字母 a-z 。
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson09 {

    /**
     * 常规思路:以数组中的第一个字符串为基准，遍历其它字符串，逐个字符查找
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int l = strs[0].length();
        String s = strs[0];
        outterLoop : for(int j = 0;j<l;j++){
            for(int i=1;i<strs.length;i++){
                if(j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)){
                    s = strs[0].substring(0,j);
                    break outterLoop;
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        //String[] s = {"c","c"};
        Lesson09 lesson09 = new Lesson09();
        String x = lesson09.longestCommonPrefix(s);
        System.out.println(x);
    }
}
