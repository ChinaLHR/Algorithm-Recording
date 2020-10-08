package io.github.chinalhr.leetcode.greedy;

import java.util.Stack;

/**
 * @Author lhr
 * @Date 2020/10/4
 * @Description: 题目：316. 去除重复字母  medium
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小
 * （要求不能打乱其他字符的相对位置）。
 * <p>
 * 示例 1:
 * 输入: "bcabc"
 * 输出: "abc"
 * <p>
 * 分析：
 * 要点1：去重
 * 要点2：去重字符串中的字符顺序不能打乱 s 中字符出现的相对顺序。
 * 要点3：在所有符合上一条要求的去重字符串中，字典序最小的作为最终结果。
 * <p>
 * 实现：
 * 1. 通过 set 布尔数组做到栈 stack 中不存在重复元素。
 * 2. 顺序遍历字符串 s，通过「栈」这种顺序结构的 push/pop 操作记录结果字符串，保证了字符出现的顺序和 s 中出现的顺序一致。
 * 3. 通过lastAppearIndex记录每个字符出现的最后一个位置，如果栈顶的字符大于入栈的字符，并且后面还会出现，便将栈顶pop掉
 * 后面再入栈，保证了最终得到的结果字典序最小。
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int len = s.length();
        // 特例处理
        if (len < 2) {
            return s;
        }

        //记录每个字符出现的最后一个位置，也可以用字典，但这里只包含小写字母，
        boolean[] set = new boolean[26];
        // 记录每个字符出现的最后一个位置
        int[] lastAppearIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastAppearIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (set[currentChar - 'a']) {
                continue;
            }
            //栈不为空&&栈顶元素>当前元素&&栈顶元素后面还会出现
            while (!stack.empty() && stack.peek() > currentChar && lastAppearIndex[stack.peek() - 'a'] >= i) {
                char top = stack.pop();
                set[top - 'a'] = false;
            }
            stack.push(currentChar);
            set[currentChar - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            stringBuilder.insert(0, stack.pop());
        }
        return stringBuilder.toString();
    }

}
