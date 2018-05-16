package xxx.sortAndSearch;

/**
 * @description: 第一个错误的版本
 * 你是产品经理，目前正在领导一个团队开发一个新产品。不幸的是，您的产品的最新版本没有通过质量检查。
 * 由于每个版本都是基于之前的版本开发的，所以错误版本之后的所有版本都是不好的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出第一个错误的版本，导致下面所有的错误。
 * 你可以通过 bool isBadVersion(version) 的接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。您应该尽量减少对 API 的调用次数。
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson02 {
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    /**
     * 思路: 这里直接使用min <= max的二分模板，因为我们其实要找的是好和坏的分界点，即这个点既不是好也不是坏，所以是找不到的，
     * 按照模板的特点，最后退出循环时，max指向小于目标的点，min指向大于目标的点，这里第一个坏的version较大，所以返回min
     * @return
     */
    public int firstBadVersion(int n) {
        int min = 1, max = n,mid = 0;
        while (min <= max){
            mid = min + (max - min) / 2;
//            if(isBadVersion(mid)){
//                max = mid - 1;
//            } else {
//                min = mid + 1;
//            }
        }
        return min;
    }

    public static void main(String[] args) {
        int n = 3;
        Lesson02 lesson02 = new Lesson02();
        lesson02.firstBadVersion(n);
    }
}
