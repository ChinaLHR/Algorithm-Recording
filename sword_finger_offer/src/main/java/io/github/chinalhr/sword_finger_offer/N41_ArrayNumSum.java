package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <pre>
 * 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可
 * 例如：{1，2，4，7，11，15} 和 数字15，由于4+11=15，所以输出 4 11
 *
 * 思路1：遍历数组，先固定一个数，再遍历数组进行二次筛选，如果相加等于s，则输出两个数 		[复杂度O(n2)]
 * 思路2：利用元素已排序的特性，再数组中选择两个数，根据大于s或者小于s决定上移角标或者下移角标（初始指针为角标1——>0与角标2——>length-1）
 * 大于则角标2-- 小于则角标1++
 * [复杂度O(n)]
 *
 * </pre>
 */
public class N41_ArrayNumSum {

	public static void main(String[] args) {
		int[] data = {1,2,4,7,11,15};

		System.out.println(findNumberWithSum(data, 15));
	}

	private static boolean findNumberWithSum(int[] data,int sum) {
		boolean found = false;
		if(data==null) return found;
		int num1 = 0;
		int num2 = 0;
		int start = 0;
		int end = data.length-1;
		while(start<end) {
			int curSum = data[start] + data[end];
			if(curSum==sum) {
				num1 = data[start];
				num2 = data[end];
				found = true;
				break;
			}else if(curSum>sum){
				end--;
			}else {
				start++;
			}
		}
		System.out.println(num1);
		System.out.println(num2);

		return found;
	}
}
