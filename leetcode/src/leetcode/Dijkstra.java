package leetcode;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:38 2023/9/12
 */
public class Dijkstra {
    public static void main(String[] args) {
        int[][] adj = new int[4][4];
        for (int i = 0; i < adj.length; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE / 2);
        }

        adj[0][1] = 2;
        adj[0][2] = 1;
        adj[1][2] = 5;
        adj[1][3] = 2;
        Dijkstra dijkstra = new Dijkstra();
        int[] dijkstra1 = dijkstra.dijkstra(adj, 0);
        System.out.println(Arrays.toString(dijkstra1));
    }

    public int[] dijkstra(int[][] adj, int source) {
        boolean[] visited = new boolean[adj.length];
        int[] shortest = new int[adj.length];
        Arrays.fill(shortest, Integer.MAX_VALUE / 2);
        shortest[source] = 0;
        for (int i = 0; i < adj.length; i++) {
            int k = -1;//每次循环都需要确定一个节点的单源最短路径。
            for (int j = 0; j < adj.length; j++) {
                if (visited[j] == false && (k == -1 || shortest[j] < shortest[k]))
                    k = j;
            }
            visited[k] = true;
            for (int m = 0; m < adj.length; m++) {
                if (shortest[k] + adj[k][m] < shortest[m])
                    shortest[m] = shortest[k] + adj[k][m];
            }
        }
        return shortest;
    }
}
