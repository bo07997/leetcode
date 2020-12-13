package leetcode.myjob;

import leetcode.myjob.config.PetV1Config;
import leetcode.myjob.config.ruleConfig;
import leetcode.myjob.strategy.GenerateStrategy;
import leetcode.myjob.util.NodeUtil;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ldb
 * @Package leetcode.myjob
 * @date 2020/12/2 19:41
 */
public class Test {
	public static void main(String[] args) {
		Test tt = new Test();
		// Create a large, ugly number.
		//		BigInteger bi = BigInteger.valueOf(1001).pow(345);
		BigInteger bi = BigInteger.valueOf(12);
		double t = 0.2;
		double t2 = t + 0.4;
		System.out.println();
		// Convert to scientific notation using invariant Locale.ROOT
		//		NumberFormat formatter = new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ROOT));
		//		String str = formatter.format(bi);
		//		//		BigInteger tt = new BigInteger("1.07615976836596E+16");
		//		BigInteger bd = new BigDecimal("1.86E+6").toBigInteger();
		//		System.out.println(bi.bitCount());
		//		System.out.println();
		//		System.out.println(str);
		Node[][] nodes = Node.parseArray(
				"0:1#0:4#0:7#0:1#0:4|0:7#0:1#0:4#0:7#0:1|0:1#0:7#0:7#0:1#0:4|0:4#0:1#0:4#0:1#0:1|0:4#0:1#0:4#0:4#0:7");
		//		Node[][] nodes = Node.parseArray(
		//				"0:1#0:4#0:1#0:7#0:4|0:7#0:1#0:7#0:1#0:1|0:7#0:1#0:4#0:7#0:4|0:4#0:1#0:7#0:1#0:1|0:1#0:5#0:4#0:1#0:7");
		//		generateNode(nodes);
		//		StringBuilder sb = new StringBuilder("0");
		//		sb.replace(sb.length() - 1, sb.length(), "|");
		//		BigDecimal bd = new BigDecimal("1.86E+6");
		//		BigDecimal bd2 = new BigDecimal("-50");
		//		System.out.println(bd.add(new BigDecimal("1")));
		//		System.out.println(getString(nodes));
		tt.changeNode(nodes, new int[][] { { 4, 0 }, { 4, 1 } });
	}

