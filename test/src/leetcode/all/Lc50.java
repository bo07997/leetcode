package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/12/12 14:19
 * 50. Pow(x, n)
 */
public class Lc50 {
	public static void main(String[] args) {
		Lc50 lc47 = new Lc50();
		System.out.println(lc47.myPow(2, -2147483648));
	}

	//递归
	//	public double quickMul(double x, long n) {
	//		if (n == 0) {
	//			return 1;
	//		}
	//		double result = quickMul(x, n / 2);
	//		return n % 2 == 0 ? result * result : result * result * x;
	//	}

	//2进制
	public double quickMul(double x, long n) {
		double ans = 1.0;
		// 贡献的初始值为 x
		double x_contribute = x;
		while (n > 0) {
			if (n % 2 == 1) {
				ans *= x_contribute;
			}
			x_contribute *= x_contribute;
			n /= 2;
		}
		return ans;
	}

	public double myPow(double x, int n) {
		return n >= 0 ? quickMul(x, n) : 1 / quickMul(x, -n);
	}
}
