package xxx.sortAndSearch;

/**
 * @description: 直接插入排序
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/22
 */
public class StraightInsertionSort {

    /**
     * 基本思想是：把n个待排序的元素看成为一个有序表和一个无序表。开始时有序表中只包含1个元素，无序表中包含有n-1个元素，
     * 排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程。
     * 非常类似于我们抓扑克牌.
     * 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
     * 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
     * 平均时间复杂度 ---- O(n^2)
     * 所需辅助空间 ------ O(1)
     * 稳定性 ------------ 稳定
     * @param a  待排序的数组
     */
    public static void straightInsertionSort(int[] a){
        for (int i = 1; i < a.length; i++) {        // 类似抓扑克牌排序
            int get = a[i];                         // 右手抓到一张扑克牌
            int j = i - 1;                          // 拿在左手上的牌总是排序好的
            while (j >= 0 && a[j] > get){           // 将抓到的牌与手牌从右向左进行比较
                a[j + 1] = a[j];                    // 如果该手牌比抓到的牌大，就将其右移
                j--;
            }
            a[j + 1] = get;                         // 直到该手牌比抓到的牌小(或二者相等)，将抓到的牌插入到该手牌右边(相等元素的相对次序未变，所以插入排序是稳定的)
        }
    }

    public static void main(String[] args) {
        int a[] = {30,40,60,10,20,50};
        straightInsertionSort(a);
        System.out.println(1);
    }
}
