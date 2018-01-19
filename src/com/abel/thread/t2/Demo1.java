package com.abel.thread.t2;

public class Demo1 extends Thread{

	//自定义Thread名称
	public Demo1(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		//判断标志
		while(!interrupted()) {
			System.out.println(getName()+"-->线程执行了....");
		}
	}
	
	public static void main(String[] args) {
		Demo1 d1 = new Demo1("first");
		Demo1 d2 = new Demo1("second");
		
		d1.start();
		d2.start();
		/*
		 * jdk1.6之后已经不推荐使用了，这种方法停止，线程所获得
		 * 的锁和其他资源都没有被释放掉
		 */
//		d1.stop();
		//目的就是修改终止标志
		d1.interrupt();
	}
	
}
