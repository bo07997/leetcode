package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/29 17:28
 */
public class Lc45 {
	public static void main(String[] args) {
		Lc45 lc45 = new Lc45();
		System.out.println(lc45.jump(new int[] { 2, 3, 1, 1, 4 }));
	}

	/**
	 * 贪心
	 *
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		int max = 0;
		int end = 0;
		int round = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(max, nums[i] + i);
			if (end == i) {
				end = max;
				round++;
			}
		}
		return round;
	}
}
