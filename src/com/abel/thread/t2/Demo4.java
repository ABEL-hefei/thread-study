package com.abel.thread.t2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//参数使用泛型，以Integer为例
public class Demo4 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("正在执行方法体......");
		Thread.sleep(3000);
		return 100;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Demo4 d = new Demo4();
		//FutureTask是继承Runnable，是对Runnable的封装，所以需要包装到Thread类中执行
		FutureTask<Integer> task = new FutureTask<>(d);
		
		//包装到Thread类中进行执行
		Thread t = new Thread(task);
		t.start();
		
		System.out.println("执行别的任务....");
		//获取线程执行结果
		Integer i = task.get();
		System.out.println("线程执行结果是："+i);
	}
}
