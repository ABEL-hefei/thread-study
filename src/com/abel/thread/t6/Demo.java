package com.abel.thread.t6;

/**
 * 重入锁-->锁的重入
 * @author abel
 *
 */
public class Demo {

	public synchronized void a () {
		System.out.println("a方法...");
		b();
	}
	
	public synchronized void b () {
		System.out.println("b方法...");
	}
	
	public static void main(String[] args) {
		Demo d = new Demo();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				d.a();
			}
		}).start();
	}
}
