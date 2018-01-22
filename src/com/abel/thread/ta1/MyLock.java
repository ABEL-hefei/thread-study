package com.abel.thread.ta1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义一个锁
 * @author abel
 *
 */
public class MyLock implements Lock{

	private boolean isLock = false;
	
	private Thread lockBy = null;
	
	private int lockCount = 0;
	@Override
	public synchronized void lock() {
		Thread currentThread = Thread.currentThread();
		
		while (isLock && currentThread != lockBy) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isLock = true;
		lockBy = currentThread;
		lockCount++;
	}
	
	@Override
	public synchronized void unlock() {
		if (lockBy == Thread.currentThread()) {
			lockCount--;
		}
		isLock = false;
		notify();
		
	}
	
	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
