package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:01 2023/12/25
 */
public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder){
        TreeNode treeNode = inorderAndPostorder(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
        return treeNode;
    }
    public TreeNode inorderAndPostorder(int inoderL,int inorderR,int postorderL,int postorderR,int[] inorder,int[] postorder){
        if(inoderL>inorderR)
            return null;
        TreeNode root=new TreeNode();
        root.val=postorder[postorderR];
        int rootIndex=0;
        for(rootIndex=inoderL;rootIndex<=inorderR;rootIndex++){
            if(inorder[rootIndex]==postorder[postorderR])
                break;
        }
        int leftNum=rootIndex-inoderL;
        root.left=inorderAndPostorder(inoderL,rootIndex-1,postorderL,postorderL+leftNum-1,inorder,postorder);
        root.right=inorderAndPostorder(rootIndex+1,inorderR,postorderL+leftNum,postorderR-1,inorder,postorder);
        return root;
    }
}
