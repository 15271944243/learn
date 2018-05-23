package xxx.sortAndSearch;

/**
 * @description: 快速排序
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/22
 */
public class QuickSort {

    /**
     * 它的基本思想是：选择一个基准数，通过一趟排序将要排序的数据分割成独立的两部分；
     * 其中一部分的所有数据都比另外一部分的所有数据都要小。
     * 然后，再按此方法对这两部分数据分别进行快速排序，
     * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     * 步骤:
     * 1.从数列中挑出一个基准值
     * 2.将所有比基准值小的摆放在基准前面，所有比基准值大的摆在基准的后面(相同的数可以到任一边)；
     * 在这个分区退出之后，该基准就处于数列的中间位置
     * 3.递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序
     * @param a  待排序的数组
     * @param l  数组的左边界(例如，从起始位置开始排序，则l=0)
     * @param r  数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    public static void quickSort(int[] a,int l,int r){
        if(l < r){
            // 数组边界
            int i = l;
            int j = r;
            // 基准值
            int x = a[i];
            while (i<j){
                // 从右向左找第一个小于x的数
                while (i<j && a[j] > x){
                    j--;
                }
                if(i < j){
                    a[i++] = a[j];
                }
                // 从左向右找第一个大于x的数
                while (i < j && a[i] < x){
                    i++;
                }
                if(i < j){
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            quickSort(a, l, i-1); /* 递归调用 */
            quickSort(a, i+1, r); /* 递归调用 */
        }
    }

    public static void main(String[] args) {
        int a[] = {30,40,60,10,20,50};
        quickSort(a,0,a.length-1);
        System.out.println(1);
    }
}
