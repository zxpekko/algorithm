package leetcode;

import java.util.*;

/**
 * @Author:zxp
 * @Description:给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * @Date:11:14 2023/9/7
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.right=treeNode1;
        treeNode1.left=treeNode2;
        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.println(inorderTraversal.inorderTraversal(treeNode));
    }
    public List<Integer> inorderTraversal(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        inorder(root,queue);
        List<Integer> result=new ArrayList<>();
        for (TreeNode treeNode : queue) {
            result.add(treeNode.val);
        }
        return result;
    }
    public void inorder(TreeNode root,Queue<TreeNode> queue){
        if(root==null)
            return;
        inorder(root.left,queue);
        queue.offer(root);
        inorder(root.right,queue);
    }
}
