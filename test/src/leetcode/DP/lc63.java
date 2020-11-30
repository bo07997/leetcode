package leetcode.DP;

public class lc63 {
    public static void main(String[] args) {

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        obstacleGrid[0][0] ^= 1;
        int max = obstacleGrid[0][0];
        for (int i=0;i<obstacleGrid.length;i++){
            for (int j=0;j<obstacleGrid[0].length;j++){
                if (i==0&&j==0){
                    continue;
                }
                if (obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]= 0;
                    max=0;
                    continue;
                }
                if (i==0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                } else if(j==0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
                max = Math.max(max,obstacleGrid[i][j]);
            }
        }
        return max;
    }
}
