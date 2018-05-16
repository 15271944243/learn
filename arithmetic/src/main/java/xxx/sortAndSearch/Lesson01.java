package xxx.sortAndSearch;

import java.util.Arrays;

/**
 * @description: 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:   nums1 = [1,2,3,0,0,0], m = 3    nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson01 {
    /**
     * 思路: 由于这两个数据都是排好序,所以从后往前遍历两个数组,把元素从后往前排
     * 如果nums1或nums2元素使用完后,就不用判断了,直接把剩下的值写入就行了
     * @return
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1;
        int j = n -1;
        int k = m + n - 1;
        while (k >= 0){
            if(i < 0 && j < 0) break;
            if(i < 0 || (j >= 0 && nums1[i] <= nums2[j])){
                nums1[k--] = nums2[j--];
            }else if(j < 0 || (nums1[i] > nums2[j])){
                nums1[k--] = nums1[i--];
            }
       }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        Lesson01 lesson01 = new Lesson01();
        lesson01.merge(nums1,m,nums2,n);
    }
}
