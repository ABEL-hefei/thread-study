package com.abel.thread.t2;

public class Demo1 extends Thread{

	//�Զ���Thread����
	public Demo1(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		//�жϱ�־
		while(!interrupted()) {
			System.out.println(getName()+"-->�߳�ִ����....");
		}
	}
	
	public static void main(String[] args) {
		Demo1 d1 = new Demo1("first");
		Demo1 d2 = new Demo1("second");
		
		d1.start();
		d2.start();
		/*
		 * jdk1.6֮���Ѿ����Ƽ�ʹ���ˣ����ַ���ֹͣ���߳������
		 * ������������Դ��û�б��ͷŵ�
		 */
//		d1.stop();
		//Ŀ�ľ����޸���ֹ��־
		d1.interrupt();
	}
	
}
