package leetcode.easy.other;
/*
有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
/*
思路：10ms
1. s不是空字符串；
2. 遍历字符串:
a.栈为空，若 c是闭口符号，false 若不是，则压栈
b. 栈不为空，判断是否是闭口符号，
    若是闭口符号，判断栈顶是对应开口符号，是-出栈，继续遍历，不是return false
    若不是，压栈

3. 处理结束，栈为空 return true ,否则 false
*/

import java.util.Stack;

/**
 * IsValid
 * @author ：wutian
 * @date ：Created in 2019/8/29 11:35
 */
public class IsValid {
    public static boolean isValid(String s) {
        if(s.length()==0){return true;}
        s=s.replace(" ","");
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(stack.empty()){
                if(c==')'||c==']'||c=='}') {
                    return false;
                } else {
                    stack.push(c);
                }

            }else{
                if(c==')'){
                    if(stack.peek()=='('){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else if(c==']'){
                    if(stack.peek()=='['){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else if(c=='}'){
                    if(stack.peek()=='{'){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else{
                    stack.push(c);
                }
            }

        }
        return stack.empty();

    }

    public static void main(String[] args) {
        String s="([)]";
        System.out.println(isValid(s));

    }

}
