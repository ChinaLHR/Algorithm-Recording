package com.lhr.algorithm4.strings.sort;

import edu.princeton.cs.algs4.Insertion;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>高位优先的字符串排序</h3>
 * <pre>
 * 实现：
 * ①首先使用键索引计数法将所有字符串按照首字母排序②然后（递归）将每个首字母对应的子数组排序。
 * 会将数组切分为能够独立排序的子数组完成排序，切分为每个首字母得到一个子数组。
 * 
 * 缺陷：对大型小数组于大量相同元素的排序会很慢，需要额外的空间,含有大量等值键会大大影响运算速度
 * 优势：可适用于长度不一的字符串
 * </pre>
 */
public class MSD {
	private static int R = 256;//基数
	private static final int M = 15;//小数组的切分值(阈值)
	private static String[] aux;//数据分类的辅助数组
	
	private static int charAt(String s,int d) {
		if (d<s.length()) 
			return s.charAt(d);
		else
			return -1;
	}
	
	public static void sort(String[] a) {
		int N = a.length;
		aux = new String[N];
		/**
		 * ①先对首字母进行排序
		 */
		sort(a, 0, N - 1, 0);
	}
	
	private static void sort(String[] a, int lo, int hi, int d) {
		//以第d个字符串为键将a[lo]至a[hi]排序
		if (hi<=lo+M) {
			Insertion.sort(a,lo,hi);
			return;
		}
		int[] count = new int[R + 2]; 
		
		// 计算频率
		for (int i = lo; i <= hi; i++)
			count[charAt(a[i], d) + 2]++;//此处+2是因为charAt会返回-1，为了保持数组角标不越界
		
		// 将频率转换为索引
		for (int r = 0; r < R + 1; r++) 
			count[r + 1] += count[r];
		
		// 数据分类
		for (int i = lo; i <= hi; i++) 
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		
		// 回写
		for (int i = lo; i <= hi; i++) 
			a[i] = aux[i - lo];
		
		/**
		 * ②递归将子数组进行排序
		 */
		for (int r = 0; r < R; r++)
			sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
	}
}
