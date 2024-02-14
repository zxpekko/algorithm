package binarytree;

/**
 * @Author:zxp
 * @Description:给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[4,2,7,1,3,5]
 * 解释：另一个满足题目要求可以通过的树是：
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [40,20,60,10,30,50,70], val = 25
 * 输出：[40,20,60,10,30,50,70,null,null,25]
 * 示例 3：
 * <p>
 * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * 输出：[4,2,7,1,3,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数将在 [0, 104]的范围内。
 * -108 <= Node.val <= 108
 * 所有值 Node.val 是 独一无二 的。
 * -108 <= val <= 108
 * 保证 val 在原始BST中不存在。
 * @Date:20:03 2023/12/29
 */
public class InsertIntoBST {
    public static void main(String[] args) {
        InsertIntoBST insertIntoBST = new InsertIntoBST();
        TreeNode treeNode = new TreeNode();
        treeNode = null;
        TreeNode treeNode1 = insertIntoBST.insertIntoBST(treeNode, 2);
        System.out.println(treeNode1);
        System.out.println(treeNode);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode treeNode = new TreeNode(val);
            return treeNode;
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else
            root.right = insertIntoBST(root.right, val);

        return root;
    }
//    public void insert(TreeNode root,int val){
//        if(root==null){
//            root=new TreeNode(val);
//            return;
//        }
//        else if(root.left==null&&root.right==null){
//            if(root.val>val)
//                root.left=new TreeNode(val);
//            else
//                root.right=new TreeNode(val);
//        }
//        else if(root.val>val)
//            insert(root.left,val);
//        else if(root.val<val)
//            insert(root.right,val);
//    }
}
