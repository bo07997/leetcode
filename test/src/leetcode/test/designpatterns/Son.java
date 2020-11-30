package leetcode.test.designpatterns;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author ldb
 * @date 2020/5/17 15:38
 */
public class Son extends Father {
	//缩小输入参数范围
	public Collection doSomething(HashMap map) {
		System.out.println("子类被执行...");
		return map.values();
	}
}
