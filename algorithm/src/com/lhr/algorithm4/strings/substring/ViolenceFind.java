package com.lhr.algorithm4.strings.substring;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>暴力查找子字符串</h3>
 */
public class ViolenceFind {
	
	/**
	 * 暴力查找方式1：
	 * 维护两个指针,指针i跟踪文本，指针j跟踪模式
	 * 
	 * @param pat:模式(要查找的字符串)
	 * @param txt:文本字符串
	 * @return 找到匹配：返回txt匹配字符串的起始指针/未找到匹配：返回txt字符串的长度
	 */
	public static int searcha(String pat,String txt) {
		int M = pat.length();
		int N = txt.length();
		/**
		 * 从0到N-M遍历txt每个字符进行字符串匹配
		 */
		for (int i = 0; i <= N -M; i++) {
			int j;
			//进行pat的字符与txt的字符匹配(只要一个字符不匹配就退出)
			for (j = 0; j <M; j++) 
				if (txt.charAt(i+j)!=pat.charAt(j)) break;
			if (j==M) return i;//字符匹配通过了就证明找到匹配(返回txt的起始指针)
		}
		return N;//未找到匹配
	}
	
	/**
	 * 暴力查找方式2(比第一种更优：避免过多重复字符导致算法变慢)：
	 * 
	 * @param pat
	 * @param txt
	 * @return 找到匹配：返回txt匹配字符串的起始指针/未找到匹配：返回txt字符串的长度
	 */
	public static int searchb(String pat,String txt) {
		int j,M = pat.length();
		int i,N = txt.length();
		/**
		 * i指向文本中已经匹配过的字符序列的末端
		 */
		for (i = 0,j = 0; i<N && j<M; i++) {
			if (txt.charAt(i) == pat.charAt(j))j++;
			else {i-=j;j=0;}
		}
		
		if (j==M) return i-M;
		else return N;
	}
	
}
