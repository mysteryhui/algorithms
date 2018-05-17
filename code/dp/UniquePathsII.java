package dp;

/**
 * @Author : wanghui
 * @Date : create on 2018/3/14
 * @Description:
 */
public class UniquePathsII {


    public static void main(String[] args) {


    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid.length < 1 || obstacleGrid[0].length < 1){
            return 0;
        }

        int row = obstacleGrid.length;
        int line = obstacleGrid[0].length;

        int[][] paths = new int[row][line];

        paths[0][0] = obstacleGrid[0][0] == 0?1:0;

        for(int i=1;i < row;i++)
            paths[i][0] = (paths[i-1][0] == 1 && obstacleGrid[i][0] == 0) ? 1 : 0;

        for(int j=1;j < line;j++)
            paths[0][j] = (paths[0][j-1] == 1 && obstacleGrid[0][j] == 0) ? 1 : 0;

        for(int i=1;i < row;i++){

            for(int j=1;j < line;j++){

                if(obstacleGrid[i][j] == 1)
                    paths[i][j] = 0;
                else
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];

            }

        }

        return paths[row-1][line-1];
    }


}
