package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * @Date:13:03 2023/8/21
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode node1=new TreeNode(4);
        TreeNode node2=new TreeNode(8);
        TreeNode node3=new TreeNode(11);
        TreeNode node4=new TreeNode(13);
        TreeNode node5=new TreeNode(4);
        TreeNode node6=new TreeNode(7);
        TreeNode node7=new TreeNode(2);
        TreeNode node8=new TreeNode(5);
        TreeNode node9=new TreeNode(1);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=null;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node5.left=node8;
        node5.right=node9;
        PathSum pathSum = new PathSum();
        List<List<Integer>> list = pathSum.pathSum(root, 22);
        System.out.println(list);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        if(root==null)
            return result;
        dfs(root,targetSum,result,subResult);
        return result;
    }
    public void dfs(TreeNode root,int targetSum,List<List<Integer>> result,List<Integer> subResult){
        if(root==null)
            return;
        if(root.left==null&&root.right==null&&targetSum-root.val==0){
            subResult.add(root.val);
            result.add(new ArrayList<>(subResult));
            int curSize=subResult.size();
            subResult.remove(curSize-1);
            return;
        }
        if(root.left==null&&root.right==null)
            return;
        int residue=targetSum- root.val;
        subResult.add(root.val);
        dfs(root.left,residue,result,subResult);

        dfs(root.right,residue,result,subResult);
        int size=subResult.size();
//        residue+=subResult.get(size-1);
        subResult.remove(size-1);
    }
}
