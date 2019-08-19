package leetcode.medium.dynamicplan;
/*
思路：借鉴
https://blog.csdn.net/zangdaiyang1991/article/details/94555112
 */


import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 * @author wutia
 * @ClassName lengthOfLIS
 * @date 2019/8/19 11:14
 */
public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return 1;
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return 1;
        }

        int resMax = 1;

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i=len-1; i>=0; i--) {
            // 遍历dp[i+1], dp[i+2]... 同时判断本元素是否能加入
            if (i==len-1) {
                dp[i] = 1;
                continue;
            }
            for (int j=i+1; j<len; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            resMax = Math.max(resMax, dp[i]);
        }

        return resMax;
    }

    public static void main(String[] args) {
//        int [] arr={10,9,2,5,3,4};//3
//        int [] arr={1,3,6,7,9,4,10,5,6};//6
        int [] arr={10,9,2,5,3,7,101,18};  //4
        System.out.println(lengthOfLIS(arr));
    }
}
