package leetcode.easy.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wutia
 * @ClassName LevelOrder
 * @date 2019/8/12 21:22
 */
public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        addLevel(res,0,root);

        return res;
    }

    public static void addLevel(List<List<Integer>> list, int level, TreeNode root) {
        if(root == null){
            return;
        }

        if(list.size() - 1 < level){
            list.add(new ArrayList<Integer>());
        }

        list.get(level).add(root.val);

        addLevel(list,level+1,root.left);
        addLevel(list,level+1,root.right);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.left.left=new TreeNode(2);
        root.right=new TreeNode(15);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(20);
        System.out.println(JSON.toJSONString(levelOrder(root)));
    }
}
