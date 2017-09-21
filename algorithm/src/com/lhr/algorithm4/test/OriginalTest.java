package com.lhr.algorithm4.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lhr.algorithm4.sort.MaxPQ;
import com.lhr.algorithm4.sort.MaxPQSort;

public class OriginalTest {

	@Test
	public void testMaxPQ() {
		int[] a = new int[] {8,11,5,66,99,4};
		MaxPQSort.sort(a);
	}

}
