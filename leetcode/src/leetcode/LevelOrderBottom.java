package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:37 2023/8/18
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
//        List<List<Integer>> result=new ArrayList<>();
        List<List<Integer>> result=new LinkedList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> currentLevelOrder=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                currentLevelOrder.add(poll.val);
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
            }
            result.add(0,currentLevelOrder);
        }
//        result=reverseList(result);
        return result;
    }
    public List<List<Integer>> reverseList(List<List<Integer>> list){
        List<List<Integer>> result=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            result.add(list.get(i));
        }
        return result;
    }
}
