package leetcode.DP;

import java.util.Arrays;

public class lc91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }
    public static int numDecodings(String s) {
        int size = 3;
        int[] result = new int[3];
        for (int i=0;i<s.length();i++){
            result[i%size] = 0;
            int iNum = Integer.parseInt(s.substring(i,i+1));
            if (iNum>=1){
                if (i-1<0){
                    result[i%size] = 1;
                }
                else {
                    result[i%size] += result[(i-1)%size];
                }
            }
            if (i==0||'0'==s.charAt(i-1)){
                continue;
            }
            int iNum2 = Integer.parseInt(s.substring(i-1,i+1));
            if (iNum2>0&&iNum2<=26){
                if (i-2>=0){
                    result[i%size] += result[(i-2)%size];
                } else {
                    result[i%size] += 1;
                }
            }
        }
        return result[(s.length()-1)%size];
    }
//    public static int numDecodings(String s) {
//        int[] result = new int[s.length()];
//        for (int i=0;i<s.length();i++){
//            int iNum = Integer.parseInt(s.substring(i,i+1));
//            if (iNum>=1){
//                if (i-1<0){
//                    result[i] = 1;
//                }
//                else {
//                    result[i] += result[i-1];
//                }
//            }
//            if (i==0||'0'==s.charAt(i-1)){
//                continue;
//            }
//            int iNum2 = Integer.parseInt(s.substring(i-1,i+1));
//            if (iNum2>0&&iNum2<=26){
//                if (i-2>=0){
//                    result[i] += result[i-2];
//                } else {
//                    result[i] += 1;
//                }
//            }
//        }
//        return result[s.length()-1];
//    }
}
