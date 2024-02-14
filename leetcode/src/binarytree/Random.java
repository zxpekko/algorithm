package binarytree;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:17:26 2023/12/29
 */
public class Random {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.longestPalindrome("aca"));
    }
    public String longestPalindrome(String s){
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<dp.length;i++){
            dp[i][i]=true;
        }
        if(s.length()==1)
            return s;
        int n=s.length();
        int maxLength=Integer.MIN_VALUE;
        String result=s.substring(0,1);
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1){
                        dp[i][j]=true;
                        if(j-i+1>maxLength){
                            maxLength=j-i+1;
                            result=s.substring(i,j+1);
                        }
                    }
                    else{
                        dp[i][j]=dp[i+1][j-1];
                        if(dp[i][j]==true&&(j-i+1>maxLength)){
                            maxLength=j-i+1;
                            result=s.substring(i,j+1);
                        }
                    }
                }
            }
        }

        for(int i=0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
//        for(int i=0;i<dp.length;i++){
//            for(int j=0;j<dp.length;j++){
//                if(dp[i][j]==true&&(j-i+1)>maxLength){
//                    maxLength=j-i+1;
//                    result=s.substring(i,j+1);
//                }
//            }
//        }
        return result;
    }
}
