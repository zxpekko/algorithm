package binarytree;

import junit.framework.TestResult;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 *
 * 输入：root = []
 * 输出：0
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 * @Date:20:49 2023/12/21
 */
public class CountNodes {
    public int countNodes(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return 0;
        int count=0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
            }
            count+=size;
        }
        return count;
    }
    public int countNodesⅡ(TreeNode root){
        if(root==null)
            return 0;
        int leftNum=countNodesⅡ(root.left);//处理左子树
        int rightNum=countNodesⅡ(root.right);//处理右子树
        int result=leftNum+rightNum+1;//处理根节点。此为后序遍历。
        return result;
    }
    public int countNodesⅢ(TreeNode root){
        if(root==null)
            return 0;
        TreeNode left=root.left;
        TreeNode right=root.right;
        int leftDepth=0;
        int rightDepth=0;//此处将根节点的那层设置为零。为了下面的移位运算做准备
        while (left!=null){
            left=left.left;
            leftDepth++;
        }
        while (right!=null){
            right=right.right;
            rightDepth++;
        }
        if(leftDepth==rightDepth)
            return (2<<leftDepth)-1;//这里移位，相当于2的leftDepth+1次方，弥补了根节点层数为零而少的那一个1.
        int leftNum = countNodesⅢ(root.left);
        int rightNum = countNodesⅢ(root.right);
        return leftNum+rightNum+1;
    }
}
