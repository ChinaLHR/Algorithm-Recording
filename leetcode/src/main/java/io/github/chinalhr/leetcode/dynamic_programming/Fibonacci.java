package io.github.chinalhr.leetcode.dynamic_programming;

/**
 * @Author: lihanrong
 * @Date: 2020/9/27 11:05 上午
 * @Description: 题目：509. 斐波那契数 easy
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * <p>
 * 给定 N，计算 F(N)。
 */
public class Fibonacci {

    /**
     * 解法1：带备忘录的递归解法（自顶向下）
     * 核心：使用一个备忘录数组保存每次计算出子问题的结果，每次计算前先查询备忘录数组是否存在数据（是否已经计算过），
     * 如果存在则不进行计算，直接从备忘录数组获取结果，规避递归树重复计算子问题的问题。
     *
     * @param N
     * @return
     */
    public int fib1(int N) {
        int[] memo = new int[N + 1];
        return helper(memo, N);
    }

    private int helper(int[] memo, int N) {
        //base case
        if (N == 0) return 0;
        if (N == 1 || N == 2) return 1;
        if (memo[N] != 0) return memo[N];
        memo[N] = helper(memo, N - 1) + helper(memo, N - 2);
        return memo[N];
    }

    /**
     * 解法2：动态规划（自底向上）dp 数组的迭代解法,
     * 从问题规模最小的 f(1) 和 f(2) 开始往上推，直到推到我们想要的答案
     * @param N
     * @return
     */
    public int fib2(int N) {
        if (N == 0) return 0;
        if (N == 1 || N == 2) return 1;
        int[] dp = new int[N + 1];
        //base case
        dp[1] = dp[2] = 1;
        for (int i = 3; i <=N ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[N];
    }

    /**
     * 解法2：动态规划（自底向上）状态压缩，dp 数组的迭代解法空间优化
     * 每次状态转移只需要 DP table 中的一部分，就只保存那一部分数据
     * @param N
     * @return
     */
    public int fib3(int N) {
        if (N == 0) return 0;
        if (N == 1 || N == 2) return 1;
        //base case
        int prev = 1,current =1;
        for (int i = 3; i <=N ; i++) {
            int sum = prev + current;
            prev = current;
            current = sum;
        }
        return current;
    }
}
