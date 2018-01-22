package com.abel.thread.t2;

import java.util.Arrays;
import java.util.List;

public class Demo7 {
	public int add(List<Integer> values) {
		values.parallelStream().forEach(System.out :: println);
		//parallelStream�Ǹ����е�
		return values.parallelStream().mapToInt(i -> i).sum();
	}
	
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(10,20,30,40);
		int sum = new Demo7().add(values);
		System.out.println("�������ǣ�"+sum);
	}
}
