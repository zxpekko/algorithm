package binarytree;

/**
 * @Author:zxp
 * @Description:给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 示例 3:
 *
 * 输入: root = [], key = 0
 * 输出: []
 *
 *
 * 提示:
 *
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 * @Date:16:13 2023/12/30
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key){
        if(root==null)
            return root;//1.找不到2.左右都为空.3左为空右不为空4左不为空右为空。5左右都不为空
        if(root.val==key){
            if(root.left==null&&root.right==null)
                return null;
            else if(root.left!=null&&root.right==null)
                return root.left;
            else if(root.left==null&&root.right!=null)
                return root.right;
            else {
                TreeNode cur=root.right;
                while (cur.left!=null)
                    cur=cur.left;
                cur.left=root.left;
                return root.right;
            }
        }
        if(root.val>key)
            root.left=deleteNode(root.left,key);
        else
            root.right=deleteNode(root.right,key);
        return root;
    }
//    public TreeNode findeTarget(TreeNode root,int key){
//        if(root==null)
//            return root;
//        if(root.val==key)
//            return root;
//        if(root.val>key)
//            return findeTarget(root.left,key);
//        else
//            return findeTarget(root.right,key);
////        return null;
//    }
//    public TreeNode findLeft(TreeNode node){
//        while (node.left!=null&&node.right!=null){
//            node=node.left;
//        }
//        return node;
//    }
}