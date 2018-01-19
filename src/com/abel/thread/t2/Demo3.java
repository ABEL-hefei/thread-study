package com.abel.thread.t2;

public class Demo3 {

	public static void main(String[] args) {
//		//1)通过thread类创建匿名内部类
//		new Thread() {
//			public void run() {
//				System.out.println("线程开始执行......");
//			};
//		}.start();
//		
//		//2)通过线程任务的方式创建匿名内部类
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("线程开始执行......");
//				
//			}
//		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("实现runnable接口的run方法......");
			}
		}) {
			public void run() {
				System.out.println("执行的子类的run方法......");
			};
		}.start();
	}
}
