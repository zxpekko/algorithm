package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:9:57 2023/12/18
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        inOrder(root,result);
        return result;
    }
    public void inOrder(TreeNode root,List<Integer> result){
        inOrder(root.left,result);
        result.add(root.val);
        inOrder(root.right,result);
    }
    public List<Integer> inorderTraversalⅡ(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;//指针遍历节点
        while (current!=null||!stack.isEmpty()){
            if(current!=null){
                stack.push(current);
                current=current.left;
            }
            else {
                current = stack.pop();
                result.add(current.val);
                current=current.right;
            }
        }
        return result;
    }
}
