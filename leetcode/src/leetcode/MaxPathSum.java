package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author:zxp
 * @Description: 124
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 *
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 *
 * 提示：
 *
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * @Date:11:23 2023/9/9
 */
public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(11);
        TreeNode treeNode4 = new TreeNode(13);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(1);

        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode2.left=treeNode3;
        treeNode1.left=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;
        treeNode5.right=treeNode8;
//        treeNode2.right=treeNode4;

        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(treeNode));
    }
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        maxGain(root);
//        Map<TreeNode,Integer> select=new HashMap<>();
//        Map<TreeNode,Integer> notSelect=new HashMap<>();
//        dfs(root,select,notSelect);
//        return Math.max(select.getOrDefault(root,-1001),notSelect.getOrDefault(root,-1001));
        return maxSum;
    }
    public int maxGain(TreeNode root){
        if(root==null)
            return 0;
        int leftGain=Math.max(maxGain(root.left),0);
        int rightGain=Math.max(maxGain(root.right),0);
        int current=root.val+leftGain+rightGain;
        maxSum=Math.max(maxSum,current);
        return root.val+Math.max(leftGain,rightGain);
    }
//    public void dfs(TreeNode root,Map<TreeNode,Integer> select,Map<TreeNode,Integer> notSelect){
//        if(root==null)
//            return;
//        dfs(root.left,select,notSelect);
//        dfs(root.right,select,notSelect);
//        int max1=Math.max(root.val+select.getOrDefault(root.left,-1001)+select.getOrDefault(root.right,-1001), root.val+select.getOrDefault(root.left,-1001) );
//        int max2=Math.max(root.val+select.getOrDefault(root.right,-1001),max1 );
//        int max3=Math.max(max2, root.val);
//        select.put(root,max3);
//        notSelect.put(root,Math.max(Math.max(select.getOrDefault(root.left,-1001),select.getOrDefault(root.right,-1001)),Math.max(notSelect.getOrDefault(root.left,-1001),notSelect.getOrDefault(root.right,-1001))));
//    }
}
