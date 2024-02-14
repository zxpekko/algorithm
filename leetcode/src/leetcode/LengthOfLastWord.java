package leetcode;

/**
 * @Author:zxp
 * @Description:58
 *
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * 示例 3：
 *
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 * @Date:21:08 2023/9/18
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
    }
    public int lengthOfLastWord(String s){
        int i;
        for(i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' ')
                break;
        }
        int sum=0;
        for(int j=i;j>=0;j--){
            if(s.charAt(j)!=' ')
                sum++;
            else
                break;
        }
        return sum;
    }
}
