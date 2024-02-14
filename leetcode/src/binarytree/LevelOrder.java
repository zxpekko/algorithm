package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 * @Date:19:13 2023/12/19
 */
public class LevelOrder {
    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.right=treeNode1;
        treeNode1.left=treeNode2;
        System.out.println(levelOrder.levelOrder(treeNode));
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        while (!queue.isEmpty()){
            List<Integer> subResult=new ArrayList<>();
            int currentSize=queue.size();
            for(int i=0;i<currentSize;i++){
                TreeNode poll = queue.poll();
                subResult.add(poll.val);
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
            }
            result.add(subResult);
        }
        return result;
    }
}
