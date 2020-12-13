package leetcode.myjob;

import java.util.Arrays;

/**
 * @author ldb
 * @Package leetcode.myjob
 * @date 2020/12/2 20:43
 * 机关
 */
public enum Organ {
	/**
	 * 无
	 */
	NOTHING(0),
	/**
	 * 冰冻
	 */
	FROZEN(1),
	/**
	 * 变化
	 */
	CHANGE(2),
	/**
	 * 履带
	 */
	TRACK(3);
	int id;

	Organ(int id) {
		this.id = id;
	}

	public static Organ parse(int id) {
		return Arrays.stream(Organ.values()).filter(nt -> nt.id == id).findAny().orElse(NOTHING);
	}
}
