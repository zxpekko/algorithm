package leetcode;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:42 2023/6/20
 */
public class KMP {
    public static void main(String[] args) {
        int[] abcaabbs = KMP.getNext("abcaabb");
        int i = KMP.FindStr("asdabcaabb", "abcaabb");
        System.out.println(Arrays.toString(abcaabbs));
        System.out.println(i);
    }
    public static int FindStr(String str,String substr){
        int i=0,j=0;//主串和子串的位置
        int[] next = KMP.getNext(substr);
        while (i<str.length()&&j<substr.length()){
            if(j==-1||str.charAt(i)==substr.charAt(j)){//当j为-1时，要移动的是i，j也需要归零
                i++;
                j++;
            }
            else
                j=next[j];

        }
        if(j==substr.length())
            return i-j;
        else
            return -1;
    }
    public static int[] getNext(String substr){
        int[] next = new int[substr.length()];
//        next[1]=1;

//        for(int i=1,j=0;i<substr.length();i++){
//            while (j>0&&substr.charAt(i)!=substr.charAt(j))
//                j=next[j-1];
//            if(substr.charAt(i)==substr.charAt(j))
//                j++;
//            next[i]=j;
//
//        }   i
        next[0]=-1;

        int j=0,k=-1;
        while (j<substr.length()-1){
            if(k==-1||substr.charAt(j)==substr.charAt(k))
                next[++j]=++k;
            else
                k=next[k];
        }
        return next;
    }
}
