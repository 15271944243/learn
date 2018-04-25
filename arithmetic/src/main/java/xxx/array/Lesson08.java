package xxx.array;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: 移动零
 * 给定一个数组 nums, 编写一个函数将所有 0 移动到它的末尾，同时保持非零元素的相对顺序。
 * 例如， 定义 nums = [0, 1, 0, 3, 12]，调用函数之后， nums 应为 [1, 3, 12, 0, 0]。
 * 注意事项:
 * 必须在原数组上操作，不要为一个新数组分配额外空间。
 * 尽量减少操作总数。
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson08 {

    /**
     * 思路:
     * 找到0的位置,然后按从后往前的位置顺序开始置换
     * @param nums
     */
    /*public void moveZeroes(int[] nums) {
        List<Integer> zeroPostionList = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                zeroPostionList.add(i);
            }
        }
        int length = nums.length;
        for(int i = zeroPostionList.size()-1;i>-1;i--){
            int zeroPostion = zeroPostionList.get(i);
            if(zeroPostion == nums.length - 1){
                length--;
                continue;
            }
            for(int j=zeroPostion;j<length-1;j++){
                int t = nums[j+1];
                nums[j+1] = nums[j];
                nums[j] = t;
            }
            length--;
        }
        System.out.println(1111);
    }*/

    /**
     * 思路:
     * 将所有的非0数向前尽可能的压缩，最后把没压缩的那部分全置0就行了。比如103040，先压缩成134，剩余的3为全置为0。
     * 过程中需要一个指针记录压缩到的位置。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[pos] = nums[i];
                pos++;
            }
        }
        for(int i = pos;i<nums.length;i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0,1,4,0,3,12,9,0,0};
        Lesson08 lesson08 = new Lesson08();
        lesson08.moveZeroes(nums1);
        System.out.println(111);
    }
}
