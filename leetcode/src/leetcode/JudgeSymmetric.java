package leetcode;

/**
 * @Author:zxp
 * @Description:给你二叉树的根节点 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @Date:10:40 2023/8/17
 */
public class JudgeSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(2);
        TreeNode left3 = new TreeNode(3);
        TreeNode left4 = new TreeNode(4);
        TreeNode right4 = new TreeNode(4);
        TreeNode right3 = new TreeNode(3);
        root.left=left2;
        root.right=right2;
        left2.left=left3;
        left2.right=left4;
        right2.left=right4;
        right2.right=right3;
        JudgeSymmetric judgeSymmetric = new JudgeSymmetric();
        boolean symmetric = judgeSymmetric.isSymmetric(root);
        System.out.println(symmetric);
    }

    public boolean isSymmetric(TreeNode root){
        if(root==null)
            return true;
        boolean isSymmetric=CheckSubTree(root.left,root.right);
        return isSymmetric;
    }
    public boolean CheckSubTree(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return true;
        if((root1==null&&root2!=null)||(root1!=null&&root2==null))
            return false;
        if(root1.val!= root2.val)
            return false;
        boolean leftCase=CheckSubTree(root1.left,root2.right);
        boolean rightCase=CheckSubTree(root1.right,root2.left);
        return leftCase&&rightCase;
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}
