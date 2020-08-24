package io.github.chinalhr.algorithm4.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.chinalhr.algorithm4.union.QuickFind;
import io.github.chinalhr.algorithm4.union.QuickUnion;
import io.github.chinalhr.algorithm4.union.QuickUnionWeight;

public class UnionTest {

	@Test
	public void testQuickFind() {
		QuickFind uFind = new QuickFind(10);
		Assert.assertFalse(uFind.connected(6, 8));
		uFind.union(6, 8);
		Assert.assertTrue(uFind.connected(6, 8));
		uFind.union(6, 9);
		Assert.assertEquals(uFind.count(), 8);
	}

	@Test
	public void testQuickUnion() {
		QuickUnion union = new QuickUnion(10);
		Assert.assertFalse(union.connected(6, 8));
		union.union(6, 8);
		Assert.assertTrue(union.connected(6, 8));
		union.union(6, 9);
		Assert.assertEquals(union.count(), 8);
	}

	@Test
	public void testQuickUnionWeight() {
		QuickUnionWeight union = new QuickUnionWeight(10);
		Assert.assertFalse(union.connected(6, 8));
		union.union(6, 8);
		Assert.assertTrue(union.connected(6, 8));
		union.union(6, 9);
		Assert.assertEquals(union.count(), 8);

	}

	@Test
	public void hashTest() {
		System.out.println(1<<4);
	}

}
