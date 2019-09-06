package leetcode.hard.recall;
/*
Remove Invalid Parentheses
删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。

说明: 输入可能包含了除 ( 和 ) 以外的字符。

示例 1:

输入: "()())()"
输出: ["()()()", "(())()"]
示例 2:

输入: "(a)())()"
输出: ["(a)()()", "(a())()"]
示例 3:

输入: ")("
输出: [""]
 */

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * RemoveInvalidParentheses
 *
 * @author ：wutian
 * @date ：Created in 2019/9/6 9:25
 */
public class RemoveInvalidParentheses {
    //核心在于正反两次排除多余的'(' 和 ‘）’
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();

        //首先正向排除多余的'('
        remove(s, result, 0, 0, new char[] { '(', ')' });
        return result;
    }

    private static void remove(String s, List<String> result, int lasti, int lastj, char[] chr) {
        for (int stack = 0, i = lasti; i < s.length(); i++) {
            //最基础的通过 stack 记录 匹配的'('或')'
            if (s.charAt(i) == chr[0]) {
                stack++;
            }
            if (s.charAt(i) == chr[1]) {
                stack--;
            }
            //正向'('个数多于')' 或者 反向')'个数多于'('
            if (stack >= 0) {
                continue;
            }
            //存在多余括号
            for (int j = lastj; j <= i; j++) {
                //去掉连续多余括号中后面的那个
                if (s.charAt(j) == chr[1] && (j == lastj || s.charAt(j - 1) != chr[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), result, i, j, chr);
                }
            }
            return;
        }

        //反转字符串，反向去掉多余的'('
        String reverse = new StringBuilder(s).reverse().toString();

        if (chr[0] == '(') {
            remove(reverse, result, 0, 0, new char[] { ')', '(' });
        } else {
            result.add(reverse);
        }
    }


    public static void main(String[] args) {
        String s=")(";
        System.out.println(JSON.toJSONString(removeInvalidParentheses(s)));
    }
}
