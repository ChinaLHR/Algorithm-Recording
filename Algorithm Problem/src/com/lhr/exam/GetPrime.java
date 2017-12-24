package com.lhr.exam;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>求100之内的素数(质数)</h3>
 * <pre>
 * 关于质数：质数（prime number）又称素数，有无限个。质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数的数称为质数。
 * </pre>
 */
public class GetPrime {
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			isPrim(i);
		}
	}
	
	private static void isPrim(int n) {
		if(n<=1) return;
		
		for (int i = 2; i*i <= n; i++) {
			if(n%i==0) return;
		}
		System.out.println(n+",");
	}
}
