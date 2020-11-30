package leetcode.DP;

public class lc70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
    public static int climbStairs(int n) {
        if (n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }
        int i1 = 1;
        int i2 = 2;
        int i3= 3;
        for (int i=3;i<=n;i++){
            i3 = i1 + i2;
            i1 = i2;
            i2 = i3;
        }
        return i3;
    }
}
