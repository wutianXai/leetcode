package leetcode.medium.recall;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

/*
思路：学习回溯法
参考：https://blog.csdn.net/likunkun__/article/details/80372848
 */
/**
 * @author wutia
 * @ClassName LetterCombinations
 * @date 2019/8/23 11:48
 */
public class LetterCombinations {
    static Map<Character,String> map=new HashMap<>();


    public static List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits.length()==0||digits=="")return list;
        map.put('2',"abc");map.put('3',"def");map.put('4',"ghi");
        map.put('5',"jkl");map.put('6',"mno");map.put('7',"pqrs");
        map.put('8',"tuv");map.put('9',"wxyz");

        recall(digits,new StringBuffer(),list);

        return list;
    }

    public static void recall(String str,StringBuffer path,List<String> list){
        //深搜触底，回溯
        if(str.length()==path.length()){
            list.add(path.toString());
            return;
        }
        int index=path.length();
        String temp=map.get(str.charAt(index));
        for(int i=0;i<temp.length();i++){
            path.append(temp.charAt(i));
            recall(str,path,list);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        String s="";
        System.out.println(JSON.toJSONString(letterCombinations(s)));

    }
}
