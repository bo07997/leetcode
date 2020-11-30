package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/6/15 17:50
 */
public class Lc165 {
	public static void main(String[] args) {
		compareVersion("0.1", "1.1");
	}

	public static int compareVersion(String version1, String version2) {
		String[] version1Arr = version1.split("\\.");
		String[] version2Arr = version2.split("\\.");
		int result = 0;
		int maxSize = Math.max(version1Arr.length, version2Arr.length);
		for (int i = 0; i < maxSize; i++) {
			int tempVersion1 = version1Arr.length > i ? Integer.parseInt(version1Arr[i]) : 0;
			int tempVersion2 = version2Arr.length > i ? Integer.parseInt(version2Arr[i]) : 0;
			if (tempVersion1 > tempVersion2) {
				result = 1;
				break;
			} else if (tempVersion1 < tempVersion2) {
				result = -1;
				break;
			}
		}
		return result;
	}
}
