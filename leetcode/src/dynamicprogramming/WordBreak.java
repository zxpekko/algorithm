package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * @Date:9:09 2023/12/6
 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> strings=new ArrayList<>();
        strings.add("cats");
        strings.add("dog");
        strings.add("sand");
        strings.add("and");
        strings.add("cat");

        System.out.println(wordBreak.wordBreak("catsandog", strings));
    }
    public boolean wordBreak(String s, List<String> wordDict){
        int n=s.length();
        boolean[] dp = new boolean[n + 1];//dp[j]表示填满j容量对应的价值。
        dp[0]=true;
        for(int j=0;j<=n;j++){
            for(int i=0;i<wordDict.size();i++){
                if(dp[j]==false&&j>=wordDict.get(i).length()){
                    dp[j]=dp[j-wordDict.get(i).length()]&&judgeBreak(wordDict.get(i),s,j-wordDict.get(i).length(),j-1);
                }

            }
        }
        return dp[n];
    }
    public boolean judgeBreak(String s1,String s2,int start,int end){
        for(int i=start,j=0;i<=end;i++,j++){
            if(s1.charAt(j)!=s2.charAt(i))
                return false;
        }
        return true;
    }
}
