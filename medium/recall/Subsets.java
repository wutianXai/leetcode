package leetcode.medium.recall;
/*
子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wutia
 * @ClassName Subsets
 * @date 2019/8/23 16:33
 */
public class Subsets {
    static List<Integer> buf=new ArrayList<>();
    private static void recall(int[] nums, int path, List<List<Integer>> list) {
        if(path>0 && path<=nums.length){
            list.add(new ArrayList<Integer>(buf));
        }
        for(int i=path;i< nums.length;i++){
            if(path==0||buf.get(buf.size()-1)<nums[i]) {
                buf.add(Integer.valueOf(nums[i]));
                recall(nums, path + 1, list);
                buf.remove(Integer.valueOf(nums[i]));
            }
        }

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        if(nums.length==0)return list;
        Arrays.sort(nums);
        list.add(new ArrayList<>());
        recall(nums,0,list);
        return list;

    }

    public static void main(String[] args) {
        int [] arr={4,1,0};
        System.out.println(JSON.toJSONString(subsets(arr)));

    }
}
