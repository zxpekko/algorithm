package graphtheory;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 *
 *
 *
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 *
 * 提示：
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即不存在自环）
 * graph[i] 中的所有元素 互不相同
 * @Date:20:13 2024/1/31
 */
public class AllPathsSourceTarget {
    public static void main(String[] args) {
        AllPathsSourceTarget allPathsSourceTarget = new AllPathsSourceTarget();
        List<List<Integer>> list = allPathsSourceTarget.allPathsSourceTarget(new int[][]{{4,3,1}, {3,2,4}, {3}, {4},{}});
        System.out.println(list);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
//        subResult.add(0);
        backtracking(graph,0,result,subResult);
        return result;
    }
    public void backtracking(int[][] graph,int cur, List<List<Integer>> result, List<Integer> subResult){
        if(cur==0)
            subResult.add(cur);
        if(cur==graph.length-1){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=0;i<graph[cur].length;i++){
            subResult.add(graph[cur][i]);
            backtracking(graph,graph[cur][i],result,subResult);
            subResult.remove(subResult.size()-1);
        }
    }
}
