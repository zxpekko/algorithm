package leetcode;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:给定一个 n
 *  个点 m
 *  条边的有向图，图中可能存在重边和自环，所有边权均为正值。
 *
 * 请你求出 1
 *  号点到 n
 *  号点的最短距离，如果无法从 1
 *  号点走到 n
 *  号点，则输出 −1
 * 。
 *
 * 输入格式
 * 第一行包含整数 n
 *  和 m
 * 。
 *
 * 接下来 m
 *  行每行包含三个整数 x,y,z
 * ，表示存在一条从点 x
 *  到点 y
 *  的有向边，边长为 z
 * 。
 *
 * 输出格式
 * 输出一个整数，表示 1
 *  号点到 n
 *  号点的最短距离。
 *
 * 如果路径不存在，则输出 −1
 * 。
 *
 * 数据范围
 * 1≤n≤500
 * ,
 * 1≤m≤105
 * ,
 * 图中涉及边长均不超过10000。
 *
 * 输入样例：
 * 3 3
 * 1 2 2
 * 2 3 1
 * 1 3 4
 * 输出样例：
 * 3
 * @Date:16:28 2023/11/10
 */
public class DijkstraⅡ {
    public static void main(String[] args) {
        int[][] adj = new int[3][3];
        for(int i=0;i<adj.length;i++){
            Arrays.fill(adj[i],Integer.MAX_VALUE/2);
        }
        adj[0][1]=2;
        adj[1][2]=1;
        adj[0][2]=4;
        DijkstraⅡ dijkstraⅡ = new DijkstraⅡ();
        System.out.println(dijkstraⅡ.Dijkstra(adj, 0));
    }
    public int Dijkstra(int[][] adj,int source){
        boolean[] visited = new boolean[adj.length];
        int[] shortest = new int[adj.length];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
        for(int i=0;i<adj.length;i++){
            int k=-1;//新的中间节点
            for(int j=0;j<adj.length;j++){
                if(visited[j]==false&&(k==-1||shortest[j]<shortest[k]))
                    k=j;
            }
            visited[k]=true;
            for(int m=0;m<adj.length;m++){
                if(shortest[k]+adj[k][m]<shortest[m]){
                    shortest[m]=shortest[k]+adj[k][m];
                }
            }
        }
//        System.out.println(Arrays.toString(shortest));
        if(shortest[adj.length-1]==Integer.MAX_VALUE/2)
            return -1;

        return shortest[adj.length-1];
    }
}
