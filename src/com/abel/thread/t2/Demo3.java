package com.abel.thread.t2;

public class Demo3 {

	public static void main(String[] args) {
//		//1)ͨ��thread�ഴ�������ڲ���
//		new Thread() {
//			public void run() {
//				System.out.println("�߳̿�ʼִ��......");
//			};
//		}.start();
//		
//		//2)ͨ���߳�����ķ�ʽ���������ڲ���
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("�߳̿�ʼִ��......");
//				
//			}
//		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("ʵ��runnable�ӿڵ�run����......");
			}
		}) {
			public void run() {
				System.out.println("ִ�е������run����......");
			};
		}.start();
	}
}
