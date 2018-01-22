package com.abel.thread.ta4;

public class Main {

	private int value;
	private MyLock lock = new MyLock();
	public int getNext() {
		lock.lock();
		try {
			Thread.sleep(100);
			value++;
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}finally {
			lock.unlock();
		}
		return value ;
	}
	
	private void a() {
		lock.lock();
		System.out.println("a");
		b();
		lock.unlock();
	}
	
	public void b() {
		lock.lock();
		System.out.println("b");
		lock.unlock();
	}
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		//≤‚ ‘À¯µƒ÷ÿ»Î
		new Thread(new Runnable() {
			@Override
			public void run() {
				main.a();
			}
		}).start();
		
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println(Thread.currentThread().getName() + " " +main.getNext());
//				}
//			}
//		}).start();
//		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println(Thread.currentThread().getName() + " " +main.getNext());
//				}
//			}
//		}).start();
//		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println(Thread.currentThread().getName() + " " +main.getNext());
//				}
//			}
//		}).start();
	}
}
