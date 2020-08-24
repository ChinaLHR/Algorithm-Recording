package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>顺时针打印矩阵</h3>
 * <pre>
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *
 * </pre>
 */
public class N20_PrintMatrix {

	public static void main(String[] args) {
		int[][] a = create(5, 5);
		print(a);
		System.out.println("===进行顺时针打印===");
		clockWisePrint(a, 0, 4);

	}

	/**
	 * 顺时针打印矩阵(注意每一步的前提条件)
	 * @param a
	 * @param i 列
	 * @param j 行
	 */
	private static void clockWisePrint(int[][] a,int i, int j) {
		if(j<i)
			return;

		//顺时针打印的终点 return a[0][0] a[1][1] ...
		if(j==i){
			System.out.print(a[i][j]+" ");
			return;
		}

		//从左到右打印一行
		int y=i;
		while(y<=j){
			System.out.print(a[i][y]+" ");
			y++;
		}

		//从上到下打印一行
		y=i+1;
		while(y<=j){
			System.out.print(a[y][j]+" ");
			y++;
		}

		//从下到上打印一行
		y=j-1;
		while(y>=i){
			System.out.print(a[j][y]+" ");
			y--;
		}

		//从右到左打印一行
		y=j-1;
		while(y>=i+1){
			System.out.print(a[y][i]+" ");
			y--;
		}

		//递归调用顺时针打印整个矩阵
		clockWisePrint(a, i+1, j-1);
	}

	/**
	 * 打印一个矩阵
	 * @param a
	 */
	private static void print(int[][] a) {
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * 创建一个矩阵
	 * @param row
	 * @param line
	 * @return
	 */
	public static int[][] create(int row, int line) {
		int[][] a=new int[row][line];
		int num=1;
		for(int i=0;i<row;i++){
			for(int j=0;j<line;j++){
				a[i][j]=num++;
			}
		}
		return a;
	}
}
