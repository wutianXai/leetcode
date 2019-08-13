package leetcode.medium.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树
 * @author wutia
 * @ClassName InorderTraversal
 * @date 2019/8/13 10:50
 */
public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {

        List list=new ArrayList();
        if(root==null)return list;
        addNote(list,root);
        return list;
    }
    public static void addNote(List list,TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        addNote(list,treeNode.left);
        list.add(treeNode.val);
        addNote(list,treeNode.right);
    }

    public static List<Integer> inorderTraversa2(TreeNode root) {

        List list=new ArrayList();
        if(root==null)return list;
        addNote2(list,root);
        return list;
    }

    public static void addNote2(List list,TreeNode node)
    {
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty())
        {
            while (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            if(!stack.empty())
            {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
//        root.left=new TreeNode(5);
//        root.left.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
//        root.right.right=new TreeNode(20);
        System.out.println(JSON.toJSONString(inorderTraversa2(root)));

    }
}
