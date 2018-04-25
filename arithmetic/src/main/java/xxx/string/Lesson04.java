package xxx.string;


/**
 * @description: 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * 例如:
 * s = "anagram"，t = "nagaram"，返回 true
 * s = "rat"，t = "car"，返回 false
 * 注意:
 * 假定字符串只包含小写字母。
 * 提升难度:
 * 输入的字符串包含 unicode 字符怎么办？你能能否调整你的解法来适应这种情况？
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson04 {

    /**
     * 字母异位词: 字母出现的次数一样,顺序可以不一样也可以一样
     * 思路: 借鉴Lesson03的思路,用int数组作为简单的哈希表,
     * 值为奇数的时候,表示并不是字母异位词,
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] charArray = new int[26];
        for (int i = 0; i < s.length(); i++){
            charArray[s.charAt(i) - 'a']++;

        }
        for (int i = 0; i < t.length(); i++){
            charArray[t.charAt(i) - 'a']--;
        }
        // 判断是否字母相同
        for (int i = 0; i < charArray.length; i++){
            if (charArray[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabbcdd";
        String t = "aabbcdd";
        Lesson04 lesson04 = new Lesson04();
        boolean x = lesson04.isAnagram(s,t);
        System.out.println(x);
    }
}
