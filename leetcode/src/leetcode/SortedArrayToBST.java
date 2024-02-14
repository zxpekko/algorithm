package leetcode;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:38 2023/8/19
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums){
        TreeNode treeNode = create(0, nums.length - 1, nums);

        return treeNode;
    }
    public TreeNode create(int left,int rignt,int[] nums){
        if(rignt-left<0)
            return null;
        TreeNode root=new TreeNode();
        root.val=nums[(left+rignt)/2];
        root.left=create(left,(left+rignt)/2-1,nums);
        root.right=create((left+rignt)/2+1,rignt,nums);
        return root;
    }
}
