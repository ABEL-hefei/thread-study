package com.abel.thread.ta3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo {

	private Map<String,Object> map = new HashMap<>();
	//创建一个读写锁实例
	private ReadWriteLock rw = new ReentrantReadWriteLock();
	//创建一个读锁
	private Lock r = rw.readLock();
	//创建一个写锁
	private Lock w = rw.writeLock();
	
	/**
	 * 读操作
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		r.lock();
		System.out.println(Thread.currentThread().getName() + "读操作开始执行......");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			return map.get(key);
		} finally {
			r.unlock();
			System.out.println(Thread.currentThread().getName() + "读操作执行完成......");
		}
	}
	
	/**
	 * 写操作
	 * @param key
	 * @param value
	 */
	public void put(String key,Object value) {
		try {
			w.lock();
			System.out.println(Thread.currentThread().getName() + "写操作开始执行......");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			map.put(key, value);
		} finally {
			w.unlock();
			System.out.println(Thread.currentThread().getName() + "写操作执行完成......");
		}
	}
}
