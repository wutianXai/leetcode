package leetcode.hard.other;
/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

 */
/*
思路：头尾指针法
从左到右，把最左边的元素当左墙，依次向右找》=左墙的元素，期间把 小于 左墙内的水相加；
若找到，则把相加的水记录到总记录中，把当前墙当作左墙。
从右到左，把最右边的元素当右墙，依次向左找》=右墙的元素，期间把 小于 右墙内的水相加；
若找到，则把相加的水记录到总记录中，把当前墙当作右墙。
当左墙等于右墙，结束查找。
 */
/**
 * Trap
 *
 * @author ：wutian
 * @date ：Created in 2019/9/2 17:42
 */
public class Trap {
    public static int trap(int[] height) {
        if(height.length<=1)return 0;
        int count=0;
        int left=0;int right=height.length-1;
        int i=-1;int j=height.length;
        int water1=0;int water2=0;
        while(left<right){
            while (i<height.length-1&&i<=right){
                i++;
                if(height[left]<=height[i]){
                    count+=water1;
                    left=i;
                    water1=0;
                    break;
                }
                else {
                    water1+=height[left]-height[i];
                }

            }

            while (0<j&&left<=j){
                j--;
                if(height[j]>=height[right]){
                    count+=water2;
                    right=j;
                    water2=0;

                    break;
                }else{
                    water2+=height[right]-height[j];
                }

            }

        }

        return count;

    }

    public static void main(String[] args) {
        int [] arr={0,1,0,2,1,0,1,3,2,1,2,1};
//        int [] arr={4,2,3};  //1
//        int [] arr={2,0,2};  //2
//        int [] arr={4,9,4,5,3,2};  //1
        System.out.println(trap(arr));

    }
}

