package com.abel.thread.t9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁的使用
 * @author abel
 */
public class Sequence {
	private int value;
	//创建一个锁对象，多个线程公用一把锁
	
	Lock lock = new ReentrantLock();
	
	public int getNext() {
		//使用锁
		lock.lock();
		int a = value++;
		//释放锁
		lock.unlock();
		return a;
	}
	
	public static void main(String[] args) {
		Sequence s = new Sequence();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName() +" "+s.getNext());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
