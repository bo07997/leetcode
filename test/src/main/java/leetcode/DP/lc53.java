package leetcode.DP;

import java.util.Arrays;
import java.util.stream.IntStream;

public class lc53 {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return  nums[0];
        }
        IntStream.rangeClosed(1,nums.length - 1).forEach(i->{
            if (nums[i-1]>0){
                nums[i] += nums[i-1];
            }
        });
        return Arrays.stream(nums).max().getAsInt();
    }
}
