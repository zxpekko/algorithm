package graphtheory;

import leetcode.Connect;

import java.util.*;

/**
 * @Author:zxp
 * @Description:有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 *
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 *
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：rooms = [[1],[2],[3],[]]
 * 输出：true
 * 解释：
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 *
 * 输入：rooms = [[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * @Date:12:46 2024/2/9
 */
public class CanVisitAllRooms {
    public static void main(String[] args) {
        CanVisitAllRooms canVisitAllRooms = new CanVisitAllRooms();
        List<List<Integer>> rooms=new ArrayList<>();
        rooms.add(Arrays.asList(1,3));
        rooms.add(Arrays.asList(3,0,1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));
        System.out.println(canVisitAllRooms.canVisitAllRooms(rooms));
        CanVisitAllRoomsⅡ canVisitAllRoomsⅡ = new CanVisitAllRoomsⅡ();
        System.out.println(canVisitAllRoomsⅡ.canVisitAllRooms(rooms));
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        int size = rooms.size();
        boolean[] visited = new boolean[size];
        bfs(rooms,visited);
        for(int i=0;i<visited.length;i++){
            if(!visited[i])
                return false;
        }
        return true;
    }
    public void bfs(List<List<Integer>> rooms,boolean[] visited){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            visited[poll]=true;
            List<Integer> list = rooms.get(poll);
            for(int i=0;i<list.size();i++){
                if(!visited[list.get(i)])
                    queue.offer(list.get(i));
            }
        }
    }
}
class CanVisitAllRoomsⅡ{
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        int size = rooms.size();
        boolean[] visited = new boolean[size];
        visited[0]=true;
        dfs(rooms,visited,0);
        for(int i=0;i<visited.length;i++){
            if(!visited[i])
                return false;
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms,boolean[] visited,int startIndex){
        List<Integer> list = rooms.get(startIndex);
        for(int i=0;i<list.size();i++){
            Integer integer = list.get(i);
            if(!visited[integer]){
                visited[integer]=true;
                dfs(rooms,visited,integer);
            }
        }
    }
}