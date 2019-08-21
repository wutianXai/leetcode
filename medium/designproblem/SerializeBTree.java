package leetcode.medium.designproblem;

/**
 * @author wutia
 * @ClassName SerializeBTree
 * @date 2019/8/21 18:20
 */
public class SerializeBTree {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root==null)return null;

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data==null||data="")return null;

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
//        root.left=new TreeNode(5);
//        root.left.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
//        root.right.right=new TreeNode(20);
        TreeNode res=deserialize(serialize(root));

    }
}
