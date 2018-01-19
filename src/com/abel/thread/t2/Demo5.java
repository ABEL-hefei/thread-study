package com.abel.thread.t2;

import java.util.Timer;
import java.util.TimerTask;

public class Demo5 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		//TimerTask是一个抽象类，实现的是runnable接口
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("执行线程任务......");
			}
		}, 0, 1000);
	}
}
