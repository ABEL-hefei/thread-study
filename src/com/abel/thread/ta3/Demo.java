package com.abel.thread.ta3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo {

	private Map<String,Object> map = new HashMap<>();
	//����һ����д��ʵ��
	private ReadWriteLock rw = new ReentrantReadWriteLock();
	//����һ������
	private Lock r = rw.readLock();
	//����һ��д��
	private Lock w = rw.writeLock();
	
	/**
	 * ������
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		r.lock();
		System.out.println(Thread.currentThread().getName() + "��������ʼִ��......");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			return map.get(key);
		} finally {
			r.unlock();
			System.out.println(Thread.currentThread().getName() + "������ִ�����......");
		}
	}
	
	/**
	 * д����
	 * @param key
	 * @param value
	 */
	public void put(String key,Object value) {
		try {
			w.lock();
			System.out.println(Thread.currentThread().getName() + "д������ʼִ��......");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			map.put(key, value);
		} finally {
			w.unlock();
			System.out.println(Thread.currentThread().getName() + "д����ִ�����......");
		}
	}
}
