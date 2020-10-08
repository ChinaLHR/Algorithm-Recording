package io.github.chinalhr.leetcode.dynamic_programming;

/**
 * @Author lhr
 * @Date 2020/10/8
 * @Description: 题目：62. 不同路径 medium
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * <p>
 * 实现：
 * 1. 定义dp数组含义：当机器人从左上角走到(i, j) 这个位置时，一共有 dp[i] [j] 种路径。
 * 2. 推导状态转移方程：机器人可以向下走或者向右走，所以有两种方式到达：一种是从 (i-1, j) 这个位置走一步到达
 * 一种是从(i, j - 1) 这个位置走一步到达，因为题目要求计算所有步骤，所以  dp[i] [j] = dp[i-1] [j] + dp[i] [j-1]。
 * 3. 找出初始值：当i=0或者j=0时，表达式不能成立
 * dp[0] [0….n-1] = 1; // 相当于最上面一行，机器人只能一直往左走
 * dp[0…m-1] [0] = 1; // 相当于最左面一列，机器人只能一直往下走
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        //初始化dp
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 推导出 dp[m-1][n-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
