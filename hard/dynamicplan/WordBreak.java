package leetcode.hard.dynamicplan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
参考：
https://leetcode-cn.com/problems/word-break/solution/1di-gui-bei-wang-lu-2dong-tai-gui-hua-by-horanol/
https://leetcode-cn.com/problems/word-break/solution/bfsjian-zhi-javanei-zhi-han-shu-by-weekcode/
 */
/**
 * @author wutia
 * @ClassName WordBreak
 * @date 2019/8/20 16:30
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        //dp[i] 表示以第i个字符结尾的字符串是否符合要求
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //第 j 个字符的子串和第 j 到 i 的子串都符合要求，返回true
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }



    static  String str;
    static Set<Integer> cache;
    static  List<String> list;
    public static boolean wordBreak1(String s, List<String> wordDict) {
        str=s;
        cache=new HashSet<Integer>();
        list=wordDict;
        return wordBreak(0);
    }
    private static boolean wordBreak(int d){
        if(d == str.length()) return true;
        //无需再次重复计算，剪枝
        if(cache.contains(d)) return false;
        for(String word : list){
            if(str.startsWith(word, d)){
                if(wordBreak(d+word.length())) return true;
                //已经为false的
                cache.add(d+word.length());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s="catsandog";
        List<String> list=new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.out.println(wordBreak1(s,list));

    }
}
