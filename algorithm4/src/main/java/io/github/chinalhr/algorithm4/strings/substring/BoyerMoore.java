package io.github.chinalhr.algorithm4.strings.substring;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>Boyer-Moore算法</h3>
 * <pre>
 * 思想：启发式的处理不匹配字符，通过从尾部开始匹配，通过匹配的错误字符确定模式需要向右跳转的距离，有时候可以直接跳过整个模式，效率高
 *
 * 实现：
 * 从模式尾部开始匹配(优势：因为如果尾部字符不匹配，那么只要一次比较，就可以知道前面肯定不是要找的结果)
 * 使用right[] 记录字符匹配失败时应该向右跳多远(根据匹配情况)
 * 遍历文本字符串，根据right与匹配情况取得模式匹配的指针
 *
 * 子字符串查找匹配失败的两种情况：
 * ①匹配失败的字符串不存在模式的字符串中，模式字符串向右移动j+1个位置
 * ②造成匹配失败的字符存在于模式的字符串中，使用right[]将模式字符串和文本对齐（模式字符串x与文本字符串x对齐位置)
 * </pre>
 */
public class BoyerMoore {

	private int[] right;
	private String pat;

	public BoyerMoore(String pat) {
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		right = new int[R];

		//不包含在模式字符串中的字符值为-1
		for (int c = 0; c < R; c++)
			right[c] = -1;
		//包含在模式字符串中的字符值为它在其中出现的最右值
		for (int j= 0; j < M; j++)
			right[pat.charAt(j)] = j;
	}

	public int search(String txt) {
		//在txt中查找模式字符串
		int N = txt.length();
		int M = pat.length();
		int skip;
		//i:文本指针  j:模式指针
		for (int i = 0; i < N-M; i+=skip) {
			//模式字符串和文本在位置i匹配吗?
			skip = 0;
			for (int j = M-1; j >0 ; j--)
				if (pat.charAt(j)!=txt.charAt(i+j)) {
					skip = j - right[txt.charAt(i+j)];
					if (skip < 1 ) skip = 1;
					break;
				}
				if (skip == 0) return i;//找到匹配
			}
			return N;//未找到匹配
	}
}
