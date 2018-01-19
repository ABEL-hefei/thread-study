package com.abel.thread.t2;
/**
 * Runnable 作为线程任务存在
 * @author hefei
 */
public class Demo2 implements Runnable {
	@Override
	public void run() {
		while(true) {
			System.out.println("线程开始执行......");
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new Demo2());
		
		t.start();
	}
}
