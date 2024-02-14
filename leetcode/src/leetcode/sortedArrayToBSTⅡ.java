package leetcode;

/**
 * @Author:zxp
 * @Description:给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 * @Date:18:13 2023/9/1
 */
public class sortedArrayToBSTⅡ {
    public TreeNode sortedArrayToBST(int[] nums){
//        TreeNode treeNode = new TreeNode();
        TreeNode treeNode = create(nums, 0, nums.length - 1);
        return treeNode;
    }
    public TreeNode create(int[] nums,int left,int right){
        if(right-left<0)
            return null;
        int rootIndex=(left+right)/2;
        TreeNode root = new TreeNode();
        root.val=nums[rootIndex];
        root.left=create(nums,left,rootIndex-1);
        root.right=create(nums,rootIndex+1,right);
        return root;
    }
}
