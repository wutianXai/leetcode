package leetcode.easy.tree;
/*

若为输入数字判断数的最大深度：
如：
示例1
输入

5
0 1
0 2
1 3
1 4
输出

3
思路：
采用数组存储各节点，编号对应数组下标，数组元素的值为父节点编号；
如果数组长度为1，表示只有一个节点，故树的高度为1；
否则，从后向前依次遍历，以该节点为叶子节点时，数的高度，比较取最大值即为整棵树的高度

 */
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
