package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同
 * @Date:14:03 2023/6/5
 */
public class Climb {
    public static void main(String[] args) {
        Climb climb = new Climb();
        int i = climb.ClimbStairs(45);
        System.out.println(i);
    }
    public int ClimbStairs(int n){
        int solutionName=DynamicProgramming(n);
        return solutionName;
    }
    public int Fib(int n){
        if(n==0||n==1)
            return 1;
        else
            return Fib(n-1)+Fib(n-2);
    }
    public int DynamicProgramming(int n){
        int[] ints = new int[n + 1];
        ints[0]=1;ints[1]=1;
        for(int i=2;i<n+1;i++){
            ints[i]=ints[i-1]+ints[i-2];
        }
        return ints[n];
    }
}
