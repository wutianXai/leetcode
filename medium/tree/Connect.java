package leetcode.medium.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 填充每个节点的下一个右侧节点指针
 * @author wutia
 * @ClassName Connect
 * @date 2019/8/13 12:07
 */
public class Connect {
    public static Node connect(Node root) {

        ArrayList<List<Node>> res = new ArrayList<>();
        if(root== null)return null;

        addLevel(res,0,root);

        for (List list :
                res) {
            for(int i=0;i<list.size();i++){
                Node node=(Node)list.get(i);
                if((i+1)!=list.size())
                node.next=(Node)list.get(i+1);
            }
            
        }

        return res.get(0).get(0);

    }

    public static void addLevel(List<List<Node>> list, int level, Node root) {
        if(root == null){
            return;
        }


        if(list.size() - 1 < level){
            list.add(new ArrayList<>());
        }


        list.get(level).add(root);

        addLevel(list,level+1,root.left);
        addLevel(list,level+1,root.right);
    }

    public static void main(String[] args) {
        Node root=new Node(1,null,null,null);
        root.left=new Node(5,null,null,null);
        root.left.left=new Node(2,null,null,null);
        root.right=new Node(2,null,null,null);
        root.right.left=new Node(3,null,null,null);
        root.right.right=new Node(20,null,null,null);
        System.out.println(JSON.toJSONString(connect(null)));

    }
}
