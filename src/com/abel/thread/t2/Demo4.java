package com.abel.thread.t2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//����ʹ�÷��ͣ���IntegerΪ��
public class Demo4 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("����ִ�з�����......");
		Thread.sleep(3000);
		return 100;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Demo4 d = new Demo4();
		//FutureTask�Ǽ̳�Runnable���Ƕ�Runnable�ķ�װ��������Ҫ��װ��Thread����ִ��
		FutureTask<Integer> task = new FutureTask<>(d);
		
		//��װ��Thread���н���ִ��
		Thread t = new Thread(task);
		t.start();
		
		System.out.println("ִ�б������....");
		//��ȡ�߳�ִ�н��
		Integer i = task.get();
		System.out.println("�߳�ִ�н���ǣ�"+i);
	}
}
