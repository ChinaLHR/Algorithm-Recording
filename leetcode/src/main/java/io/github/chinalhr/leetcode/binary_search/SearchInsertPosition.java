package io.github.chinalhr.leetcode.binary_search;

/**
 * @Author lhr
 * @Date 2020/10/11
 * @Description: 题目：35. 搜索插入位置 easy
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 实现：
 * 1. 插入位置有可能在数组的末尾（题目中的示例 3），需要单独判断。如果在数组的末尾，插入位置的下标就是数组的长度；
 * 2. 根据示例和暴力解法的分析，插入位置的下标是 大于等于 target 的第 1 个元素的位置。
 *
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 特判
        if (nums[len - 1] < target) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 严格小于 target 的元素一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }
        return left;
    }

}
