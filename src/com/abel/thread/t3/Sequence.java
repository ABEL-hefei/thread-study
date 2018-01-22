package com.abel.thread.t3;

public class Sequence {

	private static int value;
	
	//synchronized 同步
	/*
	 *  synchronized放在普通实例方法上，内置锁就是当前类的实例
	 * @return
	 */
	public synchronized int getNext() {
		return value++;
	}
	
	/*
	 * 修饰静态方法，内置锁就是当前的Class字节码对象
	 * Sequence.class
	 */
	public static synchronized int getPrevious() {
		return value--;
	}
	
	/*
	 * 修饰代码块
	 */
	public int ss () {
		
		synchronized (Sequence.class) {
//			if(1) {
//				
//			}
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Sequence s = new Sequence();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName() + " " +s.getNext() );
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName() + " " +s.getNext() );
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName() + " " +s.getNext() );
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
