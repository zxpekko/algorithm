package leetcode;

import javax.swing.*;
import java.util.*;

/**
 * @Author:zxp
 * @Description:给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 *输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 * @Date:14:55 2023/8/18
 */
public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int flag=1;
        while (!queue.isEmpty()){
            List<Integer> currentLevelOrder=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                currentLevelOrder.add(poll.val);
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
            }
            if(flag==1){
                result.add(currentLevelOrder);
                flag=-1;
            }
            else if(flag==-1){
                currentLevelOrder=reverseList(currentLevelOrder);
                result.add(currentLevelOrder);
                flag=1;
            }
        }

        return result;
    }
    public List<Integer> reverseList(List<Integer> list){
        int[] ret = new int[list.size()];
        for(int i=0;i< ret.length;i++){
            ret[i]=list.get(i);
        }
        for(int i=0,j= ret.length-1;i<j;i++,j--){
            int temp=ret[i];
            ret[i]=ret[j];
            ret[j]=temp;
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i< ret.length;i++){
            result.add(ret[i]);
        }

        return result;
    }
}
