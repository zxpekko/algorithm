package dynamicprogramming;

import org.junit.Test;

/**
 * @Author:zxp
 * @Description:给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * @Date:12:32 2023/3/12
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        boolean isMatch= regularExpressionMatching.isMatch("abc","abc");
        System.out.println(isMatch);
    }

//    public boolean isMatch(String s,String p){
//        int length=s.length()>p.length()?s.length():p.length();
//        int i=0;
//        while(i<length){
//            if(s.charAt(i)==p.charAt(i))
//                i++;
//            else {
//                if(p.charAt(i)=='.')
//                    i++;
//                else if(p.charAt(i)=='*'){
//                    for(int j=0;)
//
//                }
//            }
//
//        }
//
//    }
    public boolean isMatch(String s,String p){
        int lengths=s.length();
        int lengthp=p.length();
        boolean[][] booleans = new boolean[lengths+1][lengthp+1];
        int i,j;
        booleans[0][0]=true;
        for(i=0;i< booleans.length;i++){
            for(j=1;j<booleans[0].length;j++){
//                if(i==0 && j==0){
//                    if(matches(s.charAt(i),p.charAt(j))){
//                        booleans[i][j]=true;
//                    }
//                    else
//                        booleans[i][j]=false;
//                }
                if(p.charAt(j-1)!='*'){
                    if(i==0){
                        booleans[i][j]=false;
                    }
//                    else if(i>0&&matches(s.charAt(i-1),p.charAt(j-1))){
//                        booleans[i][j]=booleans[i-1][j-1];
//                    }
//                    if(matches(s.charAt(i-1),p.charAt(j-1))){
//                        booleans[i][j]=booleans[i-1][j-1];
//                    }
//                    else
//                        booleans[i][j]=false;
                    if(i>0){
                        if(matches(s.charAt(i-1),p.charAt(j-1))){
                            booleans[i][j]=booleans[i-1][j-1];
                        }
                        else
                            booleans[i][j]=false;
                    }
                }
                else{
                    if(matches(s.charAt(i-1),p.charAt(j-2))){
                        booleans[i][j]=(booleans[i-1][j]||booleans[i][j-2]);
                    }
                    else
                        booleans[i][j]=booleans[i][j-2];
                }
            }
        }
        return booleans[lengths][lengthp];

    }
    public boolean matches(char x,char y){
        if(x==y||x=='.'||y=='.')
            return true;
        else
            return false;
    }
    @Test
    public void test(){
        char c1='a';
        char c2='a';
        if(c1==c2){
            System.out.println("yes");
        }
        boolean a;
        a=(true||false);
        if(a)
            System.out.println("yes");
    }


}
