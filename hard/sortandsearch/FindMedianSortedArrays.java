package leetcode.hard.sortandsearch;
/*
思路：合并+排序+计算中间的数（1位或者两位）
 */

import java.util.Arrays;

/**
 * 寻找两个有序数组的中位数
 * @author wutia
 * @ClassName FindMedianSortedArrays
 * @date 2019/8/15 13:39
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int [] res=new int[len1+len2];
        for(int j=0;j<len1;j++){
            res[j]=nums1[j];

        }
        for(int i=len1;i<res.length;i++){
            res[i]=nums2[i-(len1)];
        }

        Arrays.sort(res);

        if(res.length%2!=0){
            int mid =res.length/2;
            double midnum=res[mid];
            return midnum;
        }else{
            int mid=res.length/2;
            double midnum=(res[mid]+res[mid-1])/2.0;
            return midnum;
        }



    }
    public static void main(String[] args) {
        int [] nums1={1,3};
        int [] nums2={2};
        System.out.println(findMedianSortedArrays(nums1,nums2));

    }
}
