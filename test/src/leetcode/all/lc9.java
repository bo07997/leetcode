package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/1 20:53
 */
public class lc9 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(10));
	}
	//禁用字符串

	public static boolean isPalindrome(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		if (x < 10) {
			return true;
		}
		int revert = 0;
		while (revert < x) {
			revert = 10 * revert + x % 10;
			x /= 10;
		}
		return revert == x || (x != 0 && x == revert / 10);
	}
}
