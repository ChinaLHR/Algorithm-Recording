package io.github.chinalhr.leetcode.greedy;

/**
 * @Author lhr
 * @Date 2020/10/6
 * @Description: 题目：45. 跳跃游戏 II hard
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 实现：
 * 贪婪算法，我们每次在可跳范围内选择可以使得跳的更远的位置。
 */
public class JumpGameII {

    public int jump(int[] nums) {
        //end表示当前能跳的边界
        int end = 0;
        //maxPosition表示当前能跳的最远距离
        int maxPosition = 0;
        //步数
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
