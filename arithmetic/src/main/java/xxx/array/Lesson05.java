package xxx.array;

/**
 * @description: 只出现一次的数字
 * 给定一个整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson05 {
    /**
     * java的位运算符中有一个叫异或的运算符，用符号(^)表示，其运算规则是：两个操作数的位中，相同则结果为0，不同则结果为1
     * 一个数和0异或还是自己，一个数和自己异或是0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int v = 0;
        for(int i=0;i<nums.length;i++){
            v ^= nums[i];
        }
        return v;
    }
    /*public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n =0;
        for(int i=0;i<nums.length;i=i+2){
            if(i+1 == nums.length || nums[i] != nums[i+1]){
                n= nums[i];
                break;
            }
        }
        return n;
    }*/

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,5,6,4,6,3,4,3};
        Lesson05 lesson04 = new Lesson05();
        int n = lesson04.singleNumber(nums);
        System.out.println(n);

        System.out.println(7 & 9);
        System.out.println(7 | 9);
        System.out.println(~2);

    }

    private void aaa(Integer a,String b){}
    private void aaa(String b,Integer a){}


}
