package leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 *
 *
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 *
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * @Date:10:02 2023/9/9
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(3, 9));
    }
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        int flag=0;
//        if(n<10||n>34)
//            return result;
        dfs(k,n,1,flag,result,subResult);
        return result;
    }
    public void dfs(int k,int n,int current,int flag,List<List<Integer>> result,List<Integer> subResult){
        if(subResult.size()==k&&n!=0)
            return;
        if(n==0&&subResult.size()==k){
            flag=1;
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=current;i<=9;i++){
            subResult.add(i);
            dfs(k,n-i,i+1,flag,result,subResult);
            if(flag==1){
                flag=0;
                break;
            }
            subResult.remove(subResult.size()-1);
//            dfs(k,n,i+1,result,subResult);这里有一层for循环，不需要加这句，因为执行remove之后继续for循环就相当于删去的值没有选，
//                                          如果加上这行，看上去是在考虑不选当前值，其实是重复了，因为for循环会覆盖n-i,而当前递归层n值是不变的。
        }
    }
}
