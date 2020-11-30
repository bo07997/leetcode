package leetcode.DP;

import java.util.HashMap;
import java.util.Map;

public class lc85 {
    public static void main(String[] args) {
//        char[][] test = new char[][]{
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//        };
        char[][] test = new char[][]{
                {'0','0','0'},
                {'0','0','0'},
                {'1','1','1'},
        };
        lc85 jj = new lc85();
        System.out.println(jj.maximalRectangle(test));
    }
    //大的由小的组成,小的存在map里面
    public int maximalRectangle(char[][] matrix) {
        Map<String,Integer> result = new HashMap<>();
        if (matrix.length==0){
            return 0;
        }
        int width = matrix[0].length;
        int high = matrix.length;
        for (int m = 0;m<width;m++){
            for (int n=0;n<high;n++){
                for(int i =0;i<high;i++){
                    for(int j=0;j<width;j++){
                        int num = find(i,j,i+n,j+m,result,matrix);
                        if (num!=-1){
                            result.put(getKey(i,j,i+n,j+m),num);
                        }
                    }
                }
            }
        }
        return result.entrySet().stream().mapToInt(Map.Entry::getValue).max().getAsInt();
    }
    //a节点一点要在b节点前面
    private int find(int i, int j, int m, int n, Map<String, Integer> result,char[][] matrix) {
        if (m<i||n<j||n>=matrix[0].length||m>=matrix.length){
            return -1;
        }
        if (i==m&&j==n){
            return matrix[i][j] == '1'?1:0;
        }
        int value = 0;
        for(int x = i;x<=n;x++){
            if (j == n){
                String key = getKey(i,j,m - 1,n);
                int temp = result.get(key);
                if (temp>0&&matrix[m][n]=='1'){
                    value = temp + 1;
                    break;
                } else {
                    return 0;
                }
            }
            String key = getKey(i,x,m,x);
//            System.out.println(key);
            value += result.get(key) + matrix[m][n]=='1'?1:0;
        }
        return value;
    }


    private String getKey(int i, int j, int m, int n) {
        return String.format("%d_%d_%d_%d",i,j,m,n);
    }
}
