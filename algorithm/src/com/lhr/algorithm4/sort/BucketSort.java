package com.lhr.algorithm4.sort;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>桶排序——利用空间换时间</h3>
 * <pre>
 * 实现：创建容量为MAX的桶数组r,遍历需要排序的数组a,将数组a的值，作为"桶数组r"的下标。当a中数据被读取时，就将桶的值加1。a[3]=5，则将r[5]的值+1。
 *    最后遍历桶数组，将桶中的数据按顺序提取到数组a中，数组a有序。
 * 时间复杂度：O（n） 
 * 缺陷：如果桶的数量非常多，对空间的消耗是巨大的
 * 思想：空间换时间
 * </pre>
 */
public class BucketSort {

	public static void sort(int[] a, int max) {
		int[] buckets;

		if (a == null || max < 1)
			return;

		// 创建一个容量为max的数组buckets，并且将buckets中的所有数据都初始化为0
		buckets = new int[max];

		// 1.计数
		for (int i = 0; i < a.length; i++)
			buckets[a[i]]++;

		// 2. 排序
		for (int i = 0,j = 0; i < max; i++) {
			while((buckets[i]--)>0)
				a[j++] = i;
		}
		
		buckets = null;
	}

}
