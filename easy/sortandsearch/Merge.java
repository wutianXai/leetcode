package leetcode.easy.sortandsearch;
/*
思路：插入排序
 */
/**
 * 合并两个有序数组
 * @author wutia
 * @ClassName Merge
 * @date 2019/8/14 11:32
 */
public class Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n!=0) {
            int i = 0;
            int j = 0;
            while (j < n) {
                if (nums1[i] > nums2[j]) {
                    for (int k = m; k > i; k--) {
                        nums1[k] = nums1[k - 1];
                    }
                    nums1[i] = nums2[j];
                    i++;
                    j++;
                    m++;
                } else {
                    if (i == m) {
                        nums1[i] = nums2[j];
                        i++;
                        j++;
                        m++;
                    } else {
                        i++;
                    }
                }
            }
        }



        for (int k=0;k<m;k++){
            System.out.println(nums1[k]);
        }

    }
    public static void main(String[] args) {
        int []num1={1,2,3,0,0,0};
        int m=3;
        int []num2={2,5,6};
        int n=3;
        merge(num1,m,num2,n);

    }
}
