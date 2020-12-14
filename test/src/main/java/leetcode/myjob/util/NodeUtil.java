package leetcode.myjob.util;

/**
 * @author ldb
 * @Package leetcode.myjob.util
 * @date 2020/12/3 14:10
 */
public class NodeUtil {
	public static int changeOne(int x, int y) {
		return x * 10 + y;
	}

	public static int[][] changeTwo(int line) {
		int[][] result = new int[1][2];
		result[0][0] = line / 10;
		result[0][1] = line % 10;
		return result;
	}
}
