package leetcode.easy.mathproblem;
/*
3的幂
给定一个整数，写一个函数来判断它是否是 3 的幂次方。

示例 1:

输入: 27
输出: true
 */
/*
思路1：//83ms
1、先考虑3以内的情况，
2、大于3时，先看是不是3的倍数若不是，直接输出false（3的幂肯定是三的倍数）
若是，则n/3，继续返回2判断；

思路2：//23ms
参考：https://www.cnblogs.com/qflyue/p/8973907.html
首先求出int范围最大的3的幂   Max3
如果n为3的幂，则Max3必定能整除n

直接使用log函数
注意：
double 转int 需要 强转
n小于0直接为false

 */
/**
 * @author wutia
 * @ClassName IsPowerOfThree
 * @date 2019/8/22 20:18
 */
public class IsPowerOfThree {
    public static boolean isPowerOfThree(int n) {
        if(n==0)return false;
        if(n==1)return true;
        if (n==3)return true;
        if(n%3==0)
        return isPowerOfThree(n/3);
        else{return false;}

    }

    public static boolean isPowerOfThree2(int n) {
        if(n<0)return false;
        if(n==0)return false;
        if(n==1)return true;
        if (n==3)return true;
        int maxint=Integer.MAX_VALUE;
        int k=(int)(Math.log(maxint)/Math.log(3));
        int b3=(int)Math.pow(3,k);
        return (b3%n==0);

    }

    public static void main(String[] args) {
        int n=-3;
        System.out.println(isPowerOfThree2(n));

    }
}
