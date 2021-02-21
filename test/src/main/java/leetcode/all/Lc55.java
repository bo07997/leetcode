package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/12/13 20:47
 * 55. 跳跃游戏
 */
public class Lc55 {
	public static void main(String[] args) {
		//
	}

	public boolean canJump(int[] nums) {
		int max = nums[0];
		boolean reach = false;
		for (int i = 0; i < nums.length; i++) {
			if (max >= nums.length - 1) {
				reach = true;
			}
			if (i == max && nums[max] == 0) {
				break;
			}
			if (nums[i] + i > max) {
				max = nums[i] + i;
			}
		}
		return reach;
	}
}
