package com.abel.thread.t2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo6 {

	public static void main(String[] args) {
		//创建线程池，有多种可选线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			threadPool.execute(new Runnable() { //执行一次
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"-->线程执行......");
					
				}
			});
		}
		//停掉当前线程池
		threadPool.shutdown();
	}
}
