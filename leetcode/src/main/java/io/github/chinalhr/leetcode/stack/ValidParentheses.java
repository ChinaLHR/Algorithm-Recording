package io.github.chinalhr.leetcode.stack;

import java.util.ArrayDeque;

/**
 * @Author: lihanrong
 * @Date: 2020/8/31 11:25 上午
 * @Description: 20. 有效的括号 easy
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 3. 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 实现：
 * 基于括号的特性，利用栈实现，循环所有字符
 * if 左符号 入栈对应的右符号
 * else 右符号 出栈对应的符号，如果对应不上或者为空则证明字符串无效
 * 最后，如果栈为空，则校验正常，否则校验失败
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.toCharArray().length == 1 || s.toCharArray().length % 2 == 1) return false;

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (c.equals('(')) stack.push(')');
            else if (c.equals('{')) stack.push('}');
            else if (c.equals('[')) stack.push(']');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
