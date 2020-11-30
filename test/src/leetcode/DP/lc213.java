package leetcode.DP;

public class lc213 {
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
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = init;
        for (int i = 2;i<nums.length;i++){
            int newNum = nums[i] + result[i-2];
            if (newNum>result[i-1]){
                result[i] = newNum;
            }else {
                result[i] = result[i-1];
            }
            if (i==2){
                nums[2] = Math.max(nums[1],nums[2]);
            }else {
                int newNum2 = nums[i] + nums[i-2];
                if (newNum2>nums[i-1]){
                    nums[i] = newNum2;
                }else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return Math.max(result[result.length-2],nums[result.length-1]);
    }
}
