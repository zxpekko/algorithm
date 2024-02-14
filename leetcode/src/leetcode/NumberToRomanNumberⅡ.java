package leetcode;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:14 2023/7/15
 */
public class NumberToRomanNumberⅡ {
    public static void main(String[] args) {
        NumberToRomanNumber numberToRomanNumber = new NumberToRomanNumber();
        String s = numberToRomanNumber.intToRoman(1994);
        System.out.println(s);
    }
    public String intToRoman(int num){
        int[] posNums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,1};
        String[] posStrings={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String str="";
        for(int i=0;i< posNums.length;i++){
            int nums=num/posNums[i];
            if(nums!=0){
                for(int j=0;j<nums;j++){
                    str+=posStrings[i];
                }
            }
            num=num%posNums[i];
        }
        return str;
    }
}
