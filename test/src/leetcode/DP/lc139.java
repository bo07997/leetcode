package leetcode.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc139 {
    public static void main(String[] args) {
        wordBreak("leetcode",Arrays.asList("leet","code"));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        //初始化一下
        if (wordDict.contains(s.substring(0,1))){
            dp[0] = 1;
        }
        for (int i = 1;i<s.length();i++){
            for (int j=0;j<=i;j++){
                if (j==i&&wordDict.contains(s.substring(0,i+1))){
                    dp[i] = 1;
                    break;
                }
                if (dp[j] == 1&&wordDict.contains(s.substring(j+1,i+1))){
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[dp.length - 1]==1;
    }
}
