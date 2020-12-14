package leetcode.DP.other;

/**
 * @author ldb
 * @Package leetcode.DP.other
 * @date 2020/6/13 15:36
 */
public class test1 {
	public static void main(String[] args) {
		int test = (int) (Math.pow(2, 31) - 1);
		System.out.println(test + 100);
	}

	public static int reverse(int x) {
		if (x == 0) {
			return 0;
		}
		String s = String.valueOf(x);
		StringBuffer buffer = new StringBuffer();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i == s.length() - 1 && s.charAt(i) == '0') {
				continue;
			}
			if (i == 0 && s.charAt(i) == '-') {
				buffer.insert(0, '-');
				continue;
			}
			buffer.append(s.charAt(i));
		}
		int result = 0;
		try {
			result = Integer.parseInt(buffer.toString());
		} catch (Exception e) {
		}

		return result;
	}
}
