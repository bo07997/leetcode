package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldb @Package leetcode.all
 * @date 2020/12/13 20:47 57. 插入区间 不想做
 */
public class Lc57 {
	public static void main(String[] args) {
		//
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> merged = new ArrayList<>();
		for (int i = 0; i < intervals.length; ++i) {
			int l = intervals[i][0], r = intervals[i][1];
			if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < l) {
				merged.add(new int[] { l, r });
			} else {
				merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
			}
		}
		return null;
	}
}
