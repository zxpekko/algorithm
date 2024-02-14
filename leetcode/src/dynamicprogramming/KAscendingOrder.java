package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:11 2023/5/19
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class KAscendingOrder {
    public static void main(String[] args) {
        ListNode head1=new ListNode(0);
        ListNode a=head1;
        a.next=new ListNode(1);
        a=a.next;
        a.next=new ListNode(4);
        a=a.next;
        a.next=new ListNode(5);
//        System.out.println(head1.val);
        ListNode head2=new ListNode(0);
        ListNode b=head2;
        b.next=new ListNode(1);
        b=b.next;
        b.next=new ListNode(3);
        b=b.next;
        b.next=new ListNode(4);

        ListNode head3=new ListNode(0);
        ListNode c=head3;
        c.next=new ListNode(1);
        c=c.next;
        c.next=new ListNode(3);
        c=c.next;
        c.next=new ListNode(4);

        ListNode[] lists=new ListNode[3];
        lists[0]=head1.next;
        lists[1]=head2.next;
        lists[2]=head3.next;

        KAscendingOrder kAscendingOrder = new KAscendingOrder();
        ListNode listNode = kAscendingOrder.mergeKLists(lists);

        while (listNode!=null){
            System.out.println(listNode.val+" ");

        }
    }
    public ListNode mergeKLists(ListNode[] lists){
        ListNode ans=null;
        for(int i=0;i< lists.length;i++){
            ans=mergeTwoLists(ans,lists[i]);
        }

        return ans;
    }
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
//        int length1= list1.length;
//        int length2=list2.length;
//        int length;
//        if(length1<length2)
//            length=length1;
//        else
//            length=length2;
//        for(int i=0;i<length;i++){
//
//        }
        if(list1==null || list2==null){
            return list1!=null ? list1:list2;
        }
        ListNode head=new ListNode(0);
        ListNode tail=head,aPtr=list1,bPtr=list2;
        while (aPtr!=null && bPtr!=null){
            if(aPtr.val < bPtr.val){
                tail.next=aPtr;
                aPtr=aPtr.next;
            }
            else {
                tail.next=bPtr;
                bPtr=bPtr.next;
            }
            tail=tail.next;
        }
        if(aPtr!=null)
            tail.next=aPtr;
        else
            tail.next=bPtr;
        return head.next;
    }
}
