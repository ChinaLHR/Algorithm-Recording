package com.lhr.sword_offer;

import java.util.LinkedHashMap;

/**
 * 
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>第一个只出现一次的字符</h3>
 * <pre>
 * 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'
 * 思路一：当访问到某个字符就和后面的字符比较，如果没有重复的字符，就找到只出现一次的字符	[复杂度O(n)——>O(n2)]
 * 思路二：使用一个容器存放每个字符出现的次数，把字符映射成数字(哈希表)，只需要扫描两次，第一次用于构建容器哈希表，第二次用于获取次数为1的字符 
 * [复杂度O(n):以空间换时间]
 * </pre>
 */
public class N35_OneFirstAppear {
	
	public static void main(String[] args) {
		System.out.println(firstOnceNumber("abaccdeff"));
	}
	
	private static Character firstOnceNumber(String str) {
		if(str==null) return null;
		char[] strChar = str.toCharArray();
		//容器，哈希表
		LinkedHashMap<Character, Integer> hash = new LinkedHashMap<>();
		
		//第一次遍历，构建记录字符出现次数的哈希表
		for (char item : strChar) {
			if(hash.containsKey(item))
				hash.put(item, hash.get(item)+1);
			else 
				hash.put(item, 1);
		}
		
		//第二次遍历，根据key获取出现次数为1的字符
		for (char key : hash.keySet()) {
			if(hash.get(key)==1)
				return key;
		}
		
		return null;
	}
}
