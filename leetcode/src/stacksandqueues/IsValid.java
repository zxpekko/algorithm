package stacksandqueues;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * @Date:20:09 2024/1/30
 */
public class IsValid {
    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("(({)})"));
    }
    public boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        if(s.charAt(0)==')'||s.charAt(0)=='}'||s.charAt(0)==']')
            return false;
//        stack.push(s.charAt(0));
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else if(s.charAt(i)==')'){
                if(stack.isEmpty())
                    return false;
                else {
                    Character pop = stack.pop();
                    if(pop=='(')
                        continue;
                    else
                        return false;
                }
            }
            else if(s.charAt(i)=='}'){
                if(stack.isEmpty())
                    return false;
                else {
                    Character pop = stack.pop();
                    if(pop=='{')
                        continue;
                    else
                        return false;
                }
            }
            else{
                if(stack.isEmpty())
                    return false;
                else {
                    Character pop = stack.pop();
                    if(pop=='[')
                        continue;
                    else
                        return false;
                }
            }

        }
        if(stack.isEmpty())
            return true;
        else return false;
    }
}
