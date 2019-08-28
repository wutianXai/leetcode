package leetcode.medium.mathproblem;
/*
两数相除
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
说明:

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
/*
思路：
https://leetcode-cn.com/problems/divide-two-integers/solution/shi-yong-wei-yun-suan-xun-huan-zuo-yi-bi-jiao-by-q/
 */
/**
 * @author ：wutian
 * @date ：Created in 2019/8/28 11:25
 */
public class Divide {
    public static int divide(int dividend, int divisor) {
        if(divisor==0) {
            return Integer.MAX_VALUE;
        }
        //被除数最小值  负数对于正数
        if(dividend==Integer.MIN_VALUE){
            if(divisor==-1){
                return Integer.MAX_VALUE;
            }else if(divisor==1){
                return Integer.MIN_VALUE;
            }
        }

        //将负数操作全部转换为正数  sign符号位
        long divd=(long)dividend;
        long divs=(long)divisor;
        int sign=1;
        if(divd<0){
            divd=-divd;
            sign=-sign;
        }
        if(divs<0){
            divs=-divs;
            sign=-sign;
        }

        int res=0;
        while(divd>=divs){
            int shift=0;
            while(divd>=divs<<shift){
                shift++;
            }
            //加上结果
            res+=(1<<(shift-1));
            System.out.println((1<<(shift-1)));
            //减去值
            divd-=(divs<<(shift-1));
        }
        return sign*res;

    }


    public static void main(String[] args) {
        int dividend=90;
        int divisor=5;
        System.out.println(divide(dividend,divisor));
    }
}
