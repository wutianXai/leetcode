package leetcode.medium.mathproblem;
/*
Excel表列序号
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28
示例 3:

输入: "ZY"
输出: 701
 */
/*
思路：
26进制数组。从后往前遍历
每个进位乘以26，例如（第一位1，第二位26，第三位26*26，···）
进位乘以 该符号代表的数 则为 该位
把每位数累加即可
 */
/**
 * @author ：wutian
 * @date ：Created in 2019/8/28 9:58
 */
public class TitleToNumber {

    public static int titleToNumber(String s) {
        char [] carr=s.toCharArray();
        int count=0;
        int rank=1;

        for (int i=carr.length-1;i>=0;i--){
            int a=carr[i]-'@';
            count+=a*rank;
            rank*=26;
        }
        return count;
    }

    public static void main(String[] args) {
        String s="ZY";
        System.out.println(titleToNumber(s));

    }
}
