package leetcode;

/**
 * @Author:zxp
 * @Description:给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * @Date:10:51 2023/8/19
 */
public class BuildTreeByPreAndIn {
    public static void main(String[] args) {
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        BuildTreeByPreAndIn buildTreeByPreAndIn = new BuildTreeByPreAndIn();
        TreeNode treeNode = buildTreeByPreAndIn.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder){
        TreeNode treeNode = create(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);

        return treeNode;
    }
    public TreeNode create(int preL,int preR,int inL,int inR,int[] preorder,int[] inorder){
        if(preR-preL<0)
            return null;
        TreeNode root=new TreeNode();
        root.val=preorder[preL];
        int numLeftTree=0;
        int rootloc=0;
        for(int k=inL;k<=inR;k++){
            if(inorder[k]==preorder[preL]){
                numLeftTree=k-inL;
                rootloc=k;
                break;
            }
        }
        root.left=create(preL+1,preL+numLeftTree,inL,rootloc-1,preorder,inorder);
        root.right=create(preL+numLeftTree+1,preR,rootloc+1,inR,preorder,inorder);

        return root;
    }
}
