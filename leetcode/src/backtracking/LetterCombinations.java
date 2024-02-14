package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * @Date:19:47 2024/1/3
 */
public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("2"));
    }
    char[] two=new char[]{'a','b','c'};
    char[] three=new char[]{'d','e','f'};
    char[] four=new char[]{'g','h','i'};
    char[] five=new char[]{'j','k','l'};
    char[] six=new char[]{'m','n','o'};
    char[] seven=new char[]{'p','q','r','s'};
    char[] eight=new char[]{'t','u','v'};
    char[] nine=new char[]{'w','x','y','z'};
    List<char[]> list=new ArrayList<>();

    public List<String> letterCombinations(String digits){
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(nine);

        List<String> result=new ArrayList<>();
        List<Character> subResult=new ArrayList<>();
        if(digits.length()==0)
            return result;
        backtracking(digits,0,result,subResult);
        return result;
    }
    public void backtracking(String digits,int startIndex,List<String> result,List<Character> subResult){
        if(subResult.size()==digits.length()){
//            String subString=null;
            char[] chars = new char[subResult.size()];
            for(int i=0;i<subResult.size();i++)
                chars[i]= subResult.get(i);
            String s = new String(chars);
            result.add(s);
        }
        if(startIndex>=digits.length())
            return;
//        for(int i=startIndex;i<digits.length();i++){
//            int cur = digits.charAt(i);
//            int index=cur-2;
//            char[] chars = list.get(index);
//            for(int j=0;j< chars.length;j++){
//                subResult.add(chars[j]);
//                backtracking(digits,i+1,result,subResult);
//                subResult.remove(subResult.size()-1);
//            }
//        }
        char ch=digits.charAt(startIndex);
        String s = new String(new char[]{ch});
        int i = Integer.parseInt(s);

        System.out.println(i);
        int index=i-2;
        char[] chars = list.get(index);
        for(int j=0;j< chars.length;j++){
            subResult.add(chars[j]);
            backtracking(digits,startIndex+1,result,subResult);
            subResult.remove(subResult.size()-1);
        }

    }
    @Test
    public void test(){
        String a="123";
        char c = a.charAt(0);
//        System.out.println(Integer.parseInt(a, 0, 1, 1));
        String s = new String(new char[]{c});
        int i = Integer.parseInt(s);
        System.out.println(Integer.parseInt(s));
//        System.out.println(a.charAt(0));
    }
}
