package leetcode.myjob;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ldb
 * @Package leetcode.myjob
 * @date 2020/12/2 20:14
 */
public class RandomUtil {
	public static double avgRandom(double min, double max) {
		if (min > max) {
			double temp = max;
			max = min;
			min = temp;
		}
		double rNum = ThreadLocalRandom.current().nextDouble() * (max - min);
		return rNum + min;
	}

	public static int avgRandom(int min, int max) {
		if (min > max) {
			int temp = max;
			max = min;
			min = temp;
		}
		int rNum = ThreadLocalRandom.current().nextInt(max - min + 1);
		return rNum + min;
	}
}
