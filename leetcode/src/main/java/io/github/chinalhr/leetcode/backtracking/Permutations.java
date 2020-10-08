package io.github.chinalhr.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lhr
 * @Date 2020/10/6
 * @Description: 题目：46. 全排列 medium
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 实现：
 * 1. 抽象决策树
 *        *
 *     /  |   \
 *    1   2   3
 *   /|  /|  /|
 *  2 3 1 3 1 2
 *  | | | | | |
 *  3 2 3 1 2 1
 *
 * 2. 确定路径，记录已经做过的选择，如第一条路径的1、2
 * 3. 确定选择列表，如第一条路径到1的时候，[2、3]为选择列表
 * 4. 确定结束条件，选择列表为空的时候
 */
public class Permutations {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> track = new ArrayList<>();
        backTrack(nums,track);
        return result;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    private void backTrack(int[] nums,List<Integer> track){
        //触发结束条件
        if (track.size()==nums.length){
            ArrayList<Integer> copyTrack = new ArrayList<>(track);
            result.add(copyTrack);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) continue;
            // 做选择
            track.add(nums[i]);
            int currentSize = track.size();
            // 进入下一层决策树
            backTrack(nums,track);
            // 取消选择
            track.remove(currentSize-1);
        }

    }
}
