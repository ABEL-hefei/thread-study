package com.abel.thread.t3;

public class Sequence {

	private static int value;
	
	//synchronized ͬ��
	/*
	 *  synchronized������ͨʵ�������ϣ����������ǵ�ǰ���ʵ��
	 * @return
	 */
	public synchronized int getNext() {
		return value++;
	}
	
	/*
	 * ���ξ�̬���������������ǵ�ǰ��Class�ֽ������
	 * Sequence.class
	 */
	public static synchronized int getPrevious() {
		return value--;
	}
	
	/*
	 * ���δ����
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
