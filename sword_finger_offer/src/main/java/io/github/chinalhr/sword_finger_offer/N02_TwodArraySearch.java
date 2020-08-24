package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>二维数组查找</h3>
 * <pre>
 * 题目：二维数组每一行左到右递增顺序排序,每一列上到下递增排序，输入一个数，在二维数组中判断是否存在该树
 * </pre>
 */
public class N02_TwodArraySearch {

	public static void main(String[] args) {
		int[][] arr={{1,2,8,9},
					 {2,4,9,12},
					 {4,7,10,13},
					 {6,8,11,15}};

		System.out.println(search(arr,7));
	}

	/**
	 * 进行查找
	 * 查找方式：对于a[i][j]从最右点开始向左查找，如果大于查找数j--,如果小于查找数i++
	 * 目的：减少字符移动次数
	 * 复杂度：O（n）
	 * @param arr
	 * @param value
	 * @return
	 */
	private static boolean search(int[][] arr,int value) {
		int a = arr[0].length;
		int b = arr.length;
		int i = 0;
		int j = a - 1;

		while(i<=b-1&&j>=0) {
			if(arr[i][j]==value) {
				return true;
			}
			if(arr[i][j]>value) {
				j--;
			}else {
				i++;
			}
		}
		return false;
	}
}
