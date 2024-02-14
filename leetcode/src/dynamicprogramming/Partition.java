package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:03 2023/10/23
 */
public class Partition {
    public static void main(String[] args) {
        Partition partition = new Partition();
        System.out.println(partition.partition("aab"));
    }
    List<List<String>> result=new ArrayList<>();
    List<String> subResult=new ArrayList<>();
    boolean[][] f;
    int n;

    public List<List<String>> partition(String s){
        n=s.length();
        f=new boolean[n][n];
        for(int i=0;i<f.length;i++){
            Arrays.fill(f[i],true);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                f[i][j]=(s.charAt(i)==s.charAt(j))&&f[i+1][j-1];
            }
        }
        dfs(s,0);
        return result;
    }
    public void dfs(String s,int i){
        if(i==n){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int j=i;j<n;j++){
            if(f[i][j]){
                subResult.add(s.substring(i,j+1));
                dfs(s,j+1);
                subResult.remove(subResult.size()-1);
            }

        }
    }
}