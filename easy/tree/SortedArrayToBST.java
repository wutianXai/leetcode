package leetcode.easy.tree;


import com.alibaba.fastjson.JSON;

/**
 * @author wutia
 * @ClassName SortedArrayToBST
 * @date 2019/8/12 21:58
 */
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        if(nums.length==1)return new TreeNode(nums[0]);

        TreeNode treeNode=addNode(nums,0,nums.length-1);
        return treeNode;
    }

    public  static TreeNode addNode(int[] nums, int begin, int end){
        TreeNode treeNode;
        int dis=end-begin;
        if(dis==1){
            treeNode=new TreeNode(nums[end]);
            treeNode.left=new TreeNode(nums[begin]);
        }else if(dis==0){
            treeNode=new TreeNode(nums[end]);
        }else{
            treeNode=new TreeNode(nums[begin+dis/2]);
            treeNode.left=addNode(nums,begin,begin+dis/2-1);
            treeNode.right=addNode(nums,begin+dis/2+1,end);


        }

        return treeNode;

    }



    public static void main(String[] args) {
        int [] num={-10,-3,0,5,9};
        TreeNode treeNode=sortedArrayToBST(num);
        System.out.println(JSON.toJSONString(treeNode));

    }
}
