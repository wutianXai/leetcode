package leetcode.easy.dynamicplan;
/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
/*
思路：记录结果最大值和买入最小值
 */
/**
 * 买卖股票的最佳时机
 * @author wutia
 * @ClassName MaxProfit
 * @date 2019/8/16 12:05
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int sell = 0, hold = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
                //未持有状态：max(没买，卖掉)
            sell = Math.max(sell, hold + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
                //  持有状态：max(没卖，买入)
            hold = Math.max(hold, -prices[i]);
        }
        return sell;

    }

    public static void main(String[] args) {
//        int []arr={7,1,5,3,6,4};
        int []arr={2,4,1};
        System.out.println(maxProfit(arr));


    }
}
