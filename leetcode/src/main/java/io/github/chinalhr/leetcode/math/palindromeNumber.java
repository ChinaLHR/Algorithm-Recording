package io.github.chinalhr.leetcode.math;

/**
 * @Author lhr
 * @Date 2021/7/5
 * @Description: 题目：9. 回文数 easy
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 示例：x = 121 true x = -121 false
 * </p>
 * 实现思路：
 */
public class palindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10 ) return true;
        int y = 0; int tmpX = x; int lastNumber = 0;
        while (tmpX!=0){
            lastNumber = tmpX%10;
            y = y*10 + lastNumber;
            tmpX= tmpX/10;
        }
        return x == y;
    }

}
