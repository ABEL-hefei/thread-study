package com.abel.thread.t2;

import java.util.Timer;
import java.util.TimerTask;

public class Demo5 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		//TimerTask��һ�������࣬ʵ�ֵ���runnable�ӿ�
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("ִ���߳�����......");
			}
		}, 0, 1000);
	}
}
