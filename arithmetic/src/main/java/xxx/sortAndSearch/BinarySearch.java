package xxx.sortAndSearch;

/**
 * @description: 二分查找
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/22
 */
public class BinarySearch {

    /**
     * 元素必须是有序的，如果是无序的则要先进行排序操作。
     * 基本思想：也称为是折半查找，属于有序查找算法。
     * 用给定值k先与中间结点的关键字比较，中间结点把线形表分成两个子表，若相等则查找成功；
     * 若不相等，再根据k与该中间结点关键字的比较结果确定下一步查找哪个子表，
     * 这样递归进行，直到查找到或查找结束发现表中没有这样的结点。
     * 复杂度分析：最坏情况下，关键词比较次数为log2(n+1)，且期望时间复杂度为O(log2n)；
     * @param a             待查找的数组
     * @param value         待查找的值
     */
    public static int binarySearch(int[] a,int value){
        int low, high, mid;
        low = 0;
        high = a.length - 1;
        while(low<=high) {
            mid = (low+high) / 2;
            if(a[mid]==value)
                return mid;
            if(a[mid]>value)
                high = mid - 1;
            if(a[mid]<value)
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50};
        BubbleSort.bubbleSort_02(a);
        int b = binarySearch(a,40);
        System.out.println(b);
    }
}
