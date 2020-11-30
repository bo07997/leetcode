package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/27 19:43
 */
public class Lc38 {
	public static void main(String[] args) {
		Lc38 test = new Lc38();
		System.out.println(test.countAndSay(4));
	}

	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String front = countAndSay(n - 1);
		int start = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= front.length(); i++) {
			if (i == front.length()) {
				result.append(i - start).append(front.charAt(start));
			} else if (front.charAt(start) != front.charAt(i)) {
				result.append(i - start).append(front.charAt(start));
				start = i;
			}
		}
		return result.toString();
	}

}
