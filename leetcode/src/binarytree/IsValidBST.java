package binarytree;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *
 * @Date:21:04 2023/12/26
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root){
        List<Integer> result=new ArrayList<>();
        inorder(root,result);
        for(int i=0;i< result.size()-1;i++){
            if(result.get(i)>=result.get(i+1))
                return false;
        }
        return true;
    }
    public void inorder(TreeNode root, List<Integer> result){
        if(root==null)
            return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
}
