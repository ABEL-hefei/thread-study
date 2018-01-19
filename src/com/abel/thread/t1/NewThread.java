package com.abel.thread.t1;

public class NewThread implements Runnable{

	@Override
	public synchronized void run() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�Զ����߳�ִ����...");
	}
	
	
	public static void main(String[] args) {
		NewThread n = new NewThread();
		Thread t = new Thread(n);
		t.start();
		while(true) {
			//ͬ��������
			synchronized (n) {
				System.out.println("���߳��߳�ִ����...");
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
