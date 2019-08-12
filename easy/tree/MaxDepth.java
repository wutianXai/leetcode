package leetcode.easy.tree;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.scene.transform.Rotate;

/**
 * @author wutia
 * @ClassName MaxDepth
 * @date 2019/8/12 19:06
 */
public class MaxDepth {
    public static int maxDepth(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 1;
        int maxdep=1;
        int rightdep=maxDepth(root.right);
        int leftdep=maxDepth(root.left);
        maxdep+=leftdep>=rightdep?leftdep:rightdep;

        return maxdep;

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(2);
        root.right=new TreeNode(4);
        System.out.println(maxDepth(root));

    }
}
