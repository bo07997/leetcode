package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/22 15:00
 */
public class Lc29 {
	public static void main(String[] args) {
		Lc29 lc = new Lc29();
		System.out.println(lc.divide(-2147483648, -1));

	}

	public int divide(int dividend, int divisor) {
		long dividendLong = dividend;
		long divisorLong = divisor;
		long dividendAbs = (dividendLong < 0) ? -dividendLong : dividendLong;
		long divisorAbs = (divisorLong < 0) ? -divisorLong : divisorLong;
		long result = 0;
		long count = 1;
		long temp = divisorAbs;
		for (; (temp << 1) < dividendAbs; temp <<= 1) {
			count <<= 1;
		}
		for (long dividendAbsTemp = dividendAbs; temp >= divisorAbs; temp >>= 1, count >>= 1) {
			while (dividendAbsTemp >= temp) {
				dividendAbsTemp -= temp;
				result += count;
			}
		}
		long realResult = (divisor > 0) ^ (dividend > 0) ? -result : result;
		if (realResult > Integer.MAX_VALUE || realResult < Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int) realResult;
	}

}
