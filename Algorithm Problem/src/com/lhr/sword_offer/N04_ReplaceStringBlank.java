package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>替换空格符</h3>
 * <pre>
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入"We are happy"，则输出"We%20are%20happy"
 * </pre>
 */
public class N04_ReplaceStringBlank {
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 实现思路：先遍历一遍数组统计空格数并计算出替换之后的字符串总长度(每一个空格总长度+2)，再进行数组字符转移，遇到空格直接转换为%20
	 * @param charArray
	 * @return
	 */
	private static String change(char[] charArray) {
		int n = charArray.length;
		int count = 0;
		
		for (int i = 0; i < charArray.length; i++) {
			if(charArray[i]==' ') {
				count++;
			}
		}
		if(count==0) return null;
		char[] temp = new char[n+2*count];
		
		int j = n+2*count-1;//替换数组的指针
		int i = n-1;//原数组的指针 
		//从右边开始向左边替换
		while(i>=0) {
			if(charArray[i]==' ') {
				temp[j] = '0';
				temp[j-1] = '2';
				temp[j-2] = '%';
				j = j-3;
			}else {
				temp[j] = charArray[i];
				j--;
			}
			i--;
		}
		return new String(temp);
	}
	
}
