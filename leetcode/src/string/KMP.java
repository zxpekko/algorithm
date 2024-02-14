package string;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:实现KMP算法
 * @Date:17:13 2024/1/27
 */
public class KMP {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        KMPⅡ kmpⅱ = new KMPⅡ();
        System.out.println(kmpⅱ.KMP("aabaabaaf", "baabaaf"));
        System.out.println(kmp.KMP("aabaabaaf", "baabaaf"));
        KMPⅢ kmpⅲ = new KMPⅢ();
        System.out.println(kmpⅲ.KMP("aabaabaaf", "baabaaf"));
    }
    public int KMP(String s,String subString){
        if(s.length()<subString.length())
            return -1;
        int[] next = getNext(subString);
        int index=0;
        int subIndex=0;
        int count=0;
        while (index<s.length()){
            for(int i=subIndex;i<subString.length();i++){
                if(index<s.length()&&subString.charAt(i)==s.charAt(index)){
                    index++;
                    count++;
                }
                else {
                    if(i==0){
                        index++;
                        break;
                    }
                    else {
                        int newIndex = next[i - 1];
                        subIndex=newIndex;
                        count=newIndex;
                        break;
                    }
                }
                if(count==subString.length()){
                    return index-subString.length();
                }
            }
        }
        return -1;
    }
    public int[] getNext(String subString){
        int[] next = new int[subString.length()];
        for(int i=0;i<subString.length();i++){
            String substring = subString.substring(0, i + 1);
            int equalslength = getEqualslength(substring);
            next[i]=equalslength;
        }
        System.out.println(Arrays.toString(next));
        return next;
    }
    public int getEqualslength(String subString){
        int count=0;
//        for(int i=0,j=subString.length()-1;i<subString.length()-1&&j>0;i++,j--){
//            if(subString.charAt(i)==subString.charAt(j))
//                count++;
//            else break;
//        }
        for(int i=0;i<subString.length()-1;i++){
            String front = subString.substring(0, i + 1);
            String back=subString.substring(subString.length()-1-i,subString.length());
            int cur=0;
            int flag=0;
            for(int j=0;j<front.length();j++){
                if(front.charAt(j)==back.charAt(j))
                    cur++;
                else{
                    flag=1;
                    break;
                }
            }
            if(flag==0&&cur>count)
                count=cur;
        }
        return count;
    }
}
class KMPⅡ{
    public int KMP(String s,String subStr){
        int[] next = getNext(subStr);
        int index=0;
        int subIndex=0;
        int count=0;
        while (index<s.length()){
            for(int i=subIndex;i<subStr.length();i++){
                if(s.charAt(index)==subStr.charAt(i)){
                    index++;
                    count++;
                    continue;
                }
                else {
                    if(i==0){
                        subIndex=0;
                        index++;
                    }
                    else {
                        subIndex=next[i-1];
                    }
                    count=subIndex;
                }
            }
            if(count==subStr.length())
                return index-subStr.length();
        }
        return -1;
    }
    public int[] getNext(String subStr){
        int[] next = new int[subStr.length()];
        next[0]=0;
        int j=0;//j指前缀末尾
        for(int i=1;i<subStr.length();i++){//i指后缀末尾
            while (j>0&&subStr.charAt(i)!=subStr.charAt(j))
                j=next[j-1];
            if(subStr.charAt(i)==subStr.charAt(j))
                j++;
            next[i]=j;
        }
        return next;
    }

}
class KMPⅢ{
    public int KMP(String s,String subString){
        int m=s.length();
        int index=0;
        int[] next = getNext(subString);
        int subIndex=0;
        while (index<m){
            if(s.charAt(index)==subString.charAt(subIndex)){
                index++;
                subIndex++;
            }
            else {
                if(index==0||subIndex==0){
                    index++;
                }
                else {
                    subIndex=next[subIndex-1];
                }
            }
            if(subIndex==subString.length())
                return index-subIndex;
        }
        return -1;
    }
    public int[] getNext(String subString){
        int n=subString.length();
        int[] next = new int[n];
        int j=0;
        next[0]=0;
        for(int i=1;i<n;i++){
            while (j>0&&subString.charAt(i)!=subString.charAt(j))
                j=next[j-1];
            if(subString.charAt(i)==subString.charAt(j))
                j++;
            next[i]=j;
        }
        return next;
    }
    public int[] getNextⅡ(String subString){//求next数组。
        int m=subString.length();
        int[] next= new int[m];
        int j=0;
        next[0]=0;
        for(int i=1;i<m;i++){
            while (j>0&&subString.charAt(i)!=subString.charAt(j))
                j=next[j-1];
            if(subString.charAt(i)==subString.charAt(j))
                j++;
            next[i]=j;
        }
        return next;
    }
}
