package xxx.array;

import java.util.*;

/**
 * @description: 两个数组的交集 II
 * 给定两个数组，写一个方法来计算它们的交集。
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 * 注意：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 跟进:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson06 {

    /**
     * 思路:
     * 用Map来建立nums1中字符和其出现个数之间的映射, 然后遍历nums2数组，
     * 如果当前字符在Map中的个数大于0，则将此字符加入结果res中，然后Map的对应值自减1。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectM1(int[] nums1, int[] nums2) {
        List<Integer> tmp = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums1){
            if(map.containsKey(n)){
                map.put(n,map.get(n) + 1);
            }else{
                map.put(n,1);
            }
        }
        for(int m : nums2){
            if(map.containsKey(m) && map.get(m) != 0){
                tmp.add(m);
                map.put(m,map.get(m) - 1);
            }
        }
        int[] result = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++){
            result[i] = tmp.get(i);
        }
        return result;
    }

    /**
     * 思路: 给两个数组排序,排序后两个数组按顺序比较就行了
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectM2(int[] nums1, int[] nums2) {
        int n = 0;
        int m = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> tmp = new ArrayList<>();
        while (n < nums1.length && m < nums2.length){
            if(nums1[n] == nums2[m]){
                tmp.add(nums1[n]);
                n++;
                m++;
            }else if(nums1[n] > nums2[m]){
                m++;
            }else {
                n++;
            }
        }
        int[] result = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++){
            result[i] = tmp.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{2,3,3,2};
        Lesson06 lesson06 = new Lesson06();
        int[] nums = lesson06.intersectM2(nums1,nums2);
        System.out.println(nums);
    }
}
