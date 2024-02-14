package leetcode;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:26 2023/11/14
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] ints = productExceptSelf.productExceptSelfⅡ(new int[]{-1,1,0,-3,3});
        System.out.println(Arrays.toString(ints));
    }
    public int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];
        for(int i=0;i< nums.length;i++){
            int product=1;
            for(int j=0;j< nums.length;j++){
                if(j!=i)
                    product*=nums[j];
            }
            result[i]=product;
        }
        return result;
    }
    public int[] productExceptSelfⅡ(int[] nums){
        int[] result = new int[nums.length];
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0]=1;
        for(int i=1;i< nums.length;i++){
            L[i]=nums[i-1]*L[i-1];
        }
        R[nums.length-1]=1;
        for(int i= nums.length-2;i>=0;i--){
            R[i]=nums[i+1]*R[i+1];
        }
        for(int i=0;i< nums.length;i++){
            result[i]=L[i]*R[i];
        }
        return result;
    }
}
