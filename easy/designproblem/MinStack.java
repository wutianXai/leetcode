package leetcode.easy.designproblem;

import java.util.Stack;
/*
offer原题：
添加辅助栈：保存比辅助栈内小的数
 */

/**
 * @author wutia
 * @ClassName MinStack
 * @date 2019/8/21 17:42
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> supstack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new Stack();
        this.supstack = new Stack();
    }

    public void push(int x) {
        if (!this.supstack.isEmpty()) {
            int min = this.supstack.peek();
            if (x < min) {
                this.supstack.push(x);
            } else {
                this.supstack.push(min);
            }
        } else {
            this.supstack.push(x);
        }


        this.stack.push(x);

    }

    public void pop() {
        if (!this.stack.isEmpty()) {
            this.stack.pop();
            this.supstack.pop();
        }
    }

    public int top() {
        if (!this.stack.isEmpty()) {
            return this.stack.peek();
        } else {
            return -1;
        }

    }

    public int getMin() {
        if (!this.stack.isEmpty()) {

            return this.supstack.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }

}
