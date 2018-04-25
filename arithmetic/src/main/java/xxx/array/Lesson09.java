package xxx.array;


import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson09 {

    /**
     * 思路:常规方法,通过循环判断两数之和是否等于target
     * 但这样太慢，需要O(n^2)的时间，O(1)的额外空间
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumM1(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 思路:
     * 假如当前选择了一个数字a，那么为了满足条件，另一个数字b必须满足：b=targe-a，即在数组中寻找是否存在b。
     * 如何快速寻找数组中是否存在一个数字b？假如数组是有序的，可以使用二分查找方法，其查找时间复杂度是O(logn)。
     * 然而题目并没给定这个条件。如果对数组排序，首先就要O(nlogn)的时间进行排序，并且排序后，数字的原始下标也要保存，
     * 显然需要O(nlogn)的时间以及O(n)的空间，并不是最好的方法。
     * 如何对一个数组进行快速查找一个元素？算法中提供了一种方法——哈希（Hash）
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumM2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(nums[i])){
                res[0] = map.get(nums[i]);
                res[1] = i;
            }
            map.put(diff, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 7, 11, 15};
        int target = 9;
        Lesson09 lesson09 = new Lesson09();
        int[] num = lesson09.twoSumM2(nums1,target);
        System.out.println(111);
    }
}
