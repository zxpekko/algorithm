package string;

/**
 * @Author:zxp
 * @Description:给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 *
 * 提示：
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 * @Date:17:12 2024/1/29
 */
public class StrStr {
    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        StrStrⅡ strStrⅡ = new StrStrⅡ();
        System.out.println(strStrⅡ.strStr("hello", "ll"));
        System.out.println(strStr.strStr("hello", "ll"));
    }
    public int strStr(String haystack, String needle){
        int[] next = getNext(needle);
        int index=0;
        int count=0;
        int subIndex=0;
        while (index<haystack.length()){
            for(int i=subIndex;i<needle.length();i++){
                if(index<haystack.length()&&haystack.charAt(index)==needle.charAt(i)){
                    index++;
                    count++;
                }
                else {
                    if(i==0){
                        subIndex=0;
                        index++;
                        count=0;
                    }
                    else {
                        subIndex=next[i-1];
                        count=next[i-1];
                    }
                    break;
                }
            }
            if(count==needle.length())
                return index-count;
        }
        return -1;
    }
    public int[] getNext(String needle){
        int[] next = new int[needle.length()];
        next[0]=0;
        int j=0;//指向前缀末尾
        for(int i=1;i<needle.length();i++){
            while (j>0&&needle.charAt(i)!=needle.charAt(j))
                j=next[j-1];
            if(needle.charAt(i)==needle.charAt(j))
                j++;
            next[i]=j;

        }
        return next;
    }
}
class StrStrⅡ{
    public int strStr(String haystack, String needle){
        int[] next = getNext(needle);
        for(int i=0,j=0;i<haystack.length();i++){
            while (j>0&&haystack.charAt(i)!=needle.charAt(j))
                j=next[j-1];
            if(haystack.charAt(i)==needle.charAt(j))
                j++;
            if(j==needle.length())
                return i-j+1;
        }
        return -1;
    }
    public int[] getNext(String needle){
        int[] next = new int[needle.length()];
        next[0]=0;
        int j=0;//指向前缀末尾
        for(int i=1;i<needle.length();i++){
            while (j>0&&needle.charAt(i)!=needle.charAt(j))
                j=next[j-1];
            if(needle.charAt(i)==needle.charAt(j))
                j++;
            next[i]=j;

        }
        return next;
    }

}
