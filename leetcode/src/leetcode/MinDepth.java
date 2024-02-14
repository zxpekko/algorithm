package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * @Date:13:13 2023/8/22
 */
public class MinDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        root.left=treeNode1;
        root.right=treeNode2;
        treeNode2.left=treeNode3;
        treeNode2.right=treeNode4;
        MinDepth minDepth = new MinDepth();
        int i = minDepth.minDepth(root);
        System.out.println(i);

    }
    public int minDepth(TreeNode root){
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int minDepth=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            int flag=0;
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left==null&&poll.right==null){
                    flag=1;
                    break;
                }
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
            }
            minDepth++;
            if(flag==1)
                break;
        }
        return minDepth;
    }
}
