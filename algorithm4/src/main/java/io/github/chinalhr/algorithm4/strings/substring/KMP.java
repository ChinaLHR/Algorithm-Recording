package io.github.chinalhr.algorithm4.strings.substring;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>KMP算法</h3>
 *
 *          <pre>
 * 思想：根据模式字符串在匹配失败的时候，根据模式字符串决定应该在哪个重新匹配.(设法利用这个已知信息，不要把"搜索位置"移回已经比较过的位置，继续把它向后移实现跳转)
 * 跳转表原理：对于模式串而言，其前缀字符串，有可能也是模式串中的非前缀子串，所以当目标串与模式串执行匹配的过程中可以向前一次性跳跃多个字符来提升字符串匹配的速度.
 *
 * 时间复杂度：对于任何模式和目标序列都可以在线性时间内完成匹配查找.
 *
 * 适用场景：在重复性很高的文本中查找匹配重复性很高的模式,不需要在输入中回退.
 *
 * 实现：
 * 模式指针的回退：使用dfa[txt.charAt(i)][j]记录匹配失败时模式指针j应该回滚多远(即表示下一个文本字符比较的模式字符串位置)
 * 确定调表(DFA):检查文本中的第i个字符时：
 * 匹配——>dfa[txt.charAt(i)][j]前进继续检查下一个字符
 * 非匹配——>向左移动到某个字符
 *          </pre>
 */
public class KMP {
	private String pat;
	private int[][] dfa;

	/**
	 * DFA构造：
	 * @param pat
	 */
	public KMP(String pat) {
		// 由模式字符串构造DFA
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		dfa = new int[R][M];

		dfa[pat.charAt(0)][0] = 1;
		for (int X = 0, j = 1; j < M; j++) {
			for (int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X];// 复制匹配失败情况下的值

			dfa[pat.charAt(j)][j] = j + 1;// 设置匹配成功情况下的值
			X = dfa[pat.charAt(j)][X];// 更新重启状态
		}
	}

	/**
	 * 使用两个指针： i(文本指针)，j(模式指针)，根据跳转表进行计算
	 * @param txt
	 * @return
	 */
	public int search(String txt) {
		// 在txt上模拟DFA的运行
		int i, j, N = txt.length(), M = pat.length();
		for (i = 0, j = 0; i < N && j < M; i++)
			j = dfa[txt.charAt(i)][j];
		if (j == M)
			return i - M;// 找到匹配(到达模式字符串的结尾)
		else
			return N;// 未找到匹配(到达文本字符串的结尾)
	}

}
