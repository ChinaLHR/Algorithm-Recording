package io.github.chinalhr.leetcode.string;

/**
 * @Author lhr
 * @Date 2021/7/9
 * @Description
 */
public class ImplementStrstr {

    /**
     * BF（Brute Force）朴素匹配
     * @param haystack
     * @param needle
     * @return
     */
    public int bfStrStr(String haystack, String needle) {
        int hayLength = haystack.length();
        int needLength = needle.length();
        if (hayLength < needLength) return -1;
        if (needLength == 0) return 0;
        //主串
        for (int i = 0; i < hayLength - needLength; i++) {
            int j = 0;
            //模式串
            for (j = 0; j < needLength; j++){
                //不符合字符的情况，
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
            }
            //全部匹配的情况
            if (j==needLength){
                return i;
            }
        }
        return -1;
    }

    /**
     * kmp算法实现
     * @param haystack
     * @param needle
     * @return
     */
//    public int kmpStrStr(String haystack, String needle) {
//
//    }
}
