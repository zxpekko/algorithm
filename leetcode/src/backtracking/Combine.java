package backtracking;

import leetcode.Connect;
import leetcode.InsertInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * @Date:13:35 2024/1/3
 */
public class Combine {
    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        backtracking(n, k, 1, result, subResult);
        return result;
    }

    public void backtracking(int n, int k, int startIndex, List<List<Integer>> result, List<Integer> subResult) {
        if (subResult.size() == k) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        if (n + subResult.size() - startIndex + 1 < k)//剪枝操作：还需的位置个数；k-subResult.size(),剩余位置的个数：n-startIndex+1,
            // 加1是因为startIndex位置的元素还没有开始选取，注意看剪枝的位置，在选取节点的上面，所以这个位置的元素没有选取，因此加1.
            return;
        for (int i = startIndex; i <= n; i++) {
            subResult.add(i);
            backtracking(n, k, i + 1, result, subResult);
            subResult.remove(subResult.size() - 1);
        }
    }

}
