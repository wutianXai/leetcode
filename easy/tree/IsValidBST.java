package leetcode.easy.tree;

import com.sun.corba.se.impl.protocol.giopmsgheaders.LocateReplyMessage_1_0;

import javax.swing.*;

/**
 * @author wutia
 * @ClassName IsValidBST
 * @date 2019/8/12 19:33
 */
public class IsValidBST {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean valid(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(15);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(20);
        System.out.println(isValidBST(root));

    }
}
