import juc.aqs.LdbLock;

import java.util.concurrent.CountDownLatch;

/**
 * @author ldb
 * @Package PACKAGE_NAME
 * @date 2020/4/10 15:46
 */
public class CommonTest {
	static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		LdbLock ldbLock = new LdbLock();
		CountDownLatch latch = new CountDownLatch(10);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				ldbLock.lock();
				for (int i1 = 0; i1 < 100000; i1++) {
					count++;
				}
				ldbLock.unLock();
				latch.countDown();
			}).start();
		}
		latch.await();
		System.out.println(count);
		System.out.println(System.currentTimeMillis() - start);
	}

}
