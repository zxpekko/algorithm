package binarytree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 * @Date:13:59 2023/12/27
 */
public class GetMinimumDifference {
    public int getMinimumDifference(TreeNode root){
        int minDifference=Integer.MAX_VALUE;
        //拟采用中序遍历加两两判断的方式，下面开始尝试编码。
        List<Integer> result=new ArrayList<>();
        inorder(root,result);
        for(int i=0;i<result.size()-1;i++){
            if(result.get(i+1)-result.get(i)<minDifference)
                minDifference=result.get(i+1)-result.get(i);
        }
        return minDifference;
    }
    public void inorder(TreeNode root, List<Integer> result){
        if(root==null)
            return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }

}
