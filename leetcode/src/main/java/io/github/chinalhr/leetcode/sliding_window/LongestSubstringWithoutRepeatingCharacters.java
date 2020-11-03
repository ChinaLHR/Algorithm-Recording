package io.github.chinalhr.leetcode.sliding_window;

import java.util.HashMap;

/**
 * @Author lhr
 * @Date 2020/10/14
 * @Description: 题目：3. 无重复字符的最长子串 medium
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 实现：
 * 双指针+滑动窗口
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        /**
         * Key：当前的字符 value：字符对应的最新下标
         */
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;//最长子串长度
        int left = 0;//左指针
        for (int i = 0; i < s.length(); i++) {
            //如果已经出现过，更新left指针到之前该字符index后一位，此时两指针间的滑动窗口内还是无重复字符的子串
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }


}
