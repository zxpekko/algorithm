package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 示例 2:
 *
 * 输入: root = [1]
 * 输出: 0
 *
 *
 * 提示:
 *
 * 节点数在 [1, 1000] 范围内
 * -1000 <= Node.val <= 1000
 * @Date:18:52 2023/12/23
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root){//层序遍历求解，在原始的层序遍历代码的基础上加上判断是否是叶子节点的条件，即可求得最后的解。
        Queue<TreeNode> queue=new LinkedList<>();
        int sum=0;
        if(root==null)
            return sum;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.left!=null){
                queue.offer(poll.left);
                TreeNode left = poll.left;
                if(left.left==null&&left.right==null)
                    sum+=left.val;
            }
            if(poll.right!=null)
                queue.offer(poll.right);
        }
        return sum;
    }
//    int sum=0;
//    public int sumOfLeftLeavesⅡ(TreeNode root){
//        if(root==null)
//            return 0;
//        if(root.left!=null){
//            TreeNode left = root.left;
//            if(left.left==null&&left.right==null)
//                sum++;
//        }
//        int leftNum = sumOfLeftLeavesⅡ(root.left);
//        int rightNum = sumOfLeftLeavesⅡ(root.right);
//
//        return sum;
//    }
    public int sumOfLeftLeavesⅡ(TreeNode root){//此处使用后序遍历，左右根
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 0;
        int leftNum=sumOfLeftLeavesⅡ(root.left);
        if(root.left!=null&&root.left.left==null&&root.left.right==null)
            leftNum+=root.left.val;//额外作一个判断，和我上面的层序遍历的额外判断目的是一致的。
        int rightNum=sumOfLeftLeavesⅡ(root.right);
        return leftNum+rightNum;
    }
}
