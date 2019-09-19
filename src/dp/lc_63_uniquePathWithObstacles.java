package dp;

/**
 * leetcode 63 不同路径
 * 找出从网格起始地点到终点的不同路径总数，会有障碍物
 * tags: [动态规划], [数组]
 */
public class lc_63_uniquePathWithObstacles {

    //自顶向下
    public int uniquePathWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid == null){
            return 0;
        } else if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        if(obstacleGrid[0][0] != -1){
            //初始位置不是障碍物
            obstacleGrid[0][0] = 1;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == -1){
                    continue;
                }
                if(i != 0 && j!= 0){
                    obstacleGrid[i][j] = (obstacleGrid[i][j-1] == -1 ? 0 : obstacleGrid[i][j-1])
                            + (obstacleGrid[i-1][j] == -1 ? 0 : obstacleGrid[i-1][j]);
                }
                else if(i == 0 && j != 0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] == -1 ? 0 : obstacleGrid[i][j-1];
                }
                else if(i != 0 && j == 0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] == -1 ? 0 : obstacleGrid[i-1][j];
                }
            }
        }
        return obstacleGrid[m-1][n-1] == -1 ? 0 : obstacleGrid[m-1][n-1];
    }

    public static void main(String[] args){
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        System.out.println(new lc_63_uniquePathWithObstacles().uniquePathWithObstacles(grid));
    }
}
