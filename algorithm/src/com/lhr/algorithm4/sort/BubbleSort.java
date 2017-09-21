package com.lhr.algorithm4.sort;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>冒泡排序</h3>
 * 
 *          <pre>
 * 冒泡排序的基本思想是：每次比较两个相邻的元素，如果它们的顺序错误就把它们交换过来。
 * 
 * 冒泡VS插入：插入利用大量已经排好序的元素的额外信息，冒泡利用上一次扫描没有发生交换的额外条件。
 * 
 * 实现：从0角标开始遍历,每次比较交换相邻的两个元素,当角标达到N，则数组是有序的。
 *          </pre>
 */
public class BubbleSort {

	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			boolean flag = true;// 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					exch(a, j, j + 1);
					flag = false;
				}
			}
			
			//一次交换都没有发生，说明剩下的序列已经是有序的,终止遍历
			if (flag) {
				break;
			}
		}
	}

	private static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
