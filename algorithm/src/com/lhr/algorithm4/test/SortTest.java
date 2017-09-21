package com.lhr.algorithm4.test;


import org.junit.Assert;
import org.junit.Test;

import com.lhr.algorithm4.sort.BubbleSort;
import com.lhr.algorithm4.sort.BucketSort;
import com.lhr.algorithm4.sort.InsertionSort;
import com.lhr.algorithm4.sort.MaxPQ;
import com.lhr.algorithm4.sort.MaxPQSort;
import com.lhr.algorithm4.sort.MergeSort;
import com.lhr.algorithm4.sort.QuickSort;
import com.lhr.algorithm4.sort.Quick3waySort;
import com.lhr.algorithm4.sort.SelectionSort;
import com.lhr.algorithm4.sort.ShellSort;
import com.lhr.algorithm4.test.base.BaseTest;

import javafx.scene.transform.Shear;

public class SortTest extends BaseTest {

	@Test
	public void testPractice() {
	}
	
	@Test
	public void testSort() {
	
	BubbleSort.sort(randomarray);
	}
	
	
}
