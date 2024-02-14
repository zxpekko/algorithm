package binarytree;

import org.junit.Test;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.util.*;

/**
 * @Author:zxp
 * @Description:给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 *
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * 示例 3：
 *
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 * 示例 4：
 *
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 * @Date:15:08 2024/1/2
 */
public class ConvertBST {
//    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(3);
//        TreeNode treeNode1 = new TreeNode(2);
//        TreeNode treeNode2 = new TreeNode(4);
//        TreeNode treeNode3 = new TreeNode(1);
//        treeNode.left=treeNode1;
//        treeNode.right=treeNode2;
//        treeNode1.left=treeNode3;
//        ConvertBST convertBST = new ConvertBST();
//        System.out.println(convertBST.convertBST(null));
//
//    }
//    public TreeNode convertBST(TreeNode root){
//        List<Integer> inorder=new ArrayList<>();
//        inorder(root,inorder);
//        int down=(0+inorder.size()-1)/2;
//        int up=(int)Math.ceil((double) (0+inorder.size()-1)/2);
//        TreeNode construct=null;
//        if(root==null)
//            return root;
//        else if(inorder.get(down)==root.val)
//            construct = construct(inorder,0,inorder.size()-1);
//        else construct=constructCeil(inorder,0,inorder.size()-1);
//        return construct;
//    }
//    public void inorder(TreeNode root,List<Integer> inorder){
//        if(root==null)
//            return;
//        inorder(root.left,inorder);
//        inorder.add(root.val);
//        inorder(root.right,inorder);
//    }
//    public int getSum(List<Integer> inorder,int target){
//        int sum=0;
//        for(int i=0;i<inorder.size();i++){
//            if(inorder.get(i)>=target)
//                sum+=inorder.get(i);
//        }
//        return sum;
//    }
//    public TreeNode construct(List<Integer> inorder,int left,int right){
//        if(left>right)
//            return null;
//        int mid=(left+right)/2;
//        int target=inorder.get(mid);
//        int sum = getSum(inorder, target);
//        TreeNode root = new TreeNode(sum);
//        root.left=construct(inorder,left,mid-1);
//        root.right=construct(inorder,mid+1,right);
//        return root;
//    }
//    public TreeNode constructCeil(List<Integer> inorder,int left,int right){
//        if(left>right)
//            return null;
//        int mid=(int)Math.ceil((double)(left+right)/2);
//        int target=inorder.get(mid);
//        int sum = getSum(inorder, target);
//        TreeNode root = new TreeNode(sum);
//        root.left=constructCeil(inorder,left,mid-1);
//        root.right=constructCeil(inorder,mid+1,right);
//        return root;
//    }
    public TreeNode convertBST(TreeNode root){//这个算法是自己想到的，完全没有用到二叉搜索树的性质，、
        // 采用中序遍历得到数值数组，然后通过层序遍历一个个修改节点的值，时间性能可以说是相当的差。
        if(root==null)
            return root;
        List<Integer> inorder=new ArrayList<>();
        inorder(root,inorder);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            int sum = getSum(inorder, poll.val);
            poll.val=sum;
            if(poll.left!=null)
                queue.offer(poll.left);
            if(poll.right!=null)
                queue.offer(poll.right);
        }
        return root;
    }
    public void inorder(TreeNode root,List<Integer> inorder){
        if(root==null)
            return;
        inorder(root.left,inorder);
        inorder.add(root.val);
        inorder(root.right,inorder);
    }
    public int getSum(List<Integer> inorder,int target){
        int sum=0;
        for(int i=0;i< inorder.size();i++){
            if(inorder.get(i)>=target)
                sum+=inorder.get(i);
        }
        return sum;
    }

    TreeNode pre=null;//此处向下的算法是受到其他视频的启发，反向中序遍历，在遍历的过程中使用双指针，
    // 维护当前节点的前一个节点，然后将前一个节点的值加到自身身上。时间性能大大提升。
    public TreeNode convertBSTⅡ(TreeNode root){
        invertInorder(root);
        return root;
    }
    public void invertInorder(TreeNode root){
        if(root==null)
            return;
        invertInorder(root.right);
        if(pre!=null)
            root.val+=pre.val;
        pre=root;
        invertInorder(root.left);
    }
    @Test
    public void test(){
        int a=(int)Math.ceil((double)5/2);
        System.out.println(a);
    }
}