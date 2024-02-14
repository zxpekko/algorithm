package graphtheory;

import sun.security.provider.SHA;

import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 *
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 *
 *
 * 示例 1：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *
 *
 * 提示：
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 * @Date:11:43 2024/2/8
 */
public class LadderLength {
    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
//        List<String> strings = Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
//        System.out.println(ladderLength.ladderLength("qa","sq", strings));
        List<String> strings = Arrays.asList("hot","dog");
        LadderLengthⅡ ladderLengthⅡ = new LadderLengthⅡ();
        System.out.println(ladderLengthⅡ.ladderLength("hot", "dog", strings));
    }
    int sum=0;
    int min=Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList){//此算法采用构造图并且采用深度优先遍历的方法求解，
        // 思路正确，但是时间复杂度太高，判断是否差1复杂度O(m)(m为字符串长度)，所以构造图复杂度O(m*n^2),dfs的时间复杂度为O(2^n),所以综合时间复杂度为O(2^n).
        int[][] adj = getAdjacentMatrix(beginWord, wordList);
        int endIndex=-1;
        for(int i=0;i< wordList.size();i++){
            if(endWord.equals(wordList.get(i)))
                endIndex=i;
        }
        if(endIndex==-1)
            return 0;
        boolean[] visited = new boolean[1 + wordList.size()];
        sum+=1;
        visited[0]=true;
        dfs(adj,endIndex+1,0,visited);
        return min==Integer.MAX_VALUE?0:min;
    }
    public int[][] getAdjacentMatrix(String beginWord,List<String> wordList){
        int[][] adj = new int[1 + wordList.size()][1 + wordList.size()];

        for(int i=0;i< wordList.size();i++){
            if(isDiffOne(beginWord,wordList.get(i))){
                adj[0][i+1]=1;
                adj[i+1][0]=1;
            }
        }
        for(int i=0;i<wordList.size();i++){
            for(int j=i+1;j<wordList.size();j++){
                if(isDiffOne(wordList.get(i),wordList.get(j))){
                    adj[i+1][j+1]=1;
                    adj[j+1][i+1]=1;
                }
            }
        }
        return adj;
    }
    public boolean isDiffOne(String firstWord,String secondWord){
        int m=firstWord.length();
        int count=0;
        for(int i=0;i<m;i++){
            if(firstWord.charAt(i)!=secondWord.charAt(i))
                count++;
        }
        return count == 1;
    }
    public void dfs(int[][] adj,int targetIndex,int curIndex,boolean[] visited){
        if(curIndex==targetIndex){
            if(sum<min)
                min=sum;
            return;
        }
        for(int i=0;i<adj[curIndex].length;i++){
            if(adj[curIndex][i]==1&&!visited[i]){
                sum+=1;
                visited[i]=true;
                dfs(adj,targetIndex,i,visited);
                sum-=1;
                visited[i]=false;
            }
        }
    }
}
class LadderLengthⅡ{
    public int ladderLength(String beginWord, String endWord, List<String> wordList){//此算法是上面的改良版本，其中构造图的方式不变，时间复杂度为O(m*n^2),
        //而求解最终结果的方法我们借鉴迪杰斯特拉算法，单源最短路径，它的时间复杂度为O(n^2)，因此该算法的综合时间复杂度为O(m*n^2).
        //空间复杂度：O(n^2)，构造图的过程中，开辟了一个（n+1）^2复杂度大小的空间作为邻接矩阵，然后和一个长度为n+1的一维数组作为visited，因此空间复杂度为O(n^2).
        int[][] adj = getAdjacentMatrix(beginWord, wordList);
        int endIndex=-1;
        for(int i=0;i<wordList.size();i++){
            if(endWord.equals(wordList.get(i))){
                endIndex=i;
                break;
            }
        }
        if(endIndex==-1)
            return 0;
        int dijkstra = dijkstra(adj, 0, endIndex + 1);
        return (dijkstra==0||dijkstra==Integer.MAX_VALUE/2)?0:dijkstra+1;
    }
    public int[][] getAdjacentMatrix(String beginWord,List<String> wordList){
        int[][] adj = new int[1 + wordList.size()][1 + wordList.size()];
        for(int i=0;i<adj.length;i++){
            Arrays.fill(adj[i],Integer.MAX_VALUE/2);
        }
        for(int i=0;i< wordList.size();i++){
            if(isDiffOne(beginWord,wordList.get(i))){
                adj[0][i+1]=1;
                adj[i+1][0]=1;
            }
        }
        for(int i=0;i<wordList.size();i++){
            for(int j=i+1;j<wordList.size();j++){
                if(isDiffOne(wordList.get(i),wordList.get(j))){
                    adj[i+1][j+1]=1;
                    adj[j+1][i+1]=1;
                }
            }
        }
        return adj;
    }
    public boolean isDiffOne(String firstWord,String secondWord){
        int m=firstWord.length();
        int count=0;
        for(int i=0;i<m;i++){
            if(firstWord.charAt(i)!=secondWord.charAt(i))
                count++;
        }
        return count == 1;
    }
    public int dijkstra(int[][] adj,int source,int target){
        int n=adj.length;
        int[] shortest = new int[n];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            int k=-1;
            for(int j=0;j<n;j++){
                if(!visited[j]&&(k==-1||shortest[j]<shortest[k]))
                    k=j;
            }
            visited[k]=true;
            if(k==target)
                return shortest[k];
            for(int m=0;m<n;m++){
                if(shortest[k]+adj[k][m]<shortest[m])
                    shortest[m]=shortest[k]+adj[k][m];
            }
        }
        return 0;
    }
}