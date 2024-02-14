package dynamicprogramming;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:给定两个整数 a
 *  和 b
 * ，求 a
 *  和 b
 *  之间的所有数字中 0∼9
 *  的出现次数。
 *
 * 例如，a=1024，b=1032
 * ，则 a
 *  和 b
 *  之间共有 9
 *  个数如下：
 *
 * 1024 1025 1026 1027 1028 1029 1030 1031 1032
 *
 * 其中 0 出现 10
 *  次，1 出现 10
 *  次，2 出现 7
 *  次，3 出现 3
 *  次等等…
 *
 * 输入格式
 * 输入包含多组测试数据。
 *
 * 每组测试数据占一行，包含两个整数 a
 *  和 b
 * 。
 *
 * 当读入一行为 0 0 时，表示输入终止，且该行不作处理。
 *
 * 输出格式
 * 每组数据输出一个结果，每个结果占一行。
 *
 * 每个结果包含十个用空格隔开的数字，第一个数字表示 0 出现的次数，第二个数字表示 1 出现的次数，以此类推。
 *
 * 数据范围
 * 0<a,b<100000000
 * @Date:15:14 2023/7/21
 */
public class CountNumbers {
    public static void main(String[] args) {
        CountNumbers countNumbers = new CountNumbers();
        List<List<Integer>> list=new ArrayList<>();
//        List<Integer> integerList=new ArrayList<>();
//        integerList.add(1000);
//        integerList.add(1);
//
//        for (int i : countNumbers.CountNumbers(integerList.get(0), integerList.get(1))) {
//            System.out.print(i+" ");
//        }

//        System.out.println("请输入：");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = null;
//        try {
//            str = br.readLine();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(str.charAt(0));
//        System.out.println(str.charAt(1));
//        System.out.println(str.charAt(2));
        String str=null;
        while (1==1){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                str= br.readLine();
                if("0 0".equals(str)){
                    break;
                }
                List<Integer> integerList=new ArrayList<>();
//                char c1=str.charAt(0);
//                char c2=str.charAt(2);
                int index=str.indexOf(' ');

                String s1 =str.substring(0,index);
                String s2 =str.substring(index+1) ;
                int i1 = Integer.parseInt(s1);
                int i2 = Integer.parseInt(s2);
                integerList.add(i1);
                integerList.add(i2);
                list.add(integerList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(list);
        for(int i=0;i< list.size();i++){
            int[] res = countNumbers.CountNumbers(list.get(i).get(0), list.get(i).get(1));
            System.out.println(Arrays.toString(res));
        }

    }
    public int[] CountNumbers(int left,int right){//普通方法
        int[] result = new int[10];
        if(left>right){
            int temp=left;
            left=right;
            right=temp;
        }
        for(int i=left;i<=right;i++){
            int[] SingleResult = CountOneNumber(i);
            result= ArraySum(result, SingleResult);
        }
        return result;
    }
    private int[] CountOneNumber(int num){
        int[] SingleResult = new int[10];
        int CopyNum=num;
        while (CopyNum>0){
            int mod=CopyNum%10;
            SingleResult[mod]+=1;
            CopyNum/=10;
        }
        return SingleResult;
    }
    private int[] ArraySum(int[] result,int[] SingleResult){
        for(int i=0;i< result.length;i++){
            result[i]+=SingleResult[i];
        }
        return result;
    }
    public int[] DynamicProgramming(int left,int right){//动态规划

        return null;
    }
    @Test
    public void test() throws IOException {

        System.out.println("请输入：");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(str);

    }
}
