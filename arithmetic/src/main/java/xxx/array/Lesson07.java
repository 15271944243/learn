package xxx.array;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: 加一
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson07 {

    public int[] plusOne(int[] digits) {
        int plus = 1;
        for(int i = digits.length-1;i > -1;i--){
            if(digits[i] == 9 && plus == 1){
                digits[i] = 0;
            }else{
                digits[i] = digits[i] + plus;
                plus = 0;
            }
        }
        if(plus == 1){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for(int j=1;j<result.length;j++){
                result[j] = digits[j-1];
            }
            return result;
        }else{
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3};
        Lesson07 lesson07 = new Lesson07();
        int[] nums = lesson07.plusOne(nums1);
        System.out.println(nums);
    }
}
