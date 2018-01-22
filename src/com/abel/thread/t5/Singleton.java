package com.abel.thread.t5;

public class Singleton {

	private Singleton instance;
	private Singleton() {
		
	}
	
	public Singleton getInstance() {
		if(instance ==null) {
			synchronized (Singleton.class) {
				if(instance==null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
