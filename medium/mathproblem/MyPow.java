package leetcode.medium.mathproblem;
/*
Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
/*
思路:

参考:
https://blog.csdn.net/weixin_42156844/article/details/84338516
自己思路://未通过
n取绝对值（Intege最大值问题，超时）
res=累乘x
若小于0，return 1/res，若大于，return res；
 */
/**
 * @author ：wutian
 * @date ：Created in 2019/8/28 10:13
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (n < 0)
        {return 1/pow(x,-n);}
        return pow(x,n);
    }
    private double pow(double x, int n) {
        if (n == 0){return 1;}
        double res = pow(x, n/2);
        if (n%2 == 0){ return res * res;}

        return x * res * res;
    }




    //未通过
    public static double myPow1(double x, int n) {
        if(x==1){return 1;}
        if(x==-1){
            if(n%2==0){return 1;}
            else  {return  -1;}
        }
        if(x>0 && x<0.0001&& n>Short.MAX_VALUE){return 0.0;}
        if(x<0 && x>-1&& n>Short.MAX_VALUE){return 0.0;}
        if(x>1 && n<Short.MIN_VALUE){return  0.0;}
        if(n==0){return 1.00000;}
        long n1=Math.abs(Long.valueOf(n));
        double res=1;
        for(long i=0;i<n1;i++){
            res*=x;
        }

        if(n>0){return res;}
        return 1/res;

    }

    public static void main(String[] args) {
        double x=-2;
        int n=-2147;
//        int n=-2147483647;
        System.out.println(myPow1(x,n));
    }
}
