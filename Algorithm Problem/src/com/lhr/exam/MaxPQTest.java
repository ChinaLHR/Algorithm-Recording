package com.lhr.exam;

import org.junit.Test;

import com.lhr.sword_offer.MyMaxPQ;

public class MaxPQTest {
	
	@Test
	public void testPQ() {
		MyMaxPQ<Integer> maxPQ = new MyMaxPQ<>(4);
		maxPQ.insert(1);
		maxPQ.insert(6);
		maxPQ.insert(5);
		int max = maxPQ.delMax();
		System.out.println(max);
		maxPQ.insert(10);
	}
	
}
