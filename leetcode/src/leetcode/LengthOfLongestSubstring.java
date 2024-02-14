package leetcode;

import java.util.*;

/**
 * @Author:zxp
 * @Description:给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * @Date:9:19 2023/9/11
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstringⅡ("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s){//比较传统的记录是否出现重复字符的做法。Ⅱ中的方法采用滑动窗口，值得思考。
        Map<Character,Integer> remember=new HashMap<>();
        int maxSubstring=0;
        int currentSubstring=0;
//        int flag=0;
        for(int i=0;i<s.length();i++){
            if(!remember.containsKey(s.charAt(i))){
                remember.put(s.charAt(i),i);
                currentSubstring++;
            }
            else {
                int currentIndex=remember.get(s.charAt(i));
                int sum=0;
//                flag=1;
//                for (Map.Entry<Character, Integer> characterIntegerEntry : remember.entrySet()) {
//                    if(characterIntegerEntry.getValue()<=currentIndex){
//                        remember.remove(characterIntegerEntry.getKey());
//
//                        sum++;
//                    }
//                }
                Iterator<Map.Entry<Character, Integer>> iterator = remember.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<Character, Integer> next = iterator.next();
                    if(next.getValue()<=currentIndex){
//                        remember.remove(next.getKey());
                        iterator.remove();
                        sum++;
                    }
                }
//                remember.forEach((key,value)->{
//                    if(value<=currentIndex){
//                        remember.remove(key);
//
//                    }
//
//                });


//                remember.clear();
                remember.put(s.charAt(i),i);
                if(currentSubstring>maxSubstring)
                    maxSubstring=currentSubstring;
                currentSubstring=currentSubstring-sum+1;
            }
        }

//        if(flag==0)
//            return currentSubstring;
        return Math.max(maxSubstring,currentSubstring);
    }
    public int lengthOfLongestSubstringⅡ(String s){
//        Map<Character,Integer> record=new HashMap<>();
        Set<Character> record=new HashSet<>();
        int right=-1;
        int max=0;
        int result=0;
//        record.put(s.charAt(left),left);
        for(int i=0;i<s.length();i++){//i代表左指针，也就是初始位置
            if(i!=0){
                max--;
                record.remove(s.charAt(i-1));
            }
            while (right+1<s.length()&&!record.contains(s.charAt(right+1))){
                max++;
                record.add(s.charAt(right+1));
                right++;
            }
            result=Math.max(max,result);
        }


        return result;
    }

}
