package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:45 2023/2/20
 */
public class PermutationⅡ {
    public static void main(String[] args) {
        int[] ints = {1,-1,1,2,-1,2,2,8,9};
        long start=System.currentTimeMillis();
        List<List<Integer>> list=permuteUnique(ints);
        long end=System.currentTimeMillis();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(end - start);
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
        int flag =0;
        if(n==first){
            label:for(List list:lists){
                flag=0;
                Iterator iterator = list.iterator();
                Iterator<Integer> iterator1 = integers.iterator();
                int count=0;
                while (iterator.hasNext()&&iterator1.hasNext()){
                    Integer next = (Integer)iterator.next();
                    Integer next1 = iterator1.next();
                    if(next==next1){
                        count++;
                    }
                    if(count== list.size()){
                        flag=1;
                        break label;
                    }
                }
            }
            if(flag==0){
                lists.add(new ArrayList(integers));
                return;
            }
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
