package binarytree;

//import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:9:45 2023/12/18
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.right=treeNode1;
        treeNode1.left=treeNode2;
        System.out.println(preorderTraversal.preorderTraversal(treeNode));
        System.out.println(preorderTraversal.preorderTraversalⅡ(treeNode));

    }
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        preOrder(root,result);
        return result;
    }
    public void preOrder(TreeNode root,List<Integer> result){
        if(root==null)
            return;
        result.add(root.val);
        preOrder(root.left,result);
        preOrder(root.right,result);
    }
    public List<Integer> preorderTraversalⅡ(TreeNode root){//此为迭代法实现前序遍历
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        List<Integer> result=new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            stack.pop();
            if(peek!=null){
                result.add(peek.val);

                if(peek.right!=null)
                    stack.push(peek.right);
                if(peek.left!=null)
                    stack.push(peek.left);
            }

        }
        return result;
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
