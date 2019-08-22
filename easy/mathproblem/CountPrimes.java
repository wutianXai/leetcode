package leetcode.easy.mathproblem;
/*
计数质数
统计所有小于非负整数 n 的质数的数量。

示例:

输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */

/*
思路1：//超时
一个函数判断该数是不是质数（该数不能被 根号下-该数 内的数完全整除）
写个循环遍历给的数n，调用上面的函数，记数；
思路2：//超时
维护一个n的数组，将 判断过的数的 所有小于n的 倍数全部标记为false（例如 2是指数， 2*2=4 <10 不是、2*3=6 <10 不是.2*4=8 <10 不是）
思路3：
参考：https://blog.csdn.net/whdAlive/article/details/80393880
 */

import java.util.Arrays;

/**
 * @author wutia
 * @ClassName CountPrimes
 * @date 2019/8/22 19:22
 */
public class CountPrimes {
    public static int countPrimes2(int n) {
        boolean [] arr=new boolean[n];
        Arrays.fill(arr,true);
        int count=0;
        for(int i=2;i<n;i++){
            if(arr[i]) {
                if (isZ(i)) {
                    count++;
                }
                int j=2;
                while (i*j<n){
                    if(arr[i*j]==true){
                        arr[i*j]=false;
                    }
                    j++;

                }
            }

        }

        return count;
    }


    public static int countPrimes(int n) {
        boolean[] noPrime = new boolean[n+1];
        int count=0;
        for(int i = 2;i<Math.sqrt(n);i++){
            if(!noPrime[i]){
                for(int j=i*i;j<n;j+=i){
                    noPrime[j] = true;
                }
            }
        }
        for(int j=2;j<n;j++){
            if(!noPrime[j]){
                count++;
            }
        }
        return count;
    }

    public static boolean isZ(int n){
        if(n==1)return false;
        if(n==2)return true;
        if(n==3)return true;
        if(n==5)return true;
        boolean flag=true;
        for(int i=2;i<=Math.sqrt(n);i++)
            if(n%i==0){
                flag=false;
                break;
            }
        return flag;
    }


    public static void main(String[] args) {
        int n=49979;
        System.out.println(countPrimes(n));

    }
}
