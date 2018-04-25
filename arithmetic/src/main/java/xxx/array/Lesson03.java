package xxx.array;

/**
 * @description: 旋转数组
 * 将包含 n 个元素的数组向右旋转 k 步。
 * 例如，如果  n = 7 ,  k = 3，给定数组  [1,2,3,4,5,6,7]  ，向右旋转后的结果为 [5,6,7,1,2,3,4]。
 * 要求空间复杂度为 O(1)
 * 注意: 尽可能找到更多的解决方案，这里最少有三种不同的方法解决这个问题
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson03 {

    /**
     * 空间复杂度为O(n)
     * 复制一个和nums一样的数组，然后利用映射关系i -> (i+k)%n来交换数字
     * @param nums
     * @param k
     */
    public void rotateOn(int[] nums, int k) {
        int[] r = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            System.out.println((i+k)%nums.length);
            r[(i+k)%nums.length] = nums[i];
        }
        System.out.println(r);
    }

    /**
     * 空间复杂度为O(1)
     * 利用映射关系i -> (i+k)%n来交换数字
     * 1,2,3,4,5,6,7
     * 1,2,3,1,5,6,7
     * 1,2,3,1,5,6,4
     * 1,2,7,1,5,6,4
     * 1,2,7,1,5,3,4
     * 1,6,7,1,5,3,4
     * 1,6,7,1,2,3,4
     * 5,6,7,1,2,3,4
     * @param nums
     * @param k
     */
    public void rotateM1(int[] nums, int k) {
        if(nums.length == 0 || (k % nums.length) == 0) return;
        k = k % nums.length;
        // 当前位置
        int p = 0;
        // 被替换的位置的值
        int pv = nums[p];
        // 起始位置
        int s = 0;
        for(int i=0;i<nums.length;i++){
            int t = nums[(p+k)%nums.length];
            nums[(p+k)%nums.length] = pv;
            p = (p+k)%nums.length;
            if(p == s){
                ++s; ++p;
                pv = nums[p];
            }else{
                pv = t;
            }
        }
        System.out.println(111111);
    }

    /**
     * 空间复杂度为O(1)
     * 类似翻转字符的方法，思路是先把前n-k个数字翻转一下，再把后k个数字翻转一下，最后再把整个数组翻转一下
     * 1 2 3 4 5 6 7
     * 4 3 2 1 | 5 6 7
     * 4 3 2 1 | 7 6 5
     * 5 6 7 1 2 3 4
     * @param nums
     * @param k
     */
    public void rotateM2(int[] nums, int k) {
        if(nums.length == 0 || (k % nums.length) == 0) return;
        k = k % nums.length;
        //reverse(nums.begin(), nums.begin() + n - k);
        //reverse(nums.begin() + n - k, nums.end());
        //reverse(nums.begin(), nums.end());
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        Lesson03 lesson03 = new Lesson03();
        lesson03.rotateM2(nums,3);
//        System.out.println(num);
    }
}
