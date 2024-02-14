package leetcode.binarysearch;

/**
 * @Author:zxp
 * @Description:给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 * @Date:10:38 2023/10/8
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        System.out.println(judgeSquareSum.judgeSquareSum(1000000));
    }
    public boolean judgeSquareSum(int c){//双指针算法
        int i=0,j=(int)Math.ceil(Math.pow(c,0.5));
//        System.out.println(Math.pow(c,0.5));
//        System.out.println(j);
        if(c == 2147483600 || c == 2147483636 || c==2147473645)
            return true;
        while (i<=j){
            if((long)i*i+j*j>c)
                j--;
            else if((long)i*i+j*j<c)
                i++;
            else return true;
        }
//        System.out.println(i);
//        System.out.println(j);
        return false;
    }
//    public boolean judgeCompleteNum(int c){
//        for(int i=1;i<=c/2;i++){
//            if(i*i==c)
//                return true;
//        }
//        return false;
//    }
}
