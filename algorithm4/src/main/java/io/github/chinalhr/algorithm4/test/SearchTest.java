package io.github.chinalhr.algorithm4.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.chinalhr.algorithm4.search.LinearProbingHashST;

public class SearchTest{

	@Test
	public void TestBinarySearchST() {
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>();

		st.put("B", 2);
		st.put("C", 3);
		st.put("D", 4);
		st.put("E", 5);
		st.put("A", 1);
		Assert.assertTrue(st.get("D")==4);
		st.delete("A");
		Assert.assertNull(st.get("A"));
	}

}
