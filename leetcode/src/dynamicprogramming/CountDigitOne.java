package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:233
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：6
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 109
 * @Date:19:10 2023/9/15
 */
public class CountDigitOne {
    public static void main(String[] args) {
        CountDigitOne countDigitOne = new CountDigitOne();
        System.out.println(countDigitOne.countDigitOne(824883294));
    }
    public int countDigitOne(int n){
        int OneNum=0;
        for(int i=0;i<=n;i++){
            int SingleOneNum = countAllOne(i);
            OneNum+=SingleOneNum;
        }
        return OneNum;
    }
    public int countAllOne(int n){
        int current=n;
        int oneNum=0;
        while (current>0){
            int i = current % 10;
            if(i==1){
//                System.out.println(i);
                oneNum++;
            }

            current/=10;
        }
        return oneNum;
    }
}
