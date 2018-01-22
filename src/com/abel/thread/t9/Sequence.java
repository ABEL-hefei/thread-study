package com.abel.thread.t9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock����ʹ��
 * @author abel
 */
public class Sequence {
	private int value;
	//����һ�������󣬶���̹߳���һ����
	
	Lock lock = new ReentrantLock();
	
	public int getNext() {
		//ʹ����
		lock.lock();
		int a = value++;
		//�ͷ���
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
