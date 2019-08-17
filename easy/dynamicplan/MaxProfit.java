package leetcode.easy.dynamicplan;

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
        if(prices.length==0)return 0;
        int min=Integer.MAX_VALUE;
        int max=0;
        for (int num:prices) {
            min = Math.min(min, num);
            max = Math.max(max, num - min);

        }

        return max;

    }

    public static void main(String[] args) {
//        int []arr={7,1,5,3,6,4};
        int []arr={2,4,1};
        System.out.println(maxProfit(arr));


    }
}
