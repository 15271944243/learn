package xxx.array;

/**
 * @description: 从排序数组中删除重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例：
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素必须是 1 和 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson01 {
    /**
     * 思路:n记录不重复元素的位置，i从n的下一个开始遍历数组，如果i位置的数字等于number位置的数字，说明该数字重复出现，不予处理；
     * 如果i位置的数字不等于n位置的数字，说明该数字没有重复，需要放到i的下一位置，并使n加1
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = 0;
        if(nums.length == 0) return n;
        for(int i=0;i<nums.length;i++){
            if(nums[n] != nums[i]){
                n++;
                nums[n] = nums[i];
            }
        }
        n++;
        return n;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,2,3,4,5,6,6,6,6};
        Lesson01 lesson01 = new Lesson01();
        int num = lesson01.removeDuplicates(nums);
        System.out.println(num);
    }
}
