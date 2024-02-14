package leetcode.combinatorialmathematics;

import org.junit.Test;

/**
 * @Author:zxp
 * @Description:二维平面上有
 * �
 * N 条直线，形式为 y = kx + b，其中 k、b为整数 且 k > 0。所有直线以 [k,b] 的形式存于二维数组 lines 中，不存在重合的两条直线。两两直线之间可能存在一个交点，最多会有
 * �
 * �
 * 2
 * C
 * N
 * 2
 * ​
 *   个交点。我们用一个平行于坐标轴的矩形覆盖所有的交点，请问这个矩形最小面积是多少。若直线之间无交点、仅有一个交点或所有交点均在同一条平行坐标轴的直线上，则返回0。
 *
 * 注意：返回结果是浮点数，与标准答案 绝对误差或相对误差 在 10^-4 以内的结果都被视为正确结果
 *
 * 示例 1：
 *
 * 输入：lines = [[2,3],[3,0],[4,1]]
 *
 * 输出：48.00000
 *
 * 解释：三条直线的三个交点为 (3, 9) (1, 5) 和 (-1, -3)。最小覆盖矩形左下角为 (-1, -3) 右上角为 (3,9)，面积为 48
 *
 * 示例 2：
 *
 * 输入：lines = [[1,1],[2,3]]
 *
 * 输出：0.00000
 *
 * 解释：仅有一个交点 (-2，-1）
 *
 * 限制：
 *
 * 1 <= lines.length <= 10^5 且 lines[i].length == 2
 * 1 <= lines[0] <= 10000
 * -10000 <= lines[1] <= 10000
 * 与标准答案绝对误差或相对误差在 10^-4 以内的结果都被视为正确结果
 * @Date:19:38 2023/9/21
 */
public class MinRecSize {
    public static void main(String[] args) {
        int[][] lines={{2,0},{4,-3},{2,4},{1,-2},{1,-1}};
        MinRecSize minRecSize = new MinRecSize();
        System.out.println(minRecSize.minRecSize(lines));
    }
    public double minRecSize(int[][] lines){
        int i;
        for(i=0;i< lines.length-1;i++){
            if(lines[i][0]!=lines[i+1][0])
                break;
        }
        if(i==lines.length-1)
            return 0;
        double left=Integer.MAX_VALUE,down=Integer.MAX_VALUE;
        double right=Integer.MIN_VALUE,up=Integer.MIN_VALUE;
//        int count=0;
        for(i=0;i<lines.length;i++){
            for(int j=i+1;j< lines.length;j++){
//                count++;
                if(lines[i][0]==lines[j][0])
                    continue;
                double x=(double) (lines[i][1]-lines[j][1])/(lines[j][0]-lines[i][0]);
                double y=(double) lines[i][0]*(lines[j][1]-lines[i][1])/(lines[i][0]-lines[j][0])+lines[i][1];
//                System.out.println(x+" "+y);
                if(x<left)
                    left=x;
                if(x>right)
                    right=x;
                if(y<down)
                    down=y;
                if(y>up)
                    up=y;
            }
        }
//        System.out.println(count);
        if(left==right||up==down)
            return 0;
//        System.out.println("left"+left);
//        System.out.println("right"+right);
//        System.out.println("up"+up);
//        System.out.println("down"+down);
        double area=(right-left)*(up-down);
        return area;
    }
    @Test
    public void test(){
        int count=0;
//        for(int i=0;i<5;i++){
//            for(int j=0;j<5;j++){
//                count++;
//                if(j==3)
//                    break;
//            }
//        }
        int x=6;
        int y=4;
        double result=(double)x/y;
        System.out.println(result);
        System.out.println(x/y);
        System.out.println(count);
    }

}