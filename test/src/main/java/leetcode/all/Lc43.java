package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/28 16:58
 */
public class Lc43 {
	public static void main(String[] args) {
		Lc43 lc43 = new Lc43();
		System.out.println(lc43.multiply("6", "501"));
		System.out.println(2 * 3);
	}

	public String multiply(String num1, String num2) {
		String longStr = num1.length() >= num2.length() ? num1 : num2;
		String smallStr = num1.length() < num2.length() ? num1 : num2;
		if (smallStr.length() == 0) {
			return "0";
		}
		String result = "";
		//进位
		String bp = "";
		for (int i = smallStr.length() - 1; i >= 0; i--) {
			String now = singleMultiply(longStr, String.valueOf(smallStr.charAt(i))) + bp;
			result = add(result, now);
			bp += "0";
		}
		return result;
	}

	public String singleMultiply(String num1, String single) {
		if ("0".equals(single) || "0".equals(num1)) {
			return "0";
		}
		Integer sin = Integer.parseInt(single);
		String result = "";
		//进位
		int bp = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			int now = Integer.parseInt(String.valueOf(num1.charAt(i))) * sin + bp;
			int temp = now % 10;
			result = temp + result;
			bp = now / 10;
		}
		result = bp > 0 ? bp + result : result;
		int count0 = 0;
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == '0') {
				count0++;
			} else {
				break;
			}
		}
		return result.substring(count0);
	}

	private String add(String num1, String num2) {
		String result = "";
		String longStr = num1.length() >= num2.length() ? num1 : num2;
		String smallStr = num1.length() < num2.length() ? num1 : num2;
		if (smallStr.length() == 0) {
			return longStr;
		}
		int decNum = longStr.length() - smallStr.length();
		//进位
		int bp = 0;
		for (int i = longStr.length() - 1; i >= 0; i--) {
			int small = i - decNum >= 0 ? Integer.parseInt(String.valueOf(smallStr.charAt(i - decNum))) : 0;
			int now = small + Integer
					.parseInt(String.valueOf(longStr.charAt(i))) + bp;
			int temp = now % 10;
			result = temp + result;
			bp = now / 10;
		}
		return bp > 0 ? bp + result : result;
	}

}
