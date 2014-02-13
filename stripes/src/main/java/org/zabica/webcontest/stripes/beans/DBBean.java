package org.zabica.webcontest.stripes.beans;

import java.util.concurrent.locks.ReentrantLock;

import org.springframework.context.SmartLifecycle;
import org.zabica.webcontest.common.store.PersistentStore;

public class DBBean extends PersistentStore implements SmartLifecycle {

	private boolean running = false;
	private ReentrantLock lock = new ReentrantLock();

	@Override
	public void start() {
		System.out.println("START called");
		lock.lock();
		try {
			if (this.running)
				return;
			this.running = true;
			init();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void stop() {
		lock.lock();
		try {
			if (!this.running)
				return;
			deinit();
			this.running = false;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean isRunning() {
		return this.running;
	}

	@Override
	public int getPhase() {
		return 1;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		lock.lock();
		try {
			if (!this.running)
				return;
			deinit();
			this.running = false;
			callback.run();
		} finally {
			lock.unlock();
		}
	}
}
