package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 *
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 *
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 *
 * 请你找到所有的 最小高度树 并按  任意顺序 返回它们的根节点标签列表。
 *
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 *
 * 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 * 输出：[1]
 * 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。
 *
 *
 *
 *注：此算法没有问题，但是不能通过力扣测试，原因是时间复杂度很高，但是这个方法在力扣的官方题解中给出了。
 * @Date:19:56 2023/8/23
 */
public class FindMinHeightTrees {
    public static void main(String[] args) {
//        int[][] edges={{1,0},{1,2},{1,3}};
        int[][] edges={{3,0},{3,1},{3,2},{3,4},{5,4}};
        FindMinHeightTrees findMinHeightTrees = new FindMinHeightTrees();
        List<Integer> minHeightTrees = findMinHeightTrees.findMinHeightTrees(6, edges);
        System.out.println(minHeightTrees);
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges){

        List<Integer> minHeightRoot=new ArrayList<>();
        if(edges.length==0){
            minHeightRoot.add(0);
            return minHeightRoot;
        }
        List<List<Integer>> neighbors=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> neighbor=new ArrayList<>();
            neighbors.add(neighbor);
        }
        for(int[] edge:edges){
            int node1=edge[0];
            int node2=edge[1];
            neighbors.get(node1).add(node2);
            neighbors.get(node2).add(node1);
        }

        int minHeight=20001;
        for(int i=0;i<n;i++){
            int height = Height(n, i, edges,neighbors);
            if(height==minHeight){
                minHeightRoot.add(i);
            }
//            System.out.println(height);
            if(height<minHeight){
                minHeight=height;
                minHeightRoot.removeAll(minHeightRoot);
                minHeightRoot.add(i);
            }
        }
//        System.out.println(minHeight);
//        for(int i=0;i<n;i++){
//            int height = Height(n, i, edges,neighbors);
//            if(height==minHeight)
//                minHeightRoot.add(i);
//        }
        return minHeightRoot;
    }
    public int Height(int n,int rootId,int[][] edges,List<List<Integer>> neighbors){
//        List<List<Integer>> neighbors=new ArrayList<>();
//        for(int i=0;i<n;i++){
//            List<Integer> neighbor=new ArrayList<>();
//            neighbors.add(neighbor);
//        }
//        for(int[] edge:edges){
//            int node1=edge[0];
//            int node2=edge[1];
//            neighbors.get(node1).add(node2);
//            neighbors.get(node2).add(node1);
//        }
//        System.out.println(neighbors);
        boolean[] visited = new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(rootId);
        visited[rootId]=true;
        int height=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Integer poll = queue.poll();
                for(int neighbor:neighbors.get(poll)){
                    if(visited[neighbor]==false){
                        queue.offer(neighbor);
                        visited[neighbor]=true;
                    }
                }
            }
            height++;
        }
        return height;
    }
}
