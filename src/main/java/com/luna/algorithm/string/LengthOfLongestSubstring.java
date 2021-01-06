package com.luna.algorithm.string;
//3. 无重复字符的最长子串
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//        示例 1:
//
//        输入: "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//        示例 2:
//
//        输入: "bbbbb"
//        输出: 1
//        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//        示例 3:
//
//        输入: "pwwkew"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int index = -1;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length();i++){
            char key = s.charAt(i);
            if(map.containsKey(key)){
                index = Math.max(map.get(key),index);
            }
            max = Math.max(i-index,max);
            map.put(key,i);
        }
        return max;



    }











    public int lengthOfLongestSubstring1(String s) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        int index = 0;
        for(int i = 0 ; i <s.length();i++){
            char item = s.charAt(i);
            if(map.containsKey(item)){
                index = Math.max(map.get(item),index);
            }
            res = Math.max(i-index+1,res);
            map.put(s.charAt(i),i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abba";
        s = "pwwkew";
        s = "a";
        s = "abcabcbb";
        LengthOfLongestSubstring method = new LengthOfLongestSubstring();
        int res = method.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
