package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:01 2023/2/20
 */
public class Permutation {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        List<List<Integer>> list=permuteUnique(ints);
        System.out.println(list);

    }
    public static List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for(int num:nums){
            integers.add(num);
        }
        int n= nums.length;
        backtrack(n,lists,integers,0);
        return lists;
    }
    public static void backtrack(int n,List<List<Integer>> lists,ArrayList<Integer> integers,int first){
        if(n==first){
            lists.add(new ArrayList(integers));
        }
        else{
            for(int i=first;i<n;i++){
                Collections.swap(integers,i,first);
                backtrack(n,lists,integers,first+1);
                Collections.swap(integers,i,first);
            }
        }
    }
}
