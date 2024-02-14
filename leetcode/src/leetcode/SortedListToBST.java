package leetcode;

import java.util.List;

/**
 * @Author:zxp
 * @Description:给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 * 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 * 示例 2:
 *
 * 输入: head = []
 * 输出: []
 * @Date:10:40 2023/8/20
 */
public class SortedListToBST {
    public static void main(String[] args) {
        ListNode head=new ListNode();
        ListNode p1=new ListNode(-10);
        ListNode p2=new ListNode(-3);
        ListNode p3=new ListNode(0);
        ListNode p4=new ListNode(5);
        ListNode p5=new ListNode(9);
        head.next=p1;
        p1.next=p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        p5.next=null;
        SortedListToBST sortedListToBST = new SortedListToBST();
        TreeNode treeNode = sortedListToBST.sortedListToBST(head);
        System.out.println(treeNode);

    }
    public TreeNode sortedListToBST(ListNode head){
        ListNode p=new ListNode();
        p=head;
        int length=0;
        while (p!=null){
            length++;
            p=p.next;
        }
        System.out.println(length);
        TreeNode treeNode = create(0, length - 1, head);

        return treeNode;
    }
    public TreeNode create(int left,int right,ListNode head){
        if(head.next==null)
            return null;
        if(right-left<0)
            return null;
        TreeNode root=new TreeNode();
        int loc=(left+right)/2;
        int i=0;
        ListNode p=head;
        while (i<loc){
            p=p.next;
            i++;
        }
        root.val=p.val;
        root.left=create(left,(left+right)/2-1,head);
        root.right=create((left+right)/2+1,right,head);
        return root;
    }

}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }
}
