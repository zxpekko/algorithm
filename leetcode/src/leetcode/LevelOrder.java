package leetcode;

import java.util.*;

/**
 * @Author:zxp
 * @Description:root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *  * 输入：root = [3,9,20,null,null,15,7]
 *  * 输出：[[3],[9,20],[15,7]]
 *  * 示例 2：
 *  *
 *  * 输入：root = [1]
 *  * 输出：[[1]]
 *  * 示例 3：
 *  *
 *  * 输入：root = []
 *  * 输出：[]
 * @Date:12:58 2023/8/17
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> currentLevel=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                currentLevel.add(poll.val);
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
}

