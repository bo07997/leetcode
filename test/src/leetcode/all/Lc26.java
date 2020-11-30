package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/27 20:49
 */
public class Lc26 {
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		String s = "xyz";
		String s2 = new String("xyz");
		System.out.println(s == s2);
		String s3 = s + s2;

	}

	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return 1;
		}
		int i = 0;
		int j = 1;
		for (; j < nums.length; j++) {
			if (nums[i] == nums[j]) {
				continue;
			} else {
				nums[++i] = nums[j];
			}

		}
		return i + 1;
	}
}
