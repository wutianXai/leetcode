package leetcode.easy.dynamicplan;
/**
 * 最大子序和
 * @author wutia
 * @ClassName MaxSubArray
 * @date 2019/8/16 17:33
 */
public class MaxSubArray {
    //暴力法 129ms
    public static int maxSubArray(int[] nums) {
        if(nums.length==0)return 0;
        int[] arr=new int[nums.length];

        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=arr[i]=nums[i];
            for(int j=i+1;j<nums.length;j++){
                sum=sum+nums[j];
                if(sum>arr[i]){
                    arr[i]=sum;
                }
            }
            if(max<arr[i]){
                max=arr[i];
            }
        }



        return max;

    }

    //分治法 2ms
    public static int maxSubArray1(int[] nums) {
        int i,max,temp;
        temp = 0;
        max = nums[0];
        //找出数组中最大值
        for(i=1;i<nums.length;i++)
        {
            if(nums[i]>max)
                max = nums[i];
        }
        //相加比较找最大值
        for(i=0;i<nums.length;i++)
        {//两两相加进行比较
            temp += nums[i];
            max =  temp<max ? max:temp;
            temp = temp< 0 ? 0:temp;
        }
        return max;

    }

    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
//        int[] arr={5,-4,-2,1,2,3,4};
        System.out.println(maxSubArray1(arr));


    }
}
