package binarytree;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：["1"]
 *
 *
 * 提示：
 *
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 * @Date:17:02 2023/12/23
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root){
        List<String> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        if(root==null)
            return result;
        path(root,result,subResult);
        return result;
    }
    public void path(TreeNode node,List<String> result,List<Integer> subResult){
        subResult.add(node.val);
        if(node.left==null&&node.right==null){
            String transpose = transpose(subResult);
            result.add(transpose);
//            return;//加这句也能通过，但是时间慢了一倍。
        }
        if(node.left!=null){
            path(node.left,result,subResult);
            subResult.remove(subResult.size()-1);
        }
        if(node.right!=null){
            path(node.right,result,subResult);
            subResult.remove(subResult.size()-1);
        }
    }
    public String transpose(List<Integer> subResult){
        StringBuilder subString= new StringBuilder();
        for(int i=0;i<subResult.size();i++){
            if(i!=subResult.size()-1){
                subString.append(subResult.get(i));
                subString.append("->");
            }
            else {
                subString.append(subResult.get(i));
            }
        }
        return subString.toString();
    }
}
