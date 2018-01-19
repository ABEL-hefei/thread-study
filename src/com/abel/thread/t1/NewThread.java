package com.abel.thread.t1;

public class NewThread implements Runnable{

	@Override
	public synchronized void run() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("自定义线程执行了...");
	}
	
	
	public static void main(String[] args) {
		NewThread n = new NewThread();
		Thread t = new Thread(n);
		t.start();
		while(true) {
			//同步监视器
			synchronized (n) {
				System.out.println("主线程线程执行了...");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				n.notifyAll();
			}
		}
		
	}
}
