package xxx.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description: 存在重复
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson04 {
    /**
     * 常规方法:循环数组判断
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2) return false;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    /**
     * 方法2:利用HashSet
     * @param nums
     * @return
     */
    public boolean containsDuplicateM2(int[] nums) {
        if(nums.length < 2) return false;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        return set.size() != nums.length;
    }

    /**
     * 方法3:先从小到大排序,然后再判断是否重复(这种方法非常快,推荐)
     * @param nums
     * @return
     */
    public boolean containsDuplicateM3(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{5,6,7,1,2,5,3,4};
        Lesson04 lesson04 = new Lesson04();
        boolean flag = lesson04.containsDuplicateM3(nums);
        System.out.println(flag);
    }
}
