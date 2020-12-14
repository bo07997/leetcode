package leetcode.myjob;

import java.util.Arrays;

/**
 * @author ldb
 * @Package leetcode.myjob
 * @date 2020/12/2 18:16
 */
public enum NodeType {
	/**
	 * 普通
	 */
	NORMAL(0),
	/**
	 * 障碍
	 */
	OBSTACLE(1),

	;
	int id;

	NodeType(int id) {
		this.id = id;
	}

	public static NodeType parse(int id) {
		return Arrays.stream(NodeType.values()).filter(nt -> nt.id == id).findAny().orElse(NORMAL);
	}
}
