package io.github.chinalhr.leetcode.array;

import java.util.HashMap;

/**
 * @Author lhr
 * @Date 2021/6/21
 * @Description:: 题目：1. 两数之和 easy
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * <p>
 * 示例：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * </p>
 */
public class SumOfTwoNum {

    public int[] twoSum(int[] nums, int target) {
        //result
        int[] result = new int[2];
        //key array_val； value array_idx
        HashMap<Integer, Integer> arrayMap = new HashMap<>();
        for (int i = 0; i <= nums.length-1; i++) {
            arrayMap.put(nums[i], i);
        }

        for (int i = 0; i <= nums.length-1; i++) {
            int otherNum = target - nums[i];
            if (arrayMap.get(otherNum)!=null&&arrayMap.get(otherNum)!=i){
                result[0] = i;
                result[1] = arrayMap.get(otherNum);
                break;
            }
        }
        return result;
    }
}
