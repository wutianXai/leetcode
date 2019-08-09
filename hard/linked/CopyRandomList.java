package leetcode.hard.linked;
/*
思路：首先先对节点的值进行拷贝，然后把节点用next链接为链表，
最后在对random节点进行拷贝。
题目没说随机指针有包含随机指针，我们默认没有，即为null。
 */

/**
 *  复制带随机指针的链表
 * @author wutia
 * @ClassName CopyRandomList
 * @date 2019/8/9 21:43
 */
public class CopyRandomList {
    public static Node copyRandomList(Node head) {
        Node oriNode=head;
        Node newNode=new Node();
        Node newhead=newNode;
        while (oriNode!=null){
            newNode.next=new Node(oriNode.val,null,null);

            newNode=newNode.next;
            oriNode=oriNode.next;
        }
        oriNode=head;
        newNode=newhead.next;
        Node findNode=newhead.next;
        while (oriNode!=null){
            //注意random为空
            if(oriNode.random!=null){
                findNode=newhead;
                while(findNode!=null){
                    if(oriNode.random.val==findNode.val){
                        newNode.random=findNode;
                    }
                    findNode=findNode.next;
                }

            }

            oriNode=oriNode.next;
            newNode=newNode.next;

        }
        return newhead.next;

    }

    public static void main(String[] args) {
        Node node1=new Node(-1,null,null);
//        Node node2=new Node(2,null,null);
//        node1.next=node2;node1.random=node2;
//        node2.random=node2;
        Node head=copyRandomList(node1);
        System.out.println(head.val);

    }

}
