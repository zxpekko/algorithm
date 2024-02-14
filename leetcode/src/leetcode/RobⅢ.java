package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:337
 *
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 *
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 示例 2:
 *
 *
 *
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * @Date:12:24 2023/9/7
 */
public class RobⅢ {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.right=treeNode4;
        RobⅢ robⅢ = new RobⅢ();
        System.out.println(robⅢ.rob(treeNode));

    }
    public int rob(TreeNode root){
        Map<TreeNode,Integer> select=new HashMap<>();
        Map<TreeNode,Integer> notSelect=new HashMap<>();
        dfs(root,select,notSelect);

        return Math.max(select.getOrDefault(root,0),notSelect.getOrDefault(root,0));
    }
    public void dfs(TreeNode root,Map<TreeNode,Integer> select,Map<TreeNode,Integer> notSelect){
        if(root==null)
            return;
        dfs(root.left,select,notSelect);
        dfs(root.right,select,notSelect);
        select.put(root,root.val+notSelect.getOrDefault(root.left,0)+notSelect.getOrDefault(root.right,0));
        notSelect.put(root,Math.max(select.getOrDefault(root.left,0),notSelect.getOrDefault(root.left,0))+Math.max(select.getOrDefault(root.right,0),notSelect.getOrDefault(root.right,0)));
    }

}
