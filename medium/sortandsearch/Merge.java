package leetcode.medium.sortandsearch;

import com.alibaba.fastjson.JSON;

import java.util.*;
/*
思路：重写排序+遍历区间
 */
/**
 * 合并区间
 * @author wutia
 * @ClassName Merge
 * @date 2019/8/14 16:34
 */
public class Merge {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length<=1)return  intervals;
        Arrays.sort(intervals, (int[] o1, int[] o2) -> { return Integer.compare(o1[0],o2[0]);});

        List<int[]> ret = new ArrayList<>();
        int [] pre = intervals[0];
        for(int i =1; i< intervals.length; i++) {
            int [] now = intervals[i];
            if(pre[1] >= now[0]) {
                pre[1]= Math.max(pre[1], now[1]);
            } else {
                ret.add(pre);
                pre = now;
            }
        }
        ret.add(pre);


        int [][] resultarr=new int[ret.size()][2];
        for(int i=0;i<ret.size();i++)
        {
            resultarr[i]= ret.get(i);
        }
        return  resultarr;

    }
    public static void main(String[] args) {
        int [][] arr={{1,4},{2,5},{8,10},{15,18}};
        System.out.println(merge(arr));

    }
}
