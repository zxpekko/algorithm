package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
 *
 * 给定一个由整数坐标组成的数组 queens ，表示黑皇后的位置；以及一对坐标 king ，表示白国王的位置，返回所有可以攻击国王的皇后的坐标(任意顺序)。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * 输出：[[0,1],[1,0],[3,3]]
 * 解释：
 * [0,1] 的皇后可以攻击到国王，因为他们在同一行上。
 * [1,0] 的皇后可以攻击到国王，因为他们在同一列上。
 * [3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。
 * [0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。
 * [4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。
 * [2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
 * 示例 2：
 *
 *
 *
 * 输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
 * 输出：[[2,2],[3,4],[4,4]]
 * 示例 3：
 *
 *
 *
 * 输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
 * 输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 * @Date:19:19 2023/9/14
 */
public class QueensAttacktheKing {
    public static void main(String[] args) {
        int[][] queens={{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] king={0,0};
        QueensAttacktheKing queensAttacktheKing = new QueensAttacktheKing();
        System.out.println(queensAttacktheKing.queensAttacktheKing(queens, king));
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king){
        List<List<Integer>> mediaResult=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();

        for(int[] queen:queens){
            if(canAttack(queen,king)){
                List<Integer> canAttack=new ArrayList<>();
                canAttack.add(queen[0]);
                canAttack.add(queen[1]);
                mediaResult.add(canAttack);
            }
        }
        Map<String,List<Integer>> record=new HashMap<>();
        for(List<Integer> SingleMediaResult:mediaResult){
            if(SingleMediaResult.get(0)-king[0]==0&&SingleMediaResult.get(1)-king[1]>0&&!record.containsKey("right")){
                record.put("right",SingleMediaResult);
            }
            if(SingleMediaResult.get(0)-king[0]==0&&SingleMediaResult.get(1)-king[1]>0&&record.containsKey("right")){
                if(record.get("right").get(1)>SingleMediaResult.get(1))
                    record.put("right",SingleMediaResult);
            }
            if(SingleMediaResult.get(0)-king[0]==0&&SingleMediaResult.get(1)-king[1]<0&&!record.containsKey("left")){
                record.put("left",SingleMediaResult);
            }
            if(SingleMediaResult.get(0)-king[0]==0&&SingleMediaResult.get(1)-king[1]<0&&record.containsKey("left")){
                if(SingleMediaResult.get(1)>record.get("left").get(1))
                    record.put("left",SingleMediaResult);
            }
            if(SingleMediaResult.get(1)==king[1]&&SingleMediaResult.get(0)-king[0]<0&&!record.containsKey("up")){
                record.put("up",SingleMediaResult);
            }
            if(SingleMediaResult.get(1)==king[1]&&SingleMediaResult.get(0)-king[0]<0&&record.containsKey("up")){
                if(SingleMediaResult.get(0)>record.get("up").get(0))
                    record.put("up",SingleMediaResult);
            }
            if(SingleMediaResult.get(1)==king[1]&&SingleMediaResult.get(0)-king[0]>0&&!record.containsKey("down")){
                record.put("down",SingleMediaResult);
            }
            if(SingleMediaResult.get(1)==king[1]&&SingleMediaResult.get(0)-king[0]>0&&record.containsKey("down")){
                if(SingleMediaResult.get(0)<record.get("down").get(0))
                    record.put("down",SingleMediaResult);
            }
            if(SingleMediaResult.get(0)-king[0]==SingleMediaResult.get(1)-king[1]&&SingleMediaResult.get(0)-king[0]>0&&!record.containsKey("rightdown")){
                record.put("rightdown",SingleMediaResult);
            }
            if(SingleMediaResult.get(0)-king[0]==SingleMediaResult.get(1)-king[1]&&SingleMediaResult.get(0)-king[0]>0&&record.containsKey("rightdown")){
                if(SingleMediaResult.get(0)<record.get("rightdown").get(0))
                    record.put("rightdown",SingleMediaResult);
            }
            if(SingleMediaResult.get(0)-king[0]==SingleMediaResult.get(1)-king[1]&&SingleMediaResult.get(0)-king[0]<0&&!record.containsKey("leftup")){
                record.put("leftup",SingleMediaResult);
            }
            if(SingleMediaResult.get(0)-king[0]==SingleMediaResult.get(1)-king[1]&&SingleMediaResult.get(0)-king[0]<0&&record.containsKey("leftup")){
                if(SingleMediaResult.get(0)>record.get("leftup").get(0))
                    record.put("leftup",SingleMediaResult);
            }
            if((SingleMediaResult.get(0)-king[0]+SingleMediaResult.get(1)-king[1]==0)&&SingleMediaResult.get(0)<king[0]&&!record.containsKey("rightup")){
                record.put("rightup",SingleMediaResult);
            }
            if((SingleMediaResult.get(0)-king[0]+SingleMediaResult.get(1)-king[1]==0)&&SingleMediaResult.get(0)<king[0]&&record.containsKey("rightup")){
                if(SingleMediaResult.get(0)>record.get("rightup").get(0))
                    record.put("rightup",SingleMediaResult);
            }
            if((SingleMediaResult.get(0)-king[0]+SingleMediaResult.get(1)-king[1]==0)&&SingleMediaResult.get(0)>king[0]&&!record.containsKey("leftdown")){
                record.put("leftdown",SingleMediaResult);
            }
            if((SingleMediaResult.get(0)-king[0]+SingleMediaResult.get(1)-king[1]==0)&&SingleMediaResult.get(0)>king[0]&&record.containsKey("leftdown")){
                if(SingleMediaResult.get(0)<record.get("leftdown").get(0))
                    record.put("leftdown",SingleMediaResult);
            }
        }
        for (Map.Entry<String, List<Integer>> stringListEntry : record.entrySet()) {
            List<Integer> value = stringListEntry.getValue();
            result.add(value);
        }

        return result;
    }
    public boolean canAttack(int[] queen,int[] king){
        if(queen[0]==king[0]||queen[1]==king[1]||Math.abs(queen[0]-king[0])==Math.abs(queen[1]-king[1]))
            return true;
        return false;
    }
}
