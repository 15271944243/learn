package xxx.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 * s = "leetcode" 返回 0.
 * s = "loveleetcode",返回 2.
 * 注意事项：您可以假定该字符串只包含小写字母。
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson03 {

    /**
     * 常规方法:把每个字符出现的次数放到map里,然后找出第一个出现次数为1的那个字符
     * @param s
     * @return
     */
    public int firstUniqCharM1(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int index = -1;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) == 1) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 思路:由于题目要求可以假定该字符串只包含小写字母。
     * 所以可以用int数组作为简单的哈希表
     * @param s
     * @return
     */
    public int firstUniqCharM2(String s) {
        int[] abc = new int[26];
        for (int i = 0; i < s.length(); i++){
            abc[s.charAt(i) - 'a']++;
        }
        int index = -1;
        for (int i = 0; i < s.length(); i++){
            if (abc[s.charAt(i) - 'a'] == 1){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "aabbcdd";
        Lesson03 lesson03 = new Lesson03();
        int x = lesson03.firstUniqCharM2(s);
        System.out.println(x);
    }
}
