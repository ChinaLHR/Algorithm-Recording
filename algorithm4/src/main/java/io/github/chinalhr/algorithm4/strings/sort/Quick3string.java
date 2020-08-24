package io.github.chinalhr.algorithm4.strings.sort;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>三向字符串快速排序</h3>
 * <pre>
 * 思想：MSD+快排
 * 实现：改进高位优先的字符串排序，根据键的首字母进行三向排序，将数组切分为三部分，仅在中间子数组中的下一个字符继续递归排序
 * </pre>
 */
public class Quick3string {

	private static int charAt(String s,int d) {
		if (d<s.length())
			return s.charAt(d);
		else return -1;
	}

	public static void sort(String[] a) {
		//根据首字母进行三向切分
		sort(a,0,a.length-1,0);
	}


	private static void sort(String[] a,int lo,int hi,int d) {
		if (hi<=lo)return;
		int lt = lo,gt = hi;
		int v = charAt(a[lo], d);
		int i = lo + 1;
		while (i<=gt) {
			int t = charAt(a[i], d);
			if (t<v) exch(a, lt++, i++);
			else if (t>v) exch(a, i, gt--);
			else i++;
		}
		  //递归将三个子数组排序
		  sort(a, lo, lt-1, d);
	      if (v >= 0) sort(a, lt, gt, d+1);
	      sort(a, gt+1, hi, d);
	}

	 private static void exch(String[] a, int i, int j) {
	        String temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }
}
