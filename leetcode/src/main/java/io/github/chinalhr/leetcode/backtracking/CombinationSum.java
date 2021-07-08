package io.github.chinalhr.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lhr
 * @Date 2021/7/7
 * @Description: 题目.39. 组合总和 medium
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 实现： 回溯
 * 1. 回溯求解 -> 结束条件 - 选择决策 - 进入下一层决策 - 取消选择回溯
 * 2. 去重 -> 决策树起点，每次从当前begin开始
 * </p>
 */
public class CombinationSum {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, new ArrayList<>(), target, 0);
        return result;
    }

    private void backTrack(int[] candidates, List<Integer> track, int target, int begin) {
        //结束条件
        int sum = track.stream().mapToInt(i -> i).sum();
        if (sum == target) {
            result.add(new ArrayList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            //做选择
            track.add(candidates[i]);
            int currentSize = track.size();
            //进入下一层决策
            backTrack(candidates, track, target,i);
            //取消选择
            track.remove(currentSize - 1);
        }
    }

}
