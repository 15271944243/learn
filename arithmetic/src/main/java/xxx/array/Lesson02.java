package xxx.array;

/**
 * @description: 买卖股票的最佳时机 II
 * 假设有一个数组，它的第 i 个元素是一个给定的股票在第 i 天的价格。
 * 设计一个算法来找到最大的利润。你可以完成尽可能多的交易（多次买卖股票）。然而，你不能同时参与多个交易（你必须在再次购买前出售股票）。
 * @author: xiaoxiaoxiang.
 * @createDate: 2018/4/13
 */
public class Lesson02 {

    /**
     * 思路: 把数组看成一段股票曲线,总利润就是每一组波谷和波峰的差值之和
     * 即:只要后一天比前一天的价格高,就进行交易
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i] < prices[i + 1]){
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{1};
        int[] nums = new int[]{1,1,2,2,3,3,2,2,4};
        Lesson02 lesson02 = new Lesson02();
        int num = lesson02.maxProfit(nums);
        System.out.println(num);
    }
}
