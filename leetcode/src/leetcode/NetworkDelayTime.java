package leetcode;

import java.util.*;

/**
 * @Author:zxp
 * @Description:有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * @Date:13:46 2023/9/11
 */
public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times={{1,2,1}};
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        System.out.println(networkDelayTime.networkDelayTime(times, 2, 2));
//        System.out.println(networkDelayTime.networkDelayTime(times, 3, 1));
    }

//    int currentTime=0;
//    int lastTime=0;
//    public int networkDelayTime(int[][] times, int n, int k){
//        if(!JudgekStart(times,k))
//            return -1;
////        List<Integer> record=new ArrayList<>();
////        Queue<Integer> queue=new LinkedList<>();
////        queue.offer(k);
////        while (!queue.isEmpty()){
////
////        }
//        boolean[] visited=new boolean[n];
//        dfs(times,n,k,visited);
//        for(int i=0;i<visited.length;i++){
//            if(visited[i]==false)
//                return -1;
//        }
//        return lastTime;
//    }
//    public boolean JudgekStart(int[][] times,int k){
//        for(int i=0;i<times.length;i++){
//            if(times[i][0]==k)
//                return true;
//        }
//        return false;
//    }
//    public void dfs(int[][] times,int n,int k,boolean[] visited){
////        visited=new boolean[n];
//        visited[k-1]=true;
//        for (Integer neighbor : getNeighbors(times, k)) {
//            if(!visited[neighbor-1]){
//                int time = getTime(times, k, neighbor);
////                System.out.println("time"+time);
//                currentTime+=time;
//                dfs(times,n,neighbor,visited);
//            }
////                System.out.println("currentTime"+currentTime);
//                lastTime=Math.max(lastTime,currentTime);
//                currentTime=0;
//        }
//    }
//    public List<Integer> getNeighbors(int[][] times,int v){
//        List<Integer> neighbor=new ArrayList<>();
//        for(int i=0;i<times.length;i++){
//            if(times[i][0]==v)
//                neighbor.add(times[i][1]);
//        }
//        return neighbor;
//    }
//    public int getTime(int[][] times,int v,int neighbor){
//        for(int i=0;i<times.length;i++){
//            if(times[i][0]==v&&times[i][1]==neighbor)
//                return times[i][2];
//        }
//        return 0;
//    }
   public int networkDelayTime(int[][] times, int n, int k){
       int[][] weights = new int[n][n];
       for(int i=0;i<n;i++){
           Arrays.fill(weights[i],Integer.MAX_VALUE/2);
       }
       for(int i=0;i<times.length;i++){
           weights[times[i][0]-1][times[i][1]-1]=times[i][2];
       }
//       int[] shortestLength = Dijkstra(weights, k);
       int lastTime = Dijkstra(weights, k);
       return lastTime;
   }
   public int Dijkstra(int[][] weights,int v){
        int n= weights.length;;
       int[] shortestLength = new int[n];
       boolean[] visited=new boolean[n];

       for(int i=0;i<n;i++)
           shortestLength[i]=Integer.MAX_VALUE/2;
       shortestLength[v-1]=0;
//       visited[v-1]=true;
       for(int i=0;i<n;i++){
           int k=-1;
           for(int j=0;j<n;j++){
               if(visited[j]==false&&(k==-1||shortestLength[j]<shortestLength[k]))
                   k=j;
           }
           visited[k]=true;
           for(int m=0;m<n;m++){
               if(shortestLength[k]+weights[k][m]<shortestLength[m])
                   shortestLength[m]=shortestLength[k]+weights[k][m];
           }
       }
       for(int i=0;i<shortestLength.length;i++){
//           if(visited[i]==false){
//               System.out.println();
////               return -1;
//
//           }
//           System.out.println(visited[i]);
           if(shortestLength[i]==Integer.MAX_VALUE/2)
               return -1;

       }
       int lastTime=shortestLength[0];
       for(int i=0;i<shortestLength.length;i++){
           if(shortestLength[i]>lastTime)
               lastTime=shortestLength[i];
       }

       return lastTime;
   }


}
