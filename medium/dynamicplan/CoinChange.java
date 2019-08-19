package leetcode.medium.dynamicplan;

/*

 */
/**
 * 零钱兑换
 * @author wutia
 * @ClassName CoinChange
 * @date 2019/8/17 16:15
 */
public class CoinChange {
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
