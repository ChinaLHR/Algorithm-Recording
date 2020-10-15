package io.github.chinalhr.leetcode.dynamic_programming;

/**
 * @Author lhr
 * @Date 2020/10/16
 * @Description: 题目：70. 爬楼梯 easy
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 实现：
 * 1. 定义dp数组含义：dp[i] 表示第i个台阶有多少种方法
 * 2. 推导状态转移方程：第一步有两种走法，一阶或者两阶，dp[i] = dp[i-1] + dp[i-2]
 * 3：找到初始值 dp[1] = 1 dp[2] = 2
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
