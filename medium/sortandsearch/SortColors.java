package leetcode.medium.sortandsearch;
/*
思路：冒泡排序
 */
/**
 * 颜色分类
 * @author wutia
 * @ClassName SortColors
 * @date 2019/8/14 15:37
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        for (int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if (nums[i] > nums[j]) {
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;

                }
            }
        }
        for (int num :
                nums) {
            System.out.println(num);

        }

    }


    public static void main(String[] args) {
        int [] nums={2,0,2,1,1,0};
        sortColors(nums);

    }
}
