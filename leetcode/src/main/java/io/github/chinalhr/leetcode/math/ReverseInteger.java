package io.github.chinalhr.leetcode.math;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @Author lhr
 * @Date 2021/7/4
 * @Description: 题目： 7. 整数反转 easy
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * </p>
 * 实现：
 * 1. 利用栈的特性实现反转
 * 2. 通过取模运算，每次拿到数字的末尾数字即可；注意
 */
public class ReverseInteger {

    public int reverse(int x){
            int res = 0;
            while(x!=0) {
                //每次取末尾数字
                int tmp = x%10;
                //判断是否 大于 最大32位整数
                if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                    return 0;
                }
                //判断是否 小于 最小32位整数
                if (res< -214748364 || (res == -214748364 && tmp < -8)) {
                    return 0;
                }
                res = res*10 + tmp;
                x /= 10;
            }
            return res;
    }

    /**
     * 通过栈实现
     * @param x
     * @return
     */
    public int reverse2(int x){
        try {
            return doReverse(x);
        }catch (NumberFormatException e){
            return 0;
        }
    }

    private int doReverse(int x) {
        char negativeNumberChar = '-';
        boolean isNegativeNumber = x < 0;
        if (x < 10 && x > 0) {
            return x;
        }

        char[] xCharArray = String.valueOf(x).toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < xCharArray.length ; i++) {
            if (isNegativeNumber && i == 0){
                continue;
            }
            stack.push(xCharArray[i]);
        }

        char[] reverseCharArray = new char[xCharArray.length];
        if (isNegativeNumber) reverseCharArray[0] = negativeNumberChar;
        for (int i = 0; i < reverseCharArray.length; i++) {
            if (isNegativeNumber && i == 0){
                reverseCharArray[i] = negativeNumberChar;
                continue;
            }
            reverseCharArray[i] = stack.pop();
        }

        return Integer.parseInt(String.valueOf(reverseCharArray));
    }
}
