package io.github.chinalhr.leetcode.dynamic_programming;

/**
 * @Author lhr
 * @Date 2020/10/8
 * @Description: 题目：64. 最小路径和 medium
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 实现：
 * 1. 定义dp数组含义：当机器人从左上角走到(i, j) 这个位置时，最小的路径和是 dp[i][j]；dp[i-1] [j-1] 即我们要的答案了。
 * 2. 推导状态转移方程：
 * 一种是从 (i-1, j) 这个位置走一步到达
 * 一种是从(i, j - 1) 这个位置走一步到达
 * 因为需要计算哪一个路径和是最小的，推导出转移方程：dp[i] [j] = min(dp[i-1][j]，dp[i][j-1]) + arr[i][j]
 * 其中arr[i][j] 表示二维数组网格中的值
 * 3：找到初始值
 * dp[0] [0….n-1] ：二维数组最上面一行 dp[0] [j] = arr[0] [j] + dp[0] [j-1];
 * dp[i] [0] ： 二维数组最右边一行 dp[i] [0] = arr[i] [0] + dp[i] [0]
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (n <= 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        // 初始化
        dp[0][0] = grid[0][0];
        // 初始化最左边的列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 初始化最上边的行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 推导出 dp[m-1][n-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

}
