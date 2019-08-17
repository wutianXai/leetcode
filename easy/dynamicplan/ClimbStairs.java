package leetcode.easy.dynamicplan;
/*
offer原题：递归
当一个阶梯时：1种
两个阶梯：2种
三个阶梯看成一个阶梯和两个阶梯
四个阶梯看成三个阶梯和两个阶梯，三个阶梯同上
 */
/**
 * 爬楼梯
 * @author wutia
 * @ClassName ClimbStairs
 * @date 2019/8/16 11:39
 */
public class ClimbStairs {
    public static int climbStairs(int n) {
        if(n==1)return 1;
        if(n==2)return 2;

        int pre=1;
        int now=2;
        for(int i=3;i<=n;i++){
            int sum=pre+now;
            pre=now;
            now=sum;
        }
        return now;

    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(climbStairs(n));

    }
}
