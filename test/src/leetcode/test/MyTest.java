package leetcode.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ldb
 * @Package leetcode.test
 * @date 2020/4/15 17:41
 */
public class MyTest {
	static int a = 1;
	private static final ExecutorService SINGLE_POOL = Executors.newSingleThreadExecutor();

	public static void main(String[] args) {
		//		Set<String> tt = Arrays.stream(test.values()).map(Enum::toString).collect(Collectors.toSet());
		//		System.out.println();
		//		SINGLE_POOL.execute(() -> {
		////			while (true) {
		////				try {
		////					System.out.println(a++);
		////					Thread.sleep(1000);
		////				} catch (Exception e) {
		////					e.printStackTrace();
		////					break;
		////				}
		////			}
		////		});
		//		List
		//		List<Integer> tets = null;
		//		for (int i : tets) {
		//
		//		}
		test tt = test.test1;
	}

	enum test {
		test1,
		test2,
		;
	}

	static int test() {
		int x;
		try {
			x = 1;
			return x;
		} catch (Exception e) {
			x = 2;
			return x;
		} finally {
			x = 3;
		}
	}
}

class test2 {
	static int i = 2;

	static {
		System.out.println("我被加载了");
	}

	public test2() {

	}

	static void test11() {

	}
}