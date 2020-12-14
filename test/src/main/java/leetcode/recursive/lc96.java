package leetcode.recursive;

import java.util.ArrayList;
import java.util.List;

public class lc96 {
    public static void main(String[] args) {
         System.out.println(numTrees(2));
    }
    public static int numTrees(int n) {
        return new_trees(1,n);
    }

    public static int new_trees(int start, int end){
        int count = 0;
        if (start>end||end==0){
            return 0;
        }
        if (end == start){
            return 1;
        }
        for (int i=start;i<=end;i++){
            int lefts = new_trees(start,i-1);
            int rights = new_trees(i+1,end);
            if (lefts!=0&&rights!=0){
                count += rights*lefts;
            } else if (lefts==0){
                count += rights;
            } else {
                count += lefts;
            }
        }
        return count;
    }
}
