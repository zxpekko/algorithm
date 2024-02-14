package greedyalgorithm;

/**
 * @Author:zxp
 * @Description:给定 N
 *  个闭区间 [ai,bi]
 * ，请你在数轴上选择尽量少的点，使得每个区间内至少包含一个选出的点。
 *
 * 输出选择的点的最小数量。
 *
 * 位于区间端点上的点也算作区间内。
 *
 * 输入格式
 * 第一行包含整数 N
 * ，表示区间数。
 *
 * 接下来 N
 *  行，每行包含两个整数 ai,bi
 * ，表示一个区间的两个端点。
 *
 * 输出格式
 * 输出一个整数，表示所需的点的最小数量。
 *
 * 数据范围
 * 1≤N≤105
 * ,
 * −109≤ai≤bi≤109
 * 输入样例：
 * 3
 * -1 1
 * 2 4
 * 3 5
 * 输出样例：
 * 2
 * @Date:20:26 2023/8/12
 */
public class RangeSelectNodes {
    public static void main(String[] args) {
        int[][] ranges={{-1,1},{2,4},{3,5},{0,1},{0,5},{6,7}};
        RangeSelectNodes rangeSelectNodes = new RangeSelectNodes();
        int greedy = rangeSelectNodes.Greedy(ranges);
        System.out.println(greedy);
    }
    public int Greedy(int[][] ranges){
        for(int i=0;i< ranges.length-1;i++){
            for(int j=0;j< ranges.length-1-i;j++){
                if(ranges[j][1]>ranges[j+1][1]){
                    int[] temp=new int[2];
                    temp=ranges[j];
                    ranges[j]=ranges[j+1];
                    ranges[j+1]=temp;
                }
            }
        }
        int result=0;
        double end=-1e10;
        for(int i=0;i< ranges.length;i++){
            if(end<ranges[i][0]){
                result++;
                end=ranges[i][1];
            }
        }
        return result;
    }
}
