package leetcode.vipproblem;
/*
5168. 比较字符串最小字母出现频次
题目难度 Easy
我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。

例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。

现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。



示例 1：

输入：queries = ["cbd"], words = ["zaaaz"]
输出：[1]
解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
示例 2：

输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
输出：[1,2]
解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wutia
 * @ClassName NumSmallerByFrequency
 * @date 2019/8/25 11:29
 */
public class NumSmallerByFrequency {
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        List<Integer> list=new ArrayList<>();
        if(queries.length==0||words.length==0)return new int[0];
        for (String q :
                queries) {
            int num=0;

            for (String w:words){
                if(f(q)<f(w))num++;
            }
            list.add(num);

        }
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;

    }

    public static int f(String str){
        char min='z';
        char[] sarr=str.toCharArray();
        for (char c :
                sarr) {
            if(c<min)min=c;
        }
        int count=0;
        for (char c :
                sarr) {
            if(c==min)
                count++;

        }
        return count;

    }


    public static void main(String[] args) {

    }
}
