package leetcode.DP;

import java.util.Arrays;

public class lc10 {
    public static void main(String[] args) {
        System.out.println(isMatch("","c*c*"));
    }

    public static boolean isMatch(String s, String p) {
        if (s.equals(p)){
            return true;
        }
        if ("".equals(p)){
            return false;
        }
        if("".equals(s)){
            int[] temp = new int[p.length()];
            //初始化 列
            for (int i = 0;i<p.length();i++){
               if('*'==p.charAt(i)&&(((i - 1 >= 0&&temp[i-1]==-1)||(i - 2 >= 0&&temp[i-2]==-1))||i-1==0)){
                    temp[i] = -1;
               }
            }
            return temp[p.length() - 1] == -1;
        }

        int[][] result = new int[p.length()][s.length()];
        //初始化 行
        for (int j = 0;j<s.length();j++){
            if ('.'== p.charAt(0)&&j==0){
                result[0][j] = 1;
            } else if (p.charAt(0)==s.charAt(0)&&j==0){
                result[0][j] = 1;
            } else {
                result[0][j] = 0;
            }
        }

        //初始化 列
        for (int i = 0;i<p.length();i++){
            if (('.'==p.charAt(i)||p.charAt(i)==s.charAt(0))&&(i==0||result[i-1][0]==-1)){
                result[i][0] = 1;
            } else if ('*'==p.charAt(i)&& result[i-1][0]==1){
                result[i][0] = 1;
            } else if ('*'==p.charAt(i)&& result[i-1][0]==-1){
                result[i][0] = -1;
            } else if ('*'==p.charAt(i)&&i-1<=0){
                result[i][0] = -1;
            }else if ('*'==p.charAt(i)&&i-2>=0&&result[i-2][0]==1){
                result[i][0] = 1;
            }
            else if (i-1>=0&&'.'==p.charAt(i)&&p.charAt(i-1)=='*'&&result[i-1][0]==1){
                result[i][0] = 1;
            }
            else {
                result[i][0] = 0;
            }

        }
        for (int i = 1;i<p.length();i++){
            for (int j=1;j<s.length();j++){
                if (('.' == p.charAt(i)||p.charAt(i) ==s.charAt(j))&&result[i-1][j-1]==1){
                    result[i][j] = 1;
                }
                else if ('*'==p.charAt(i)){
                    //1.找第一个非*
                    char front = '*';
                    int temp =i;
                    for (;temp>=0;temp--){
                        if ('*'!=p.charAt(temp)){
                            front = p.charAt(temp);
                            break;
                        }
                    }
                    if (front=='.'&& Arrays.stream(result[temp]).filter(value->value==1).findAny().isPresent()){
                        result[i][j] = 1;
                    }
                    else if ((front=='.'||front==s.charAt(j))&&(result[i-1][j-1]==1||i-2>=0&&result[i-2][j-1]==1)){
                        result[i][j] = 1;
                    }
                    //找前2个
                    else if (i-2>=0&&result[i-2][j]==1){
                        result[i][j] = 1;
                    }

                }
            }
        }

        return result[p.length()-1][s.length()-1]==1;

    }
}
