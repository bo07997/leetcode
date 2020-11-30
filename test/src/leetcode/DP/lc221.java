package leetcode.DP;

public class lc221 {
    public static void main(String[] args) {
        int[][] test = new int[][]{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
//        maximalSquare(test);
    }
    /**
     * 构造dp二维数组,dp[i][j]代表最大正方形边长,类似于晋升
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                if (matrix[i][j] == '1'){
                    if (i-1>=0&&j-1>=0){
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    if (max<dp[i][j]){
                        max = dp[i][j];
                    }

                }
            }
        }
        return max*max;
    }
}
