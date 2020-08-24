package io.github.chinalhr.sword_finger_offer;

/**
 *
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>数组中出现次数超过一半的数字</h3>
 * <pre>
 * 题目： 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *
 * 实现原理：通过数组的特性得知，数组排序后位于数组中间的数字（中位数）一定是数组中出现次数超过数组长度一半的
 *
 * 解法1：基于快速排序的查找方法，先进性快速排序，然后根据切点的下标进行左右选择，直到找到中位数  ——>O(n)
 * 解法2：从数组的角度考虑，要查找的数字数量比数组中的其他值都要多，可以在遍历数组的时候记录数值     ——>O(n)
 * </pre>
 */
public class N29_FindFalfNum {

	public static void main(String[] args) {
		int[] arr={1,2,3,2,2,2,5,4,2};
		System.out.println(findNum(arr));
	}

	/**
	 * 基于解法二的实现：利用要查找的值的数量比数组中的其他值加起来还要多,在遍历数组的时候，记录当前值与数量，如果遇到不相等的count--，
	 * 相等count++，如果count==0，替换result，最后的result一定是数量最多的数
	 * @param arr
	 * @return
	 */
	private static Integer findNum(int[] arr) {
		if(arr==null) return null;

		int result = arr[0];//记录目标数
		int count = 1;//记录次数

		for (int i = 0; i < arr.length; i++) {
			if(count==0) {
				result = arr[i];
				count=1;
			}
			else if(arr[i] == result) {
				count++;
			}
			else {
				count--;
			}
		}

		return result;
	}
}
