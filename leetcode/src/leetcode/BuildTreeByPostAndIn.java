package leetcode;

/**
 * @Author:zxp
 * @Description:给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * @Date:11:43 2023/8/19
 */
public class BuildTreeByPostAndIn {
    public TreeNode buildTree(int[] inorder, int[] postorder){
        TreeNode treeNode = create(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
        return treeNode;
    }
    public TreeNode create(int inL,int inR,int postL,int postR,int[] inorder,int[] postorder){
        if(postR-postL<0)
            return null;
        TreeNode root=new TreeNode();
        root.val=postorder[postR];
        int k;
        for(k=inL;k<=inR;k++){
            if(inorder[k]==postorder[postR])
                break;
        }
        int numLeft=k-inL;
        root.left=create(inL,k-1,postL,postL+numLeft-1,inorder,postorder);
        root.right=create(k+1,inR,postL+numLeft,postR-1,inorder,postorder);
        return root;
    }
}
