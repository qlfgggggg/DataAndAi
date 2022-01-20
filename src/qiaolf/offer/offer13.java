package qiaolf.offer;

/**
 * @Description:
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:qiaolf
 * @Date:2021/7/28 9:36
 **/
public class offer13 {
    public static int movingCount(int m, int n, int k) {
        if (m<0 || n<0 || k<0){
            return 0;
        }
        boolean[][] visit = new boolean[m][n];
        return process(m,n,0,0,k,visit);
    }

    private static int process(int m, int n, int x, int y,int k,boolean[][] visit) {
        if (x<0 || y<0 || x>=m || y>=n || (total(x)+total(y))>k || visit[x][y]){
            return 0;
        }
        visit[x][y]=true;
        return 1+process(m,n,x+1,y,k,visit)+process(m,n,x,y+1,k,visit);

    }

    public static int total(int N){
        int m = N;
        int sum = 0;
        int i=0;
        while (N>0){
            N=N/10;
            sum+=(m/(int) Math.pow(10,i))%10;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(3,2,17));
    }
}
