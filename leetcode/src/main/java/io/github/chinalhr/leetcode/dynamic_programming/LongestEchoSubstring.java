package io.github.chinalhr.leetcode.dynamic_programming;

/**
 * @Author: lihanrong
 * @Date: 2020/9/27 10:45 上午
 * @Description: 题目 5. 最长回文子串 medium
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 实现：
 * 1. 定义dp数组含义：dp[i][j] 表示是否为回文串，ij为在字符索引的区间（闭合）
 * 2. 定义状态转移方程：dp[i][j] 可以得到 s[i] = s[j] ,所以 dp[i][j] = dp[i+1][j-1]
 * 3. 找出初始值: 单个字符一定是回文串，所以可以把对角线先初始化为 true，即 dp[i][i] = true 。
 */
public class LongestEchoSubstring {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        /**
         * dp[i][j] 表示 [i j]为回文串
         */
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        //初始化单字符
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    //最短的回文串了
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
