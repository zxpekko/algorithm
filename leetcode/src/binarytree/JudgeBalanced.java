package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:05 2023/12/23
 */
public class JudgeBalanced {
    public boolean isBalanced(TreeNode root){
        if(root==null)
            return true;
        int left=CountHeight(root.left);
        int right=CountHeight(root.right);
        boolean all = Math.abs(left - right) <= 1;
        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);
        return all&&leftBalanced&&rightBalanced;
    }
    public int CountHeight(TreeNode node){//后序遍历计算树的高度，左右，根在最后一行，其实也可以拆开来。
        if(node==null)
            return 0;
        int leftHeight = CountHeight(node.left);
        int rightHeight = CountHeight(node.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}
