package com.abel.thread.t6;

/**
 * ������-->��������
 * @author abel
 *
 */
public class Demo {

	public synchronized void a () {
		System.out.println("a����...");
		b();
	}
	
	public synchronized void b () {
		System.out.println("b����...");
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
