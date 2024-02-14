package binarytree;

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
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 * @Date:15:02 2023/12/21
 */
public class MinDepth {
    public int minDepth(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        int minDepth=0;
        if(root==null)return minDepth;
        queue.offer(root);
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
            minDepth+=1;
            if(flag==1)
                break;
        }
        return minDepth;
    }
}
