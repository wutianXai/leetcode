package leetcode.medium.sortandsearch;
/*
思路：折半查找+广度遍历
 */
/**
 *  在排序数组中查找元素的第一个和最后一个位置
 * @author wutia
 * @ClassName SearchRange
 * @date 2019/8/14 15:43
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int [] range={-1,-1};
        if(nums.length==0)return range;
        int min=0;int max=nums.length-1;int mid=max/2;

        while(min<=max){
            mid=min+(max-min)/2;
            if(nums[mid]<target){
                min=mid+1;
            }else if (nums[mid]>target){
                max=mid-1;
            }else {
                break;
            }
        }
        if(nums[mid]!=target)return range;
        range[0]=range[1]=mid;
        while (range[0]-1>=0&& nums[range[0]-1]==target){
            range[0]--;
        }
        while (range[1]+1<nums.length && nums[range[1]+1]==target){
            range[1]++;
        }
        return  range;
    }


    public static void main(String[] args) {
        int []arr={1,1,2};
        int target=1;

        int [] range=searchRange(arr,target);
        System.out.println(range[0]);
        System.out.println(range[1]);
    }
}
