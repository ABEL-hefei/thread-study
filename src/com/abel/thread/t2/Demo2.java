package com.abel.thread.t2;
/**
 * Runnable ��Ϊ�߳��������
 * @author hefei
 */
public class Demo2 implements Runnable {
	@Override
	public void run() {
		while(true) {
			System.out.println("�߳̿�ʼִ��......");
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new Demo2());
		
		t.start();
	}
}
