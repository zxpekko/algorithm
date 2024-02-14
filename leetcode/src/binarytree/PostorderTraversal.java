package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:9:54 2023/12/18
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.right=treeNode1;
        treeNode1.left=treeNode2;
        System.out.println(postorderTraversal.postorderTraversal(treeNode));
        System.out.println(postorderTraversal.postorderTraversalⅡ(treeNode));
    }
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        postOrder(root,result);
        return result;
    }
    public void postOrder(TreeNode root,List<Integer> result){
        if(root==null)
            return;
        postOrder(root.left,result);
        postOrder(root.right,result);
        result.add(root.val);
    }
    public List<Integer> postorderTraversalⅡ(TreeNode root){//左右跟，可以先实现根右左，再翻转
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            if(peek!=null){
                result.add(peek.val);
                stack.pop();
                if(peek.left!=null)
                    stack.push(peek.left);
                if(peek.right!=null)
                    stack.push(peek.right);
            }
        }
        List<Integer> lastResult=new ArrayList<>();
        for(int i= result.size()-1;i>=0;i--){
            lastResult.add(result.get(i));
        }
        return lastResult;
    }
}
