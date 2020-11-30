package leetcode.test.designpatterns;

import java.util.Collection;
import java.util.Map;

/**
 * @author ldb
 * @date 2020/5/17 15:38
 */
public class Father {
	public Collection doSomething(Map map) {
		System.out.println("父类被执行...");
		return map.values();
	}
}
