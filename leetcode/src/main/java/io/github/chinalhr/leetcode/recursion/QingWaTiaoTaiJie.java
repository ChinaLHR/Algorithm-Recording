package io.github.chinalhr.leetcode.recursion;

/**
 * @Author lhr
 * @Date 2020/8/31
 * @Description: 题目：青蛙跳台阶问题 easy
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
 * <p>
 * 1. 递归实现
 * 设跳上 n 级台阶有 f(n) 种跳法。在所有跳法中，青蛙的最后一步只有两种情况： 跳上 1 级或 2 级台阶。
 * 当为 1 级台阶： 剩 n−1 个台阶，此情况共有 f(n−1) 种跳法；
 * 当为 2 级台阶： 剩 n−2 个台阶，此情况共有 f(n−2) 种跳法。
 * 即递推公式： f(n)=f(n−1)+f(n−2) 递推停止条件：n=1的时候 一种跳法， n=2的时候 2种跳法
 * <p>
 * 2.循环求余法
 * f(n) = f(n-1)+f(n-2)
 * f(3) = f(2)+f(1) = 3
 * f(4) = f(3)+f(2) = 5
 */
public class QingWaTiaoTaiJie {

//    public int numWays(int n) {
//        if (n == 0) return 1;
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        return numWays(n - 1) + numWays(n - 2);
//    }

    public int numWays(int n) {
        int a = 1, b = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
