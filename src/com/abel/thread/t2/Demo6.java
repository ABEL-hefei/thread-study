package com.abel.thread.t2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo6 {

	public static void main(String[] args) {
		//�����̳߳أ��ж��ֿ�ѡ�̳߳�
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			threadPool.execute(new Runnable() { //ִ��һ��
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"-->�߳�ִ��......");
					
				}
			});
		}
		//ͣ����ǰ�̳߳�
		threadPool.shutdown();
	}
}
