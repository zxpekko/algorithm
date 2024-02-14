package binarytree;

/**
 * @Author:zxp
 * @Description:给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * @Date:11:08 2023/12/20
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root){
        if(root==null)
            return true;
        boolean b = judgeLeftAndRight(root.left, root.right);
        return b;
    }
    public boolean judgeLeftAndRight(TreeNode root1,TreeNode root2){
        if((root1==null&&root2!=null)||(root1!=null&&root2==null))
            return false;
        else if(root1==null&&root2==null)
            return true;
        else if(root1.val!= root2.val)
            return false;
        boolean b = judgeLeftAndRight(root1.left, root2.right);
        boolean b1 = judgeLeftAndRight(root1.right, root2.left);
        return b&&b1;
    }
    public boolean isSymmetricⅡ(TreeNode root){
        if(root==null)return true;
        boolean judge = judge(root.left, root.right);
        return judge;
    }
    public boolean judge(TreeNode root1,TreeNode root2){
        if((root1==null&&root2!=null)||(root1!=null&&root2==null))
            return false;
        else if(root1==null&&root2==null)
            return true;
        else if(root1.val!=root2.val)
            return false;
        boolean judge = judge(root1.left, root2.right);
        boolean judge1 = judge(root1.right, root2.left);
        return judge&&judge1;
    }
}
