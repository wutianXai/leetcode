package leetcode.medium.dynamicplan;

/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？

说明：m 和 n 的值均不超过 100。

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
 */

/**
 * 不同路径
 * @author wutia
 * @ClassName UniquePaths
 * @date 2019/8/17 11:42
 */
public class UniquePaths {
    //递归超时
    public static int uniquePaths(int m, int n) {
        if(n<1&& m<1)return 0;
        if(n==1 && m==1)return 1;
        if(m>1&&n>1){
            return uniquePaths(m-1,n)+uniquePaths(m,n-1);
        }else if(m>1&& n==1){
            return 1;
        }else if(m==1&& n>1)return 1;
        return  -1;
    }

    //动态规划 1ms
    public static int uniquePaths1(int m, int n) {
        if(n<1|| m<1)return 0;
        int[][] dp = new int[n][m];
        dp[0][0]=1;
        for(int i=1;i<m;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++)
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        int m=0,n=3;
        System.out.println(uniquePaths1(m,n));

    }
}
