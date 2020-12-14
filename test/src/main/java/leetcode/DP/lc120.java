package leetcode.DP;

import java.util.List;

public class lc120 {
    public static void main(String[] args) {

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> lastResult = triangle.get(0);
        for (int i =1;i<triangle.size();i++){
            List<Integer> temp = triangle.get(i);
            for (int j=0;j<temp.size();j++){
                if(j==0){
                    temp.set(j,lastResult.get(j) + temp.get(j));
                } else if(j == lastResult.size()){
                    temp.set(j,lastResult.get(j-1)+ temp.get(j));
                } else {
                    temp.set(j,Math.min(lastResult.get(j),lastResult.get(j-1))+ temp.get(j));
                }
            }
            lastResult = temp;
        }
        return lastResult.stream().min(Integer::compareTo).get();
    }
}
