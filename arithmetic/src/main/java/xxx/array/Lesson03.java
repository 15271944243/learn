package xxx.array;

/**
 * @description: 旋转数组
 * 将包含 n 个元素的数组向右旋转 k 步。
 * 例如，如果  n = 7 ,  k = 3，给定数组  [1,2,3,4,5,6,7]  ，向右旋转后的结果为 [5,6,7,1,2,3,4]。
 * 注意: 尽可能找到更多的解决方案，这里最少有三种不同的方法解决这个问题
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson03 {

    /**
     * 思路:
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int[] r = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            System.out.println((i+k)%nums.length);
            r[(i+k)%nums.length] = nums[i];
        }
        System.out.println(r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        Lesson03 lesson03 = new Lesson03();
        lesson03.rotate(nums,3);
//        System.out.println(num);
    }
}
