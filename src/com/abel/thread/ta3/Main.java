package com.abel.thread.ta3;

public class Main {
	public static void main(String[] args) {
		Demo d = new Demo();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				d.put("key1","value1");
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(d.get("key1"));
			}
		}).start();
		
		
//		d.put("key1", "value1");
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				d.get("key1");
//			}
//		}).start();
//		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				d.get("key1");
//			}
//		}).start();
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				d.get("key1");
//			}
//		}).start();
		
		
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				d.put("key1", "value1");
//			}
//		}).start();
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				d.put("key2", "value1");
//			}
//		}).start();
//		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				d.put("key3", "value1");
//			}
//		}).start();
		
	}
}
