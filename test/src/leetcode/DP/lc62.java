package leetcode.DP;

public class lc62 {
    public static void main(String[] args) {

    }
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        int max = 1;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0||j==0){
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
                max = Math.max(max,result[i][j]);
            }
        }
        return max;
    }

}
