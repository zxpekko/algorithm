package leetcode;

/**
 * @Author:zxp
 * @Description:给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *
 * @Date:11:32 2023/8/21
 */
public class HasPathSum {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
//        TreeNode node2=new TreeNode(3);
        root.left=node1;
//        root.right=node2;
        HasPathSum hasPathSum = new HasPathSum();
        boolean b = hasPathSum.hasPathSum(root, 1);
        System.out.println(b);

    }
    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root==null)
            return false;
        boolean res = dfs(root, targetSum);
        return res;
    }
    public boolean dfs(TreeNode root,int targetSum){
        if(root==null)
            return false;
        if(root.left==null&&root.right==null&&targetSum-root.val==0)
            return true;
        if(root.left == null && root.right == null)
            return false;
//        if(targetSum==0)
//            return true;
//        if(targetSum<0)
//            return false;

        int residue=targetSum- root.val;
        boolean left = dfs(root.left, residue);
        boolean right = dfs(root.right, residue);
        return left||right;
    }
}
