package dp;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example 1:
 [[1,3,1],
 [1,5,1],
 [4,2,1]]
 Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 */

/**
 * @Author : wanghui
 * @Date : create on 2018/3/15
 * @Description:
 */
public class MinimumPathSum {

    public static void main(String[] args) {

        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int minimumPathSum = minPathSum(grid);
        System.out.println(minimumPathSum);

    }

    public static int minPathSum(int[][] grid) {

        if(grid.length < 1)
            return 0;

        int row = grid.length;
        int line = grid[0].length;

        int[][] paths = new int[row][line];
        paths[0][0] = grid[0][0];

        for(int i=1;i < row;i++)
            paths[i][0] = paths[i-1][0] + grid[i][0];

        for(int j=1;j <line;j++)
            paths[0][j] = grid[0][j] + paths[0][j-1];

        for(int i=1;i<row;i++)
            for(int j=1;j < line;j++)
                paths[i][j] = Math.min(paths[i-1][j],paths[i][j-1]) + grid[i][j];

        return paths[row-1][line-1];

    }

}
