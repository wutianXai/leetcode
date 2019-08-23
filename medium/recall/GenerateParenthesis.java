package leetcode.medium.recall;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
/*
 生成括号
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
/*
思路：
模仿电话号码组合，
使用回溯法，组合“（”和“）”，
p1,p2代表操作前的符号是第几个“（”，“）”，

触底条件：当p1=p2=n时，说明已经组合完成。
组合过程：
每层处理一个“（”和一个“）”，
当“（”的数量等与“）时，只能加入”（“，也就是p1>p2时，才能加”）“，
当”（“的数量<n时，才可以加入“（”。（终止条件）
 */
/**
 * @author wutia
 * @ClassName GenerateParenthesis
 * @date 2019/8/23 13:10
 */
public class GenerateParenthesis {
     static  StringBuffer stringBuffer=new StringBuffer();

    public static List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        if (n==0)return list;



        recall(n,0,0,list);
        return list;

    }

    public static void recall(int n,int p1,int p2,List<String> list){
        if(n==p1&& n==p2){
            list.add(stringBuffer.toString());
            return;
        }
        if(p1>p2){
            stringBuffer.append(")");
            recall(n,p1,p2+1,list);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        if(p1<n){
            stringBuffer.append("(");
            recall(n,p1+1,p2,list);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }

    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(JSON.toJSONString(generateParenthesis(n)));

    }
}
