package io.github.chinalhr.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author lhr
 * @Date 2021/7/14
 * @Description: 题目 . 224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 1 <= s.length <= 3 * 105 | s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 | s 表示一个有效的表达式
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 *
 * 数据范围：
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * <p>
 * 实现：基于两个栈实现，具体见代码
 * </p>
 */
public class BasicCalculator {

    public int calculate(String s) {
        // 存放所有的数字
        Deque<Integer> numStack = new ArrayDeque<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        numStack.addLast(0);
        // 将所有的空格去掉
        s = s.replaceAll(" ", "");
        // 存放所有的操作，包括 +/-
        Deque<Character> opsStack = new ArrayDeque<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                opsStack.addLast(c);
            } else if (c == ')') {
                // 计算到最近一个左括号为止
                while (!opsStack.isEmpty()) {
                    char op = opsStack.peekLast();
                    if (op != '(') {
                        calc(numStack, opsStack);
                    } else {
                        opsStack.pollLast();
                        break;
                    }
                }
            } else {
                if (isNum(c)) {
                    int u = 0;
                    int j = i;
                    // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                    while (j < n && isNum(cs[j])) u = u * 10 + (int)(cs[j++] - '0');
                    numStack.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        numStack.addLast(0);
                    }
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    while (!opsStack.isEmpty() && opsStack.peekLast() != '(') calc(numStack, opsStack);
                    opsStack.addLast(c);
                }
            }
        }
        while (!opsStack.isEmpty()) calc(numStack, opsStack);
        return numStack.peekLast();
    }
    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        nums.addLast(op == '+' ? a + b : a - b);
    }
    boolean isNum(char c) {
        return Character.isDigit(c);
    }

}
