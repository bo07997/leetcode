package leetcode.test.designpatterns;

import java.util.HashMap;

/**
 * @author ldb
 * @date 2020/5/17 15:39
 */
public class Client {
	public static void invoker() {
		//有父类的地方就有子类
		Father f = new Son();
		//		Father f = new Father();
		HashMap map = new HashMap();
		f.doSomething(map);
	}

	public static void main(String[] args) {
		invoker();
	}
}