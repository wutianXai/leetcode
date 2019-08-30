package leetcode.medium.other;
/*
求众数
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2
 */

/*
思路：offer原题//4ms
因为众数肯定大于N/2;
所以对数组排序，中间值肯定为众数。
 */

import java.util.Arrays;

/**
 * MajorityElement
 *
 * @author ：wutian
 * @date ：Created in 2019/8/30 11:42
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid=nums.length/2;
        return nums[mid];

    }

    public static void main(String[] args) {
        int [] a={0};
        System.out.println(majorityElement(a));

    }
}
