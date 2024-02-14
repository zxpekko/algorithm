package leetcode;

import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:98
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @Date:19:25 2023/9/5
 */
public class JudgeValidBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-2147483648);
        TreeNode treeNode1 = new TreeNode(-2147483648);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(2);

        treeNode.left=treeNode1;
//        treeNode.right=treeNode2;
//        treeNode1.right=treeNode5;
//        treeNode2.left=treeNode3;
//        treeNode2.right=treeNode4;
        JudgeValidBST judgeValidBST = new JudgeValidBST();
        System.out.println(judgeValidBST.isValidBST(treeNode));
    }
//    public boolean isValidBST(TreeNode root){
//        if(root==null)
//            return true;
//        if(root.left==null&&root.right==null)
//            return true;
//        if(root.left!=null&&root.right!=null){
//            if(root.left.val>=root.val||root.right.val<=root.val)
//                return false;
//        }
//        if(root.left!=null&&root.right==null){
//            if(root.left.val>= root.val)
//                return false;
//        }
//        if(root.left==null&&root.right!=null){
//            if(root.right.val<= root.val)
//                return false;
//        }
//
////        if(root.right.val<=root.val)
////            return false;
//
//        return isValidBST(root.left)&&isValidBST(root.right);
//    }
    public boolean isValidBST(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        midProcess(root,queue);
        if(root.left==null&&root.right==null)
            return true;
        int pre=Integer.MIN_VALUE;
        int num=0;
        for (TreeNode treeNode : queue) {
            if(treeNode.val<=pre&&treeNode.val!=Integer.MIN_VALUE&&num!=0)
                return false;
            if(treeNode.val<=pre&&num!=0)
                return false;
            pre= treeNode.val;
            num++;
        }
        return true;
    }
    public void midProcess(TreeNode root, Queue<TreeNode> queue){
        if(root==null)
            return;
        midProcess(root.left,queue);
        queue.offer(root);
        midProcess(root.right,queue);
    }

}
