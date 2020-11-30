package leetcode.all;

import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.java_cup.internal.runtime.Symbol;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/6/16 10:13
 */
public class Lc1310 implements Scanner {
	private int a = 100;

	private Lc1310() {
		int a = 5;
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		Condition condition2 = lock.newCondition();
		ArrayBlockingQueue queue = new ArrayBlockingQueue(2);
		queue.take();
		queue.put(null);
		condition2.await();
		condition2.signal();
		condition.signalAll();
	}

	protected static void test2(int a) {
		int b = a;
		System.out.println(b);
	}

	protected static void test(int a) {
		int b = a;
		System.out.println(b);
	}

	@Override
	public Symbol next_token() throws Exception {
		return null;
	}
}
