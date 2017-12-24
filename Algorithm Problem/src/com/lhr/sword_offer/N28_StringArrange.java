package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>字符串的排列</h3>
 * 
 *          <pre>
 * 输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc， 则打印出由字符串a、b、c所能
 * 排列出来的所有字符串abc、acb、bac、bca、cab和cba
 *          </pre>
 */
public class N28_StringArrange {

	public static void main(String[] args) {
		myprint("abc");
	}
	
	/**
	 * 实现：
	 * 一：首先求出所有可能出现在第一位置的字符,即把第一个字符和后面的所有字符交换
	 * 二：然后将后面的字符也进行一处理(将后面字符的第一个字符与后面的后面字符进行交换)，递归下去，求出所有的字符排列
	 * @param str
	 */
	private static void myprint(String str) {
		if (str == null)
			return;
		char[] chs = str.toCharArray();
		mypaint(chs, 0);
	}
	
	
	private static void mypaint(char[] str, int i) {
		if (i >= str.length)
			return;

		if (i == str.length - 1) {
			System.out.println(String.valueOf(str));
		} else {
			//交换字符后递归调用
			for (int j = 0; j < str.length; j++) {
				char temp = str[j];
				str[j] = str[i];
				str[i] = temp;

				mypaint(str, i + 1);

				temp = str[j];
				str[j] = str[i];
				str[i] = temp;
			}
		}

	}
}
