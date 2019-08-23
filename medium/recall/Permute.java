package leetcode.medium.recall;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
/*
全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

/*
思路：回溯法组合1，2，3，
触底条件：path=输入数组的长度
组合过程：
维护一个与输入数组等长的数组用作已经使用的标记
当前数字未使用的时候，进行组合。
 */
/**
 * @author wutia
 * @ClassName Permute
 * @date 2019/8/23 13:39
 */
public class Permute {
    static List<Integer> buf=new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        if(nums.length==0)return list;
        boolean [] isused=new boolean[nums.length];
        recall(nums,isused,0,list);
        return list;

    }

    private static void recall(int[] nums, boolean[] isused, int path, List<List<Integer>> list) {
        if(nums.length==path){
            list.add(new ArrayList<Integer>(buf));
            return;
        }
        for(int i=0;i< nums.length;i++){
            if(isused[i]==false){
                buf.add(Integer.valueOf(nums[i]));
                isused[i]=true;
                recall(nums,isused,path+1,list);
                buf.remove(Integer.valueOf(nums[i]));
                isused[i]=false;
            }
        }

    }

    public static void main(String[] args) {
        int [] arr={1,2,3};
        System.out.println(JSON.toJSONString(permute(arr)));
    }
}
