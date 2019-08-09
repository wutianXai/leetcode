package medium.linked;

/**
 * 相交链表
 * @author wutia
 * @ClassName GetIntersectionNode
 * @date 2019/8/9 21:06
 */
public class GetIntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return  null;

        ListNode l1=headA;ListNode l2=headB;
        int length1=0;int length2=0;
        while(l1!=null){
            length1++;
            l1=l1.next;
        }
        while(l2!=null){
            length2++;
            l2=l2.next;
        }
        l1=headA;l2=headB;
        if(length1>length2){
            int bignum=length1-length2;
            while (bignum>0){
                l1=l1.next;
                bignum--;
            }

        }else if(length2>length1){
            int bignum=length2-length1;
            while (bignum>0){
                l2=l2.next;
                bignum--;
            }
        }
        while (l1!=null){
            if(l1==l2)return l1;
            else{
                l1=l1.next;
                l2=l2.next;
            }
        }
        return null;

    }

    public static void main(String[] args) {

        ListNode commonNode=new ListNode(2);
        commonNode.next=new ListNode(4);

        ListNode listNode1=new ListNode(2);
        ListNode head=listNode1;
        listNode1=listNode1.next=new ListNode(6);
        listNode1=listNode1.next=new ListNode(4);
//        listNode1.next=commonNode;

        ListNode listNode2=new ListNode(1);
        ListNode head1=listNode2;
        listNode2=listNode2.next=new ListNode(5);
//        listNode2.next=commonNode;



        ListNode l=getIntersectionNode(head,head1);
        if(l!=null) {
            System.out.println(l.val);
        }


    }
}