	/**
	 * 给测试用
	 */
	public static String getString(Node[][] nodes) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < nodes.length; i++) {
			if (i == 0) {
				builder.append("   0|1|2|3|4 \r\n");
			}
			for (int j = 0; j < nodes[i].length; j++) {
				if (j == 0) {
					builder.append(i).append(" |");
				}
				if (nodes[i][j] == null) {
					builder.append("0").append("|");
					continue;
				}
				builder.append(nodes[i][j].toTest()).append("|");
			}
			builder.append("\r\n");
		}
		return builder.toString();
	}

	/**
	 * 随机初始化
	 */
	public static boolean generateNode(Node[][] nodes) {
		boolean result = false;
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[i].length; j++) {
				if (nodes[i][j] == null) {
					nodes[i][j] = new Node(NodeType.NORMAL, PetV1Config.randomPet());
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * 3个维度判断是否可消除
	 * <p>
	 * 1.思路:双向找到第一个不等于当前节点的节点,相减即该方向最长相等坐标个数
	 * 2.2维坐标转化为一维,方便去重,HASH
	 */
	public void clearNode(Node[][] nodes, int x, int y, Map<Integer, Set<Integer>> hasClear) {
		Set<Integer> result = new HashSet<>();
		Arrays.stream(PathRule.values()).forEach(pt -> {
			Set<Integer> var1 = new HashSet<>();
			var1.add(NodeUtil.changeOne(x, y));
			int[][] coordinate = new int[][] { { x, y } };
			//防止异常
			for (int temp = 0; temp < 1000; temp++) {
				pt.function1.apply(coordinate);
				if (coordinate[0][0] < 0 || coordinate[0][1] < 0 || coordinate[0][0] >= nodes.length
						|| coordinate[0][1] >= nodes[coordinate[0][0]].length) {
					break;
				}
				if (nodes[x][y].myEquals(nodes[coordinate[0][0]][coordinate[0][1]])) {
					var1.add(NodeUtil.changeOne(coordinate[0][0], coordinate[0][1]));
				} else {
					break;
				}
			}
			coordinate = new int[][] { { x, y } };
			for (int temp = 0; temp < 1000; temp++) {
				pt.function2.apply(coordinate);
				if (coordinate[0][0] < 0 || coordinate[0][1] < 0 || coordinate[0][0] >= nodes.length
						|| coordinate[0][1] >= nodes[coordinate[0][0]].length) {
					break;
				}
				if (nodes[x][y].myEquals(nodes[coordinate[0][0]][coordinate[0][1]])) {
					var1.add(NodeUtil.changeOne(coordinate[0][0], coordinate[0][1]));
				} else {
					break;
				}
			}
			if (var1.size() >= ruleConfig.MIN_CLEAR) {
				result.addAll(var1);
			}
		});
		if (result.isEmpty()) {
			return;
		}
		Integer father = result.stream().filter(hasClear::containsKey).findAny().orElse(null);
		if (father == null) {
			hasClear.put(NodeUtil.changeOne(x, y), result);
		} else {
			hasClear.get(father).addAll(result);
		}
	}

	/**
	 * 下落,填充,并且将变化的加入变更集
	 */
	public void downNode(Node[][] nodes, List<Integer> hasChange) {
		boolean hasDown = false;
		//下落
		for (int i = nodes.length - 1; i >= 0; i--) {
			for (int j = nodes[i].length - 1; j >= 0; j--) {
				if (nodes[i][j] != null) {
					int di = i + 1;
					while (di < nodes.length && nodes[di][j] == null) {
						di++;
					}
					if (di != i + 1) {
						hasChange.add(NodeUtil.changeOne(di - 1, j));
						nodes[di - 1][j] = nodes[i][j];
						nodes[i][j] = null;
						hasDown = true;
					}
				}
			}
		}
		if (hasDown) {
			System.out.println("下落");
			System.out.println(getString(nodes));
		}
		//填充
		boolean result = generateNode(nodes);
		if (result) {
			System.out.println("填充");
			System.out.println(getString(nodes));
		}
	}

	/**
	 * 交换2个节点,并且改变状态
	 */
	public void changeNode(Node[][] nodes, int[][] cn) {
		List<Integer> hasChange = new ArrayList<>();
		Node tempNode = nodes[cn[0][0]][cn[0][1]];
		nodes[cn[0][0]][cn[0][1]] = nodes[cn[1][0]][cn[1][1]];
		nodes[cn[1][0]][cn[1][1]] = tempNode;
		hasChange.add(NodeUtil.changeOne(cn[0][0], cn[0][1]));
		hasChange.add(NodeUtil.changeOne(cn[1][0], cn[1][1]));
		System.out.println("交换完毕,准备消除");
		System.out.println(getString(nodes));
		boolean first = true;
		while (!hasChange.isEmpty()) {
			List<Integer> tempHasChange = new ArrayList<>();
			Map<Integer, Set<Integer>> hasClear = new HashMap<>();
			while (!hasChange.isEmpty()) {
				int[][] coordinate = NodeUtil.changeTwo(hasChange.get(0));
				hasChange.remove(0);
				clearNode(nodes, coordinate[0][0], coordinate[0][1], hasClear);
			}
			//结算 将高级节点加入变化
			settlement(nodes, hasClear, tempHasChange, first ? GenerateStrategy.change : GenerateStrategy.down);
			first = false;
			System.out.println("结算");
			System.out.println(getString(nodes));
			//下落填充
			downNode(nodes, tempHasChange);
			hasChange = tempHasChange;
		}
	}

	/**
	 * 1.中心坐标向下取整 加入变更集
	 */
	public void settlement(Node[][] nodes, Map<Integer, Set<Integer>> hasClear,
			List<Integer> hasChange, GenerateStrategy strategy) {
		//结算
		//生成更高级节点
		Map<Integer, Integer> generateNode = hasClear.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, en -> strategy.generateAdvanced(en, nodes)));
		//生成(自动飞出逻辑先不做)
		generateNode.forEach((key, value) -> {
			int[][] temp = NodeUtil.changeTwo(value);
			Node now = nodes[temp[0][0]][temp[0][1]];
			int nextPetV1Id = now.getPetV1().nextPetV1Id;
			PetV1 petV1 = PetV1Config.getPetById(nextPetV1Id);
			if (petV1 != null) {
				nodes[temp[0][0]][temp[0][1]] = new Node(now.getNodeType(), petV1);
				hasChange.add(NodeUtil.changeOne(temp[0][0], temp[0][1]));
			}
		});
		HashSet<Integer> filter = new HashSet<>(generateNode.values());
		//清理
		hasClear.entrySet().stream().flatMap(en -> en.getValue().stream())
				.filter(coordinate -> !filter.contains(coordinate)).forEach(coordinate -> {
			int[][] temp = NodeUtil.changeTwo(coordinate);
			nodes[temp[0][0]][temp[0][1]] = null;
			hasChange.add(NodeUtil.changeOne(temp[0][0], temp[0][1]));
		});
		hasClear.clear();
	}

	enum PathRule {
		/**
		 * 斜
		 */
		slope1(coordinate -> {
			coordinate[0][0]--;
			coordinate[0][1]--;
		}, coordinate -> {
			coordinate[0][0]++;
			coordinate[0][1]++;
		}),
		slope2(coordinate -> {
			coordinate[0][0]++;
			coordinate[0][1]--;
		}, coordinate -> {
			coordinate[0][0]--;
			coordinate[0][1]++;
		}),
		/**
		 * 横
		 */
		horizontal(coordinate -> {
			coordinate[0][1]--;
		}, coordinate -> {
			coordinate[0][1]++;
		}),
		/**
		 * 竖
		 */
		vertical(coordinate -> {
			coordinate[0][0]--;
		}, coordinate -> {
			coordinate[0][0]++;
		});
		IPathFunction function1;
		IPathFunction function2;

		PathRule(IPathFunction function1, IPathFunction function2) {
			this.function1 = function1;
			this.function2 = function2;
		}
	}
}
