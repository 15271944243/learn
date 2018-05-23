package xxx.sortAndSearch;

/**
 * @description: 冒泡排序
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/5/22
 */
public class BubbleSort {

    /**
     * 它是一种较简单的排序算法。它会遍历若干次要排序的数列，每次遍历时，它都会从前往后依次的比较相邻两个数的大小；
     * 如果前者比后者大，则交换它们的位置。这样，一次遍历之后，最大的元素就在数列的末尾！
     * 采用相同的方法再次遍历时，第二大的元素就被排列在最大元素之前。重复此操作，直到整个数列都有序为止！
     * @param a 待排序的数组
     */
    public static void bubbleSort_01(int[] a){
        int i,j;
        for (i=a.length-1; i>0; i--) {
            for (j=0; j<i; j++) {
                if(a[j] > a[j+1]){
                    int t = a[j+1];
                    a[j+1] = a[j];
                    a[j] = t;
                }
            }
        }
    }

    /**
     * 下面我们对冒泡排序进行优化，使它效率更高一些：添加一个标记，如果一趟遍历中发生了交换，
     * 则标记为true，否则为false。如果某一趟没有发生交换，说明排序已经完成！
     * @param a 待排序的数组
     */
    public static void bubbleSort_02(int[] a){
        int i,j;
        int flag;
        for (i=a.length-1; i>0; i--) {
            flag = 0;
            for (j=0; j<i; j++) {
                if(a[j] > a[j+1]){
                    int t = a[j+1];
                    a[j+1] = a[j];
                    a[j] = t;
                    flag = 1;
                }
            }
            if(flag == 0) break;
        }
    }

    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50};
        bubbleSort_01(a);
        System.out.println("--------");
        int[] b = {20,40,30,10,60,50};
        bubbleSort_02(b);
        System.out.println(1);
    }

}
