package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * 示例 2：
 *
 *
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 * @Date:22:24 2023/9/2
 */
public class SumNumbers {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        SumNumbers sumNumbers = new SumNumbers();
        System.out.println(sumNumbers.sumNumbers(treeNode));
    }
    public int sumNumbers(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        dfs(root,result,subResult);
        System.out.println(result);
        int total=0;
        for (List<Integer> list : result) {
            System.out.println(getSubNumber(list));
            total+=getSubNumber(list);
        }
        return total;
    }
    public void dfs(TreeNode root,List<List<Integer>> result,List<Integer> subResult){
        if(root.left==null&&root.right==null){
            subResult.add(root.val);
            result.add(new ArrayList<>(subResult));
            subResult.remove(subResult.size()-1);
            return;
        }
        if(root.left!=null){
            subResult.add(root.val);
            dfs(root.left,result,subResult);
            if(subResult.size()>0){
                subResult.remove(subResult.size()-1);
            }
        }
//        subResult.remove(subResult.size()-1);

        if(root.right!=null){
            subResult.add(root.val);
            dfs(root.right,result,subResult);
//            subResult.remove(subResult.size()-1);
            if(subResult.size()>0){
                subResult.remove(subResult.size()-1);
            }
        }


    }
    public int getSubNumber(List<Integer> SubResult){
        int sum=0;
        for(int i= SubResult.size()-1,j=0;i>=0;i--,j++){
            Integer integer = SubResult.get(i);
            sum+=(integer*Math.pow(10,j));
//            System.out.println("j"+j);
        }
        return sum;
    }
    @Test
    public void test(){
        System.out.println(Math.pow(10, 2));
    }

}
