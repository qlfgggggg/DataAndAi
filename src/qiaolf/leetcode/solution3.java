package qiaolf.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * Author:qiaolf
 * @Date:2021/9/27 22:10
 **/
public class solution3 {
    public int lengthOfLongestSubstring(String s) {
        int right=0;
        int n=s.length();
        Set<Character> set = new HashSet<>();
        int max=0;
        for (int i = 0; i < n; i++) {
            while (right<n && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            max=Math.max(max,right-i);
            set.remove(s.charAt(i));
        }
        return max;
    }
}
