package binarytree;

import leetcode.PathSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 示例 3：
 *
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * @Date:17:21 2023/12/24
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum){//这部分也是回溯，由于需要开辟result和subresult的空间，
        // 并且要向其中加入节点，所以时间复杂度和空间复杂度不如下面的那种方法。
        List<Integer> subresult=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        sum(root,targetSum,result,subresult);
        if(result.size()>0)
            return true;
        return false;
    }
    public void sum(TreeNode root,int targetSum,List<List<Integer>> result,List<Integer> subResult){
        if(root==null)
            return;
        targetSum-=root.val;
        subResult.add(root.val);
        if(targetSum==0&&root.left==null&&root.right==null){
            result.add(subResult);
            return;
        }
        if(root.left==null&&root.right==null)
            return;
        if(root.left!=null){
            sum(root.left,targetSum,result,subResult);
            subResult.remove(subResult.size()-1);
        }
        if(root.right!=null){
            sum(root.right,targetSum,result,subResult);
            subResult.remove(subResult.size()-1);
        }

//        targetSum+=root.val;
//        subResult.remove(subResult.size()-1);
    }
//    public void sum(TreeNode root,List<Integer> result,int sum){//这段代码不能完成功能。
//        if(root==null)
//            return;
//        sum+=root.val;
//        if(root.left==null&&root.right==null)
//            result.add(sum);
//        if(root.left!=null)
//            sum(root.left,result,sum);
//        sum-=root.val;
//        if(root.right!=null)
//            sum(root.right,result,sum);
//    }
//public boolean hasPathSum(TreeNode root, int targetSum){//此处往下的代码是正确的。好处在于，如果左子树返回是true，那么就直接返回true，无需遍历右子树了。
//    if(root==null)
//        return false;
//    boolean tranverse = tranverse(root, targetSum);
//    return tranverse;
//}
//public boolean tranverse(TreeNode root, int targetSum){
//    targetSum-=root.val;
//    if(root.left==null&&root.right==null&&targetSum==0)
//        return true;
//    if(root.left==null&&root.right==null&&targetSum!=0)
//        return false;
//    if(root.left!=null){
////        targetSum-=root.left.val;
//        if(hasPathSum(root.left,targetSum))
//            return true;
////        targetSum+=root.left.val;
//    }
//    if(root.right!=null){
////        targetSum-=root.right.val;
//        if(hasPathSum(root.right,targetSum))
//            return true;
////        targetSum+=root.right.val;
//    }
//    return false;
//}
}
