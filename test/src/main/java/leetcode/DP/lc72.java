package leetcode.DP;

public class lc72 {

    public static void main(String[] args) {
        minDistance("a","a");
    }

    public static int minDistance(String word1, String word2) {
        if ("".equals(word1)||"".equals(word2)){
            return Math.max(word1.length(),word2.length());
        }
        int[][] result = new int[word2.length()][word1.length()];
        //初始化 行
        for (int i=0;i<word1.length();i++){
//            String test = word1.substring(0,i);
//            char test2 = word2.charAt(0);
//            String test3 = String.valueOf(word2.charAt(0));
            if (word1.substring(0,i + 1).contains(String.valueOf(word2.charAt(0)))){
                result[0][i] = i ;
            } else {
                result[0][i] = i +1;
            }
        }
        //初始化 列
        for (int j=1;j<word2.length();j++){
            if (word2.substring(0,j + 1).contains(String.valueOf(word1.charAt(0)))){
                result[j][0] = j;
            } else {
                result[j][0] = j + 1;
            }
        }

        for (int i=1;i<word2.length();i++){
            for (int j=1;j<word1.length();j++){
                if(word1.charAt(j)==word2.charAt(i)){
                    result[i][j] = 1 + Math.min(result[i -1][j-1] - 1,Math.min(result[i][j-1],result[i-1][j])) ;
                } else {
                    result[i][j] = 1 + Math.min(result[i -1][j-1],Math.min(result[i][j-1],result[i-1][j])) ;
                }
            }
        }
        return result[word2.length() - 1][word1.length() -1];
    }
}
