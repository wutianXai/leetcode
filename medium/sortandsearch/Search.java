package leetcode.medium.sortandsearch;
/*
思路：二分查找+判断左右是否有序
 */
/**
 * 搜索旋转排序数组
 * @author wutia
 * @ClassName Search
 * @date 2019/8/15 11:23
 */
public class Search {
    public static int search(int[] nums, int target) {
        if(nums.length==0)return -1;
        int min=0;int max=nums.length-1;
        int mid=nums.length/2;
        while (min<=max){
            mid=min+(max-min)/2;
            if(nums[mid]==target)return mid;
            else{
                if(target>nums[mid]){
                    if(nums[mid]<=nums[max]&& target<=nums[max])min=mid+1;
                    else if(nums[min]<=nums[mid])min=mid+1;
                    else max=mid-1;
                }else{
                    if(nums[max]<=nums[mid]&& target<=nums[max])min=mid+1;
                    else max=mid-1;
                }
            }

        }
        return -1;

    }

    public static void main(String[] args) {
//        int [] arr={4,5,6,7,8,1,2,3};
        int [] arr={5,6,7,0,1,2,3};
        int target=3;
        System.out.println(search(arr,target));

    }
}
