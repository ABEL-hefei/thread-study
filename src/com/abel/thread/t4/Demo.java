package com.abel.thread.t4;

public class Demo {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Target());
		Thread t2 = new Thread(new Target());
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		
	}
}
