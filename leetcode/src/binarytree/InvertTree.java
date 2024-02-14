package binarytree;

import java.util.*;

/**
 * @Author:zxp
 * @Description:给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 * @Date:20:14 2023/12/19
 */
public class InvertTree {
//    public TreeNode invertTree(TreeNode root){
//        if(root==null)
//            return root;
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            int size=queue.size();
//            TreeNode[] treeNodes=new TreeNode[size];
//            for(int i=0;i<size;i++){
//                TreeNode poll = queue.poll();
//                treeNodes[i]=poll;
//                if(poll.left!=null)
//                    queue.offer(poll.left);
//                if(poll.right!=null)
//                    queue.offer(poll.right);
//            }
//            inverse(treeNodes);
//        }
//        return null;
//    }
//    public TreeNode[] inverse(TreeNode[] treeNode){
//        int n= treeNode.length;
//        for(int i=0,j=n-1;i<j;i++,j--){
//            TreeNode temp=treeNode[i];
//            treeNode[i]=treeNode[j];
//            treeNode[j]=temp;
//        }
//        return treeNode;
//    }
      public TreeNode invertTree(TreeNode root){
          invert(root);
          return root;
      }
      public void invert(TreeNode root){//此处前序遍历，也可以后序遍历，中序有点搞，不建议。层序也可以
          if(root==null)
              return;
          TreeNode temp=root.left;
          root.left=root.right;
          root.right=temp;
          invert(root.left);
          invert(root.right);
      }
      public void swap(TreeNode rootLeft,TreeNode rootRight){
          TreeNode temp=rootLeft;
          rootLeft=rootRight;
          rootRight=temp;
      }
     public TreeNode invertTreeⅡ(TreeNode root){//这是前序遍历的迭代法实现的翻转二叉树。
         Stack<TreeNode> stack=new Stack<>();
         stack.push(root);
         while (!stack.isEmpty()){
             TreeNode pop = stack.pop();
             if(pop!=null){
                 TreeNode temp=pop.left;
                 pop.left=pop.right;
                 pop.right=temp;
                 if(pop.right!=null)
                     stack.push(pop.right);
                 if(pop.left!=null)
                     stack.push(pop.left);
             }
         }
         return root;
     }
     //后序遍历的思路：先使用迭代法，根右左，然后逆置，将所有的节点放入对象数组中，然后对这个对象数组进行遍历，每次都翻转左右孩子。
     public TreeNode invertTreeⅢ(TreeNode root){//后序遍历的迭代法实现二叉树的翻转
          Stack<TreeNode> stack=new Stack<>();
          if(root==null)
              return null;
          stack.push(root);
          List<TreeNode> result=new ArrayList<>();
          while (!stack.isEmpty()){
              TreeNode pop = stack.pop();
              result.add(pop);
              if(pop.left!=null)
                  stack.push(pop.left);
              if(pop.right!=null)
                  stack.push(pop.right);
          }
          for(int i=result.size()-1;i>=0;i--){
              TreeNode treeNode=result.get(i);
              TreeNode temp=treeNode.left;
              treeNode.left=treeNode.right;
              treeNode.right=temp;
          }
          return root;
     }
    public TreeNode invertTreeⅣ(TreeNode root){//层序遍历实现二叉树的翻转
          Queue<TreeNode> queue=new LinkedList<>();
          queue.offer(root);
          if(root==null)
              return root;
          while (!queue.isEmpty()){
              TreeNode poll = queue.poll();
              TreeNode temp=poll.left;
              poll.left=poll.right;
              poll.right=temp;
              if(poll.left!=null)
                  queue.offer(poll.left);
              if(poll.right!=null)
                  queue.offer(poll.right);
          }
          return root;
    }
    public TreeNode invertTreeⅤ(TreeNode root){
          invertLogic(root);
          return root;
    }
    public void invertLogic(TreeNode root){
          if(root==null)
              return;
//          swapNode(root.left,root.right);
          TreeNode temp=new TreeNode();
          temp=root.left;
          root.left=root.right;
          root.right=temp;
          invertLogic(root.left);
          invertLogic(root.right);
    }
    public void swapNode(TreeNode root1,TreeNode root2){
          TreeNode temp=new TreeNode();
          temp=root1;
          root1=root2;
          root2=temp;
    }
}
