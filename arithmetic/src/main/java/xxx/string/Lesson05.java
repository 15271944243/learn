package xxx.string;


import java.util.ArrayList;
import java.util.List;

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

//    a-z：97-122
//    A-Z：65-90
//    0-9：48-57

    /**
     * 常规方法,先提取字母和数据,然后判断是否是回文
     * @param s
     * @return
     */
    /*public boolean isPalindrome(String s) {
        if("".equals(s)) return true;
        List<Character> characterList = new ArrayList<>(s.length());
        int n = 0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if((c > 47 && c < 58) || (c > 64 && c < 91) || (c > 96 && c < 123)){
                characterList.add(c);
                n++;
            }
        }
        boolean flag = true;
        for(int i=0;i<characterList.size()/2;i++){
            char a = characterList.get(i);
            char b = characterList.get(characterList.size()-1-i);
            if(!(a == b || (a + 32 == b) || (b + 32 == a))){
                flag = false;
                break;
            }
        }
        return flag;
    }*/

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int startIndex = 0;
        int endIndex = s.length() - 1;
        while (startIndex < endIndex){
            char c1 = s.charAt(startIndex);
            if(!isLetterOrNum(c1)){
                startIndex++;
                continue;
            }
            char c2 = s.charAt(endIndex);
            if(!isLetterOrNum(c2)){
                endIndex--;
                continue;
            }
            if(c1 != c2) return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }

    private boolean isLetterOrNum(char c){
        if((c > 47 && c < 58) || /*(c > 64 && c < 91) ||*/ (c > 96 && c < 123)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
        Lesson05 lesson05 = new Lesson05();
        boolean x = lesson05.isPalindrome(s);
        System.out.println(x);
    }
}
