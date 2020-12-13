package leetcode.myjob.strategy;

import leetcode.myjob.Node;
import leetcode.myjob.util.NodeUtil;

import java.util.Map;
import java.util.Set;

/**
 * @author ldb
 * @Package leetcode.myjob.strategy
 * @date 2020/12/3 20:59
 */
public enum GenerateStrategy {
	/**
	 * 交换策略
	 */
	change {
		@Override
		public Integer generateAdvanced(Map.Entry<Integer, Set<Integer>> entry, Node[][] nodes) {
			return entry.getKey();
		}
	},
	/**
	 * 下落策略
	 */
	down {
		@Override
		public Integer generateAdvanced(Map.Entry<Integer, Set<Integer>> entry, Node[][] nodes) {
			Set<Integer> sets = entry.getValue();
			int[][] result = new int[1][2];
			sets.forEach(s -> {
				int[][] temp = NodeUtil.changeTwo(s);
				result[0][0] += temp[0][0];
				result[0][1] += temp[0][1];
			});
			result[0][0] /= sets.size();
			result[0][1] /= sets.size();
			int x = 0;
			int y = 0;
			int distance = Integer.MAX_VALUE;
			for (int s : sets) {
				int[][] temp = NodeUtil.changeTwo(s);
				int tempDistance = getDistance(result[0][0], result[0][1], temp[0][0], temp[0][1]);
				if (tempDistance > distance) {
					continue;
				}
				if (distance == tempDistance && NodeUtil.changeOne(temp[0][0], temp[0][1]) > NodeUtil
						.changeOne(x, y)) {
					continue;
				}
				distance = tempDistance;
				x = temp[0][0];
				y = temp[0][1];
			}
			return NodeUtil.changeOne(x, y);
		}
	},
	;

	public abstract Integer generateAdvanced(Map.Entry<Integer, Set<Integer>> entry, Node[][] nodes);

	private static int getDistance(int x, int y, int i, int j) {
		return (int) (Math.pow(x - i, 2) + Math.pow(y - j, 2));
	}
}
