package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 *
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 * @Date:14:34 2023/12/28
 */
public class LowestCommonAncestor {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//        List<TreeNode> resultp=new ArrayList<>();
//        List<TreeNode> resultq=new ArrayList<>();
//        dfs(root,resultp,p);
//        dfs(root,resultq,q);
//        int i=0,j=0;
//        while (i<resultp.size()&&j<resultq.size()){
//            if(resultp.get(i)==resultq.get(j)){
//                i++;
//                j++;
//            }
//        }
//        if(resultp.get(i)!=resultq.get(j)){
//            return resultp.get(i-1);
//        }
//        else if(i==resultp.size()){
//            return resultp.get(i-1);
//        }
//        else
//            return resultq.get(j-1);
////        return null;
//    }
//    public void dfs(TreeNode root, List<TreeNode> result,TreeNode target){
//        if(root==null)
//            return;
//        result.add(root);
//        if(root.val== target.val){
////            result.add(root);
//            return;
//        }
//        if(root.left==null&&root.right==null&&root.val!=target.val){
//            result.remove(result.size()-1);
//            return;
//        }
//        if(root.left==null&&root.right==null&&root.val==target.val)
//            return;
////        else
////            result.add(root);
//        dfs(root.left,result,target);
//        dfs(root.right,result,target);
//    }
      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
          if(root==null)
              return null;
          if(root==p||root==q)
              return root;//找目标节点的逻辑
          TreeNode left=lowestCommonAncestor(root.left,p,q);
          TreeNode right=lowestCommonAncestor(root.right,p,q);
          if(left!=null&&right!=null)//下面是处理根节点的逻辑。
              return root;
          else if(left==null&&right!=null)
              return right;
          else if(left!=null&&right==null) return left;
          return null;
      }
      public TreeNode lowestCommonAncestorⅡ(TreeNode root, TreeNode p, TreeNode q){
          if(root==null)
              return null;
          if(root==p||root==q)
              return root;
          TreeNode left = lowestCommonAncestor(root.left, p, q);
          TreeNode right = lowestCommonAncestor(root.right, p, q);
          if(left!=null&&right!=null)
              return root;
          if(left!=null&&right==null)
              return left;
          if(left==null&&right!=null)
              return right;
          return null;
      }
}
