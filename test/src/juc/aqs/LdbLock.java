package juc.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author ldb
 * @Package juc.aqs
 * @date 2020/11/20 16:14
 */
public class LdbLock {
	private Sync sync = new Sync();

	private static final class Sync extends AbstractQueuedSynchronizer {
		@Override
		protected boolean tryAcquire(int arg) {
			return !hasQueuedPredecessors() && compareAndSetState(0, arg);
		}

		@Override
		protected boolean tryRelease(int arg) {
			return compareAndSetState(arg, getState() - arg);
		}

	}

	public void lock() {
		sync.acquire(1);
	}

	public void unLock() {
		sync.release(1);
	}
}
