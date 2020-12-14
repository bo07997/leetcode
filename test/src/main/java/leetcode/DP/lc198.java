package leetcode.DP;

public class lc198 {
    public static void main(String[] args) {
        rob(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5});
    }

    public static int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int init = Math.max(nums[0],nums[1]);
        if (nums.length == 2){
            return init;
        }
        nums[1] = init;
        for (int i = 2;i<nums.length;i++){
            int newNum = nums[i] + nums[i-2];
            if (newNum>nums[i-1]){
                nums[i] = newNum;
            }else {
                nums[i] = nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
}
