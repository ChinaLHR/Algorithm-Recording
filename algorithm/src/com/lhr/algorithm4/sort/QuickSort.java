package com.lhr.algorithm4.sort;
/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * 
 * <h3>快速排序</h3>
 * <pre>
 * 思想：分治
 * 优势：①内循环小，归并与希尔排序比快速排序慢就是因为他们在内循环中移动数据  ②比较次数少
 * 缺陷:切分不平衡会导致排序效率的底下
 * 实现：对数据进行切分，再对切点的左右两边进行切分，依次往复，直至hi<=lo,此时整个数组都是有序的。
 * 改进：
 * <ul>
 * <li>①在小数组时切换到插入排序（插入排序在小数组时的效率很高）</li>
 * <li>②三取样切分：切分时使用使用三个子数组的中文数切分</li>
 * <li>③三向切分：将数组切分为三部分：大于，小于，等于</li>
 * </ul>
 * </pre>
 */
public class QuickSort {
	
	public static void sort(int[] a) {
		sort(a,0,a.length-1);
	}
	
	public static void sort(int[] a,int lo,int hi) {
		if (hi<=lo) return;
		int j = partition(a, lo, hi);//切分
		sort(a,lo,j-1);//将左半部分a[lo...j-1]排序
		sort(a,j+1,hi);//将右半部分a[j+1...hi]排序
	}
	/**
	 * <pre>
	 * 切分：将数组切分为a[lo..i-1],a[i],a[i+1..hi]，左边小于切分元素，右边大于切分元素
	 * 过程：选取a[lo]元素，由左向右扫描大于等于它的元素，再由右向左扫描小于等于它的元素，交换位置指针相遇a[lo]与指针元素交换
	 * </pre>
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int partition(int[] a, int lo, int hi) {
		int i = lo,j = hi+1;//左右扫描指针
		int v = a[lo];//切分的元素
		while(true) {
			//扫描左右，检查扫描是否结束并交换元素
			while(a[++i]<v) if (i==hi) break;//向右扫描，i==hi停止
			while(a[--j]>v) if (j==lo) break; //向左扫描，j==lo停止
			if (i>=j) break;//此时指针相遇，跳出循环
			exch(a, i, j);
		}
		exch(a, lo, j);//将v= a[j]放入正确的位置
		return j;
	}
	
	private static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i]=a[j];
		a[j] = t;
	}
	
}
