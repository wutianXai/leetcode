package leetcode.medium.dynamicplan;
/*
题目：
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。
 */
/*

 */
/**
 * 零钱兑换
 * @author wutia
 * @ClassName CoinChange
 * @date 2019/8/17 16:15
 */
public class  CoinChange {
    public static int coinChange(int[] coins, int amount) {

        int [] f = new int[amount + 1];
        f[0] = 0;

        for(int i = 1; i <= amount; i++){

            int cost = Integer.MAX_VALUE;

            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    if(f[i-coins[j]] != Integer.MAX_VALUE)
                        cost = Math.min(cost, f[i - coins[j]] + 1);
                }
            }

            f[i] = cost;
        }

        return  f[amount] == Integer.MAX_VALUE? -1 : f[amount];
    }

    public static void main(String[] args) {
//        int []arr ={2,5,10,1};
//        int amount=11;
        int []arr ={186,419,83,408};
        int amount=6272;
        System.out.println(coinChange(arr,amount));

    }
}
