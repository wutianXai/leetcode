package leetcode.medium.dynamicplan;

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
