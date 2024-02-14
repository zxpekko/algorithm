package chaintable;

/**
 * @Author:zxp
 * @Description:给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * @Date:13:55 2024/1/18
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode p=head;
        int length=0;
        while (p!=null){
            length++;
            p=p.next;
        }
        if(length==n)
            return head.next;
        int num=length-n+1;
        int count=1;
        ListNode pre=null;
        ListNode cur=head;
        while (count<num){
            pre=cur;
            cur=cur.next;
            count++;
        }
        pre.next=cur.next;
        return head;
    }
}
