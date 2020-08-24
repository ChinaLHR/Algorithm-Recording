package io.github.chinalhr.algorithm4.test;

public class Practice {
	private static int[] aux;


	public static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
