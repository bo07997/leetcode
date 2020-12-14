package leetcode.DP;

public class lc152 {
    public static void main(String[] args) {
        maxProduct(new int[]{-2,0,-1,-2,-3});
    }
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE,imax=1,imin=1;
        //imax意味着前一个必定参与组成
        for (int i=0;i<nums.length;i++){
            if (nums[i]<0){
                imax^=imin;
                imin^=imax;
                imax^=imin;
            }
            imax = Math.max(nums[i],imax*nums[i]);
            imin = Math.min(nums[i],imin*nums[i]);
            max = Math.max(max,imax);
        }
        return max;
    }
}
