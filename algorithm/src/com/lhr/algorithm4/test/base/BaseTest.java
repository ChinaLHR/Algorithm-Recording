package com.lhr.algorithm4.test.base;

import org.junit.After;
import org.junit.Before;

public class BaseTest {

	private long initTime;
	private long endTime;
	public int[] randomarray = new int[100000];

	@Before
	public void testbefore() {
		for (int i = 0; i < 100000; i++) {
			randomarray[i] = (int) (Math.random() * 100000);
		}
		initTime = System.currentTimeMillis();
	}

	@After
	public void testAfter() {
		endTime = System.currentTimeMillis();
		for (int i : randomarray) {
			System.out.print(i+",");
		}
		System.out.println();
		System.out.println("算法运行时间：" + (endTime - initTime) + "ns");
	}
}
