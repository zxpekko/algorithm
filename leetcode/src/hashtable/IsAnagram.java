package hashtable;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @Author:zxp
 * @Description:给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 * @Date:18:06 2024/1/18
 */
public class IsAnagram {
    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        IsAnagramⅡ isAnagramⅡ = new IsAnagramⅡ();
        System.out.println(isAnagramⅡ.isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram.isAnagram("anagram", "nagaram"));

    }
    public boolean isAnagram(String s, String t){
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Integer> sHash=new HashMap<>();
        HashMap<Character,Integer> tHash=new HashMap<>();
        sHash=getHashMap(s,sHash);
        tHash=getHashMap(t,tHash);
        for (Map.Entry<Character, Integer> characterIntegerEntry : sHash.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            Integer value = characterIntegerEntry.getValue();
            if(!tHash.containsKey(key)||(tHash.containsKey(key)&&(int)tHash.get(key)!=(int)value))
                return false;
        }

        return true;
    }
    public HashMap<Character,Integer> getHashMap(String str,HashMap<Character,Integer> hashMap){
        for(int i=0;i<str.length();i++){
            if(!hashMap.containsKey(str.charAt(i))){
                hashMap.put(str.charAt(i),1);
            }
            else {
                Integer integer = hashMap.get(str.charAt(i));
                hashMap.put(str.charAt(i),integer+1);
            }
        }
        return hashMap;
    }
    @Test
    public void test(){
        char c='a';
        System.out.println((int)c);
    }
}
class IsAnagramⅡ{
    public boolean isAnagram(String s, String t){
        int[] sRecord = new int[26];
        int[] tRecord = new int[26];
        sRecord=getRecord(s,sRecord);
        tRecord=getRecord(t,tRecord);
        for(int i=0;i<sRecord.length;i++){
            if(sRecord[i]!=tRecord[i])
                return false;
        }
        return true;
    }
    public int[] getRecord(String str,int[] record){
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            record[(int)c-97]++;
        }
        return record;
    }

}

