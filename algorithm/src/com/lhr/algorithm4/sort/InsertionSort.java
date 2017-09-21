package com.lhr.algorithm4.sort;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h2>插入排序</h2>
 * <pre>
 * 实现：每步将指针指到的数据插入到前面已经完成排序的序列中的合适位置(每次只交换两个元素)，当指针完成最后一个数据的插入时，所有数据都是有序的。
 * 
 * 缺陷：对于大规模乱序数组排序很慢，因为它只会比较相邻的元素，因此元素只能一点一点从数组的一端移动到另一端。
 * </pre>
 */
public class InsertionSort {
	
	public static void sort(int[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			//判断指针取出的数值是否小于前面一个已排序的数,如果是则进行交换
			for (int j = i; j >0 && a[j]<a[j-1]; j--) {
				exch(a, j, j-1);
			}
		}
	}
	
	private static void exch(int[] a,int i ,int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
}
