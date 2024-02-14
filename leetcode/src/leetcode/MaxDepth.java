package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * @Date:10:43 2023/8/19
 */
public class MaxDepth {
    public int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int maxDepth=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
