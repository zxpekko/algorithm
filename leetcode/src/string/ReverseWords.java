package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 *
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * @Date:14:09 2024/1/27
 */
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("  hello world  "));
    }
    public String reverseWords(String s){
        char[] string = s.toCharArray();
        for(int i=0,j= string.length-1;i<j;i++,j--){
            char temp=string[i];
            string[i]=string[j];
            string[j]=temp;
        }
        List<Character> record=new ArrayList<>();
        for(int i=0;i<string.length;i++){
            if(i==0&&string[i]==' ')
                continue;
            else if(i>0&&string[i]==' '&&string[i-1]==' ')
                continue;
            else if(i==string.length-1&&string[i]==' ')
                continue;
            else record.add(string[i]);
        }
        if(record.get(record.size()-1)==' ')
            record.remove(record.size()-1);
        char[] chars = new char[record.size()];
        for(int i=0;i<record.size();i++){
            chars[i]=record.get(i);
        }
        int startIndex=0,endIndex;
        for(int i=0;i< chars.length;i++){
            if(chars[i]!=' '&&i!=chars.length-1)
                continue;
            else if(chars[i]==' '){
                endIndex=i-1;
                reverseSub(chars,startIndex,endIndex);
                startIndex=i+1;
            }
            else if(i==chars.length-1){
                endIndex=i;
                reverseSub(chars,startIndex,endIndex);
            }
        }
        return new String(chars);
    }
    public void reverseSub(char[] chars,int startIndex,int endIndex){
        for(int i=startIndex,j=endIndex;i<j;i++,j--){
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
        }
    }
}
