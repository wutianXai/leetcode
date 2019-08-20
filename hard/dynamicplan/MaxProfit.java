package leetcode.hard.dynamicplan;
/*
参考：
https://www.cnblogs.com/grandyang/p/4997417.html
 */

/**
 * Best Time to Buy and Sell Stock with Cooldown
 *
 * @author wutia
 * @ClassName MaxProfit
 * @date 2019/8/20 9:49
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, pre_buy = 0, sell = 0, pre_sell = 0;
        for (int price : prices) {
            pre_buy = buy;
            buy =Math. max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        return sell;

    }
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for(int i = 0 ; i < n; i++){
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
//        int[] arr = {0,1,0,1,0,1,0,1};
        int[] arr = {1,2,3,0,2};
        System.out.println(maxProfit(arr));

    }
}
