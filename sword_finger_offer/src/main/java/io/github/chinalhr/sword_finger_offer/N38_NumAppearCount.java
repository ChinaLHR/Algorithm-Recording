package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>数字在排序数组中出现的次数</h3>
 *
 *          <pre>
 * 题目： 统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4
 * 思路1：从头到尾扫描数组，计算次数，复杂度尾O(n)
 * 思路2：和二分查找结合,对数组进行二分查找，如果命中了目标数之后，向前与向后查找第一个与最后一个目标[复杂度O(logn)]
 *          </pre>
 */
public class N38_NumAppearCount {

	public static void main(String[] args) {
		int[] array={1,2,3,3,3,3,4,5};
		System.out.println(getNumberOfK(array, 3));
	}

	/**
	 * 获取k在array中出现的次数
	 *
	 * @param array
	 * @param k
	 * @return
	 */
	private static int getNumberOfK(int[] array, int k) {
		int num = 0;
		if(array!=null) {
			int first = getFirstK(array, k, 0, array.length-1);
			int last = getLastK(array, k, 0, array.length-1);

			if(first>-1&&last>-1)
				num = last-first+1;
		}
		return num;
	}

	/**
	 * 基于二分查找：获取array中最后一个k出现的位置
	 *
	 * @param array
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	private static int getLastK(int[] array, int k, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		int midData = array[mid];
		if (midData == k) {
			if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1) {

				return mid;
			} else {
				start = mid + 1;
			}
		}
		else if(midData<k)
			start=mid+1;
		else
			end=mid-1;
		return getLastK(array, k, start, end);
	}

	/**
	 * 基于二分查找：获取array中第一个k出现的位置
	 * @param array
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	private static int getFirstK(int[] array, int k, int start, int end) {
		if(start>end)
			return -1;
		int mid=(start+end)/2;
		int midData=array[mid];
		if(midData==k){
			if((mid>0&&array[mid-1]!=k)||mid==0){
				return mid;
			}
			else{
				end=mid-1;
			}
		}
		else if(midData>k)
			end=mid-1;
		else
			start=mid+1;

		return getFirstK(array, k, start, end);
	}
}
