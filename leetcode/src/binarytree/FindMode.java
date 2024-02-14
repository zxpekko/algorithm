package binarytree;

import javax.swing.*;
import java.net.InetAddress;
import java.util.*;

/**
 * @Author:zxp
 * @Description:给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * 假定 BST 满足如下定义：
 *
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：root = [0]
 * 输出：[0]
 *
 *
 * 提示：
 *
 * 树中节点的数目在范围 [1, 104] 内
 * -105 <= Node.val <= 105
 * @Date:14:15 2023/12/27
 */
public class FindMode {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val=1;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val=2;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val=2;
//        treeNode.right=treeNode1;
        treeNode1.left=treeNode2;
        FindMode findMode = new FindMode();
        int[] mode = findMode.findMode(treeNode);
        System.out.println(Arrays.toString(mode));

    }
//    public int[] findMode(TreeNode root){
//        List<Integer> result=new ArrayList<>();
//
//        inorder(root,result);
//        if(root.left==null&&root.right==null)
//            return new int[]{root.val};
////        System.out.println(result);
//        int count=1;
//        int maxCount= 1;
//        for(int i=0;i<result.size()-1;i++){
//            if(result.get(i+1)==result.get(i)){
//                count++;
//            }
//            else {
//                if(count>maxCount)
//                    maxCount=count;
//                count=1;
//            }
//        }
//        if(count>maxCount)
//            maxCount=count;
//        List<Integer> lastResult=new ArrayList<>();
//        int countMax=1;
//        for(int i=0;i<result.size()-1;i++){
//            if(result.get(i)==result.get(i+1))
//                countMax++;
////            else {
////                if(countMax==maxCount){
////                    lastResult.add(result.get(i));
////                }
////                countMax=1;
////            }
//            if(countMax==maxCount)
//                lastResult.add(result.get(i));
//            if(result.get(i)!=result.get(i+1))
//                countMax=1;
//        }
//        int[] last = new int[lastResult.size()];
//        for(int i=0;i<last.length;i++){
//            last[i]=lastResult.get(i);
//        }
//        return last;
//    }

    /**
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        inorder(root,result);
        for(int i=0;i<result.size();i++){
            if(map.containsKey(result.get(i))){
                int count=map.get(result.get(i));
                map.put(result.get(i),count+1);
            }
            else map.put(result.get(i),1);
        }
        int maxCount=Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if(integerIntegerEntry.getValue()>maxCount)
                maxCount=integerIntegerEntry.getValue();
        }
        List<Integer> lastResult=new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if(integerIntegerEntry.getValue()==maxCount)
                lastResult.add(integerIntegerEntry.getKey());
        }
        int[] last = new int[lastResult.size()];
        for(int i=0;i<last.length;i++){
            last[i]=lastResult.get(i);
        }
        return last;
    }

    public void inorder(TreeNode root, List<Integer> result){
        if(root==null)
            return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }

    /**
     *
     */
    TreeNode pre=null;//此处向下的方法是代码随想录中的双指针的遍历思想，上面的是暴力中序遍历，加两遍遍历map集合的方式得到最终的结果，性能很差（自己的猪脑想的。）
    int count=0;
    int maxCount=0;
    List<Integer> midResult=new ArrayList<>();

    /**
     *
     * @param root
     * @return
     */
    public int[] findModeⅡ(TreeNode root){
        traversal(root);
        int[] result = new int[midResult.size()];
        for(int i=0;i<result.length;i++){
            result[i]=midResult.get(i);
        }
        return result;
    }

    /**
     *
     * @param cur
     */
    public void traversal(TreeNode cur){
        if(cur==null)
            return;
        traversal(cur.left);
        if(pre==null)
            count=1;
        else if(pre.val==cur.val)
            count++;
        else
            count=1;
        pre=cur;
        if(count==maxCount)//
            midResult.add(cur.val);
        if(count>maxCount){//动态更新maxCount的值，因此只需要遍历一次树就可以了。
            midResult.clear();
            midResult.add(cur.val);
            maxCount=count;
        }
        traversal(cur.right);
    }
}