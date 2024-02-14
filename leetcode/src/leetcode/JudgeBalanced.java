package leetcode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @Author:zxp
 * @Description:给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *
 * @Date:10:36 2023/8/22
 */
public class JudgeBalanced {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
        root.left=treeNode1;
        root.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        treeNode3.left=treeNode5;
        treeNode3.right=treeNode6;
        JudgeBalanced judgeBalanced = new JudgeBalanced();
        boolean balanced = judgeBalanced.isBalanced(null);
        System.out.println(balanced);
    }
    public boolean isBalanced(TreeNode root){
        if(root==null)
            return true;
        int leftHeight=SubTreeHeight1(root.left);
        int rightHeight=SubTreeHeight1(root.right);
        boolean isDifOne= (Math.abs(leftHeight-rightHeight)<=1);
        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);
        return isDifOne&&leftBalanced&&rightBalanced;
    }
    public int SubTreeHeight(TreeNode node){//层序遍历计算树高度
        if(node==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(node);
        int height=0;
        while (!queue.isEmpty()){
            int size= queue.size();
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
            }
            height++;
        }
        return height;
    }
    public int SubTreeHeight1(TreeNode node){//递归计算树高度
        if(node==null)
            return 0;

        return Math.max(SubTreeHeight1(node.left),SubTreeHeight1(node.right))+1;
    }

}
