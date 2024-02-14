package graphtheory;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:57 2024/2/12
 */
public class Relative {
    public static void main(String[] args) {
        Relative relative = new Relative();
        int[][] relatives = {{1, 3}, {4, 6}, {0, 2}, {7, 8}, {0, 1}, {4, 5}, {1, 2}};
        System.out.println(relative.isRelative(10, relatives, 6, 9));
    }
//    int[] fa;
    public boolean isRelative(int n,int[][] relatives,int node1,int node2){
        int[] fa=new int[n];
        union(n,relatives,fa);
        if(find(node1,fa)==find(node2,fa))
            return true;
        return false;
    }
    public void init(int n,int[] fa){
        for(int i=0;i<n;i++)
            fa[i]=i;
    }
    public int find(int i,int[] fa){
        if(fa[i]==i)
            return i;
        else {
            fa[i]=find(fa[i],fa);
            return fa[i];
        }
    }
    public void union(int n,int[][] relatives,int[] fa){
        init(n,fa);
        for(int i=0;i<relatives.length;i++){
            int node1 = relatives[i][0];
            int node2 = relatives[i][1];
            int node1_fa=find(node1,fa);
            int node2_fa=find(node2,fa);
            fa[node1_fa]=node2_fa;//修改i的祖先必须要去祖先数组修改，单纯的修改赋值，只是值传递，没有意义。
        }
    }
}