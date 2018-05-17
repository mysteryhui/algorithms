package dp;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */

/**
 * 思路：因为每次都是只能向右走一步，或者向下走一步；
 *
 * 所以，paths(m,n) = paths(m-1,n) + paths(m,n-1);
 *
 */

/**
 * @Author : wanghui
 * @Date : create on 2018/3/13
 * @Description:
 */
public class UniquePaths {

    public static void main(String[] args) {

        int paths = uniquePaths(1,9);
        System.out.println(paths);

    }

    /**
     * paths(m,n) = paths(m-1,n) + paths(m,n-1);
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {

        int[][] paths = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(i == 0)
                    paths[i][j] = 1;
                else if(j == 0)
                    paths[i][j] = 1;
                else
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }

        return paths[m-1][n-1];
    }
}
