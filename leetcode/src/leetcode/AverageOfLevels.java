package leetcode;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * @Date:10:03 2023/11/15
 */
public class AverageOfLevels {
    public static void main(String[] args) {

    }
    public List<Double> averageOfLevels(TreeNode root){
        List<Double> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            double sum=0;
            int count= queue.size();
            for(int i=0;i<count;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
                sum+=poll.val;
            }
            result.add(sum/count);
        }
        return result;
    }
}
