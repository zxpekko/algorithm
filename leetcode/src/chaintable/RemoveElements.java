package chaintable;

/**
 * @Author:zxp
 * @Description:给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 *
 * 提示：
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * @Date:15:57 2024/1/16
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val){
        while (head!=null&&head.val==val){
            head=head.next;
        }
        if(head==null)
            return head;
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }
            else pre=cur;
            cur=cur.next;
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
