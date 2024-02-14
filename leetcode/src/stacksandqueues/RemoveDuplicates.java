package stacksandqueues;

import netscape.security.UserTarget;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * @Date:10:47 2024/1/31
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates("azxxzy"));
        RemoveDuplicatesⅡ removeDuplicatesⅡ = new RemoveDuplicatesⅡ();
        System.out.println(removeDuplicatesⅡ.removeDuplicates("azxxzy"));
    }
    public String removeDuplicates(String s){//该算法针对的是两个以上的相同字符的删除，与力扣上的两个两个的删除不一样，请看第二个class。
        //这种删除方法其实比力扣原题更为困难一点，因为力扣中只需要弹出一个元素就行，而这种方式需要一直判断，直到不相等为止。
        Stack<Character> stack=new Stack<>();
        int i=0;
        while (i<s.length()){
            if(!stack.isEmpty()){
                int flag=0;
                    Character peek = stack.peek();
                    int j=i;
                    for(j=i;j<s.length();j++){
                        if(peek==s.charAt(j)){
                            flag=1;
                        }
                        else{
                            if(flag==0)
                                stack.push(s.charAt(j));
                            break;
                        }
                }
                    if(flag==1){
                        i=j;
                        stack.pop();
                    }
                    else
                        i=j+1;
            }
            else{
                stack.push(s.charAt(i));
                i++;
            }
        }
        int length=stack.size();
        if(length>0){
            char[] chars = new char[length];
            int index=0;
            while (!stack.isEmpty()){
                chars[index++]=stack.pop();
            }
            for(int j=0,k=chars.length-1;j<k;j++,k--){
                char temp=chars[j];
                chars[j]=chars[k];
                chars[k]=temp;
            }
            return new String(chars);
        }
        return "";
    }
}
class RemoveDuplicatesⅡ{
    public String removeDuplicates(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty()){
                Character peek = stack.peek();
                if(peek==s.charAt(i)){
                    stack.pop();
                }
                else
                    stack.push(s.charAt(i));
            }
            else stack.push(s.charAt(i));
        }
        int length = stack.size();
        if(length>0){
            char[] chars = new char[length];
            for(int i=0;i<chars.length;i++){
                chars[i]=stack.pop();
            }
            for(int i=0,j=chars.length-1;i<j;i++,j--){
                char temp=chars[i];
                chars[i]=chars[j];
                chars[j]=temp;
            }
            return new String(chars);
        }
        return "";
    }
}
