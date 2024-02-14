package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 *
 *
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 * @Date:15:10 2023/12/24
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int result = root.val;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size=queue.size();
            int flag=0;
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                    if(flag==0){
                        flag=1;
                        result=poll.left.val;
                    }
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                    if(flag==0){
                        result=poll.right.val;
                        flag=1;
                    }
                }
            }
        }
        return result;
    }
}
