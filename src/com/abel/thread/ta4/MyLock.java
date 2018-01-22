package com.abel.thread.ta4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 根据AQS自己编写一个锁
 * @author Administrator
 *
 */
public class MyLock implements Lock{

	private Helper helper = new Helper();
	
	/**
	 * 此内部类相当于源码中的同步器类Sync
	 * @author abel
	 */
	private class Helper extends AbstractQueuedSynchronizer{
		
		/**
		 * 获取锁
		 */
		@Override
		protected boolean tryAcquire(int arg) {
			/*
			 * 如果是第一个线程，可以拿到锁，返回true
			 * 第二个线程进来，拿不到锁，返回false
			 * 主要是实现判断是第一个线程进来还是其他线程进来的逻辑
			 * 锁的重入：如果当前进来的线程与当前保存的线程为同一个线程，则可以拿到锁，但必须更新状态值
			 */
			int state = getState();
			Thread t = Thread.currentThread();
			if(state == 0) {
				if(compareAndSetState(0, arg)) {
					setExclusiveOwnerThread(t);
					return true;
				}
			}else if(getExclusiveOwnerThread() == t) {
				setState(state+1);
				return true;
			}
			return false;
		}
		
		@Override
		protected boolean tryRelease(int arg) {
			/*
			 * 锁的获取和释放肯定是一一对应的
			 */
			if(Thread.currentThread() != getExclusiveOwnerThread()) {
				throw new RuntimeException();
			}
			
			int state = getState() -arg;
			boolean flag = false;
			if(state == 0) {
				setExclusiveOwnerThread(null);
				flag = true;
			}
			setState(state);
			
			return flag;
		}
		
		Condition newCondition () {
			return new ConditionObject();
		}
	}

	@Override
	public void lock() {
		helper.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		helper.acquireInterruptibly(1);
		
	}

	@Override
	public boolean tryLock() {
		return helper.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return helper.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		helper.release(1);
	}

	@Override
	public Condition newCondition() {
		return helper.newCondition();
	}
}
