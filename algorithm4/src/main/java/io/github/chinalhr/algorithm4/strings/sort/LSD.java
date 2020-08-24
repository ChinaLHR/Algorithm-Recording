package io.github.chinalhr.algorithm4.strings.sort;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>低位优先的字符串排序</h3>
 * <pre>
 * 实现： 字符串长度为W.从右向左对每个为位置的字符作为键进行键索引计数法排序
 * 证明：如果两个字符串，若还没被排序过的键相同,键的不同之处仅限于被排序的字符,所以两个将一直保持有序。若还没被排序过的键不同，那么将使用键索引计数法纠正两个字符串的顺序。
 * 时间复杂度：O(n) 线性
 * 缺陷：排序的字符串长度是固定的
 *
 * 阈值：R对应ASCII(256)，或者UNICICODE(65536)
 * </pre>
 */
public class LSD {

	/**
	 *
	 * @param a 需要排序的字符串数组
	 * @param W 字符串的长度
	 */
	public static void sort(String[] a,int W) {
		//通过前W个字符将a[]排序
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];

		for (int d = W - 1; d >= 0; d--) {
			// 根据第d个字符用键索引计数法排序
			int[] count = new int[R + 1];
			// 计算出现的频率
			for (int i = 0; i < N; i++)
				count[a[i].charAt(d) + 1]++;
			// 将频率转换为索引
			for (int r = 0; r < R; r++)
				count[r + 1] += count[r];
			 // 将元素分类[产生排序结果]
			for (int i = 0; i < N; i++)
				aux[count[a[i].charAt(d)]++] = a[i];
			// 回写
			for (int i = 0; i < N; i++)
				a[i] = aux[i];
		}
	}

}
