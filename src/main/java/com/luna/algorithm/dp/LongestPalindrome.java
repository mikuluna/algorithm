package com.luna.algorithm.dp;
//5. 最长回文子串
//        给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//        示例 1：
//
//        输入: "babad"
//        输出: "bab"
//        注意: "aba" 也是一个有效答案。
//        示例 2：
//
//        输入: "cbbd"
//        输出: "bb"

public class LongestPalindrome {

    public String longestPalindrome(String s){
        String res = "";
        boolean [][]dp = new boolean[s.length()][s.length()];
        int slen = s.length();
        for(int i = 0 ; i < slen; i ++){
            dp[i][i] = true;
            res = s.substring(i,i+1);
        }
        for(int i = 0 ; i < slen -1 ;i ++){
            if(s.charAt(i) == s.charAt(i +1)){
                dp[i][i+1] = true;
                res = s.substring(i,i+2);
            }
        }
        for(int len = 3; len <= slen;len ++){
            for(int i = 0 ; i + len -1  < slen ; i ++){
                int endIndex = i+len-1;
                if(s.charAt(i) == s.charAt(endIndex)){
                    dp[i][endIndex] = dp[i+1][endIndex-1];
                }
                if(dp[i][endIndex]){
                    res = s.substring(i,i+len);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("ccc"));
    }













    public String longestPalindrome2(String s) {
        String result = "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int i = 0 ; i < s.length(); i ++){
            dp[i][i] = true;
            result = s.substring(i,i+1);
        }

        for(int i = 0;i < s.length()-1;i++){
            if( s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
                result = s.substring(i,i+2);
            }else{
                dp[i][i+1] = false;
            }
        }
        for(int len = 3 ; len < s.length();len++){
            for(int i = 0; i +len < s.length();i++){
                int endIndex = i+len-1;
                char start = s.charAt(i);
                char end = s.charAt(endIndex);
                if(start == end){
                    dp[i][endIndex] = dp[i+1][endIndex-1];
                }else{
                    dp[i][endIndex] = false;
                }
                if(dp[i][endIndex]){
                    result = s.substring(i,i+len);
                }
            }
        }
        return result;



    }

    public String longestPalindrome1(String s) {
        String result = "";

        boolean table[][] = new boolean[s.length()][s.length()];

        // length === 1;
        for (int i = 0; i < table.length; i++) {
            table[i][i] = true;
            result = s.substring(i, i + 1);
        }

        // length === 2;
        for (int i = 0; i < table.length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                result = s.substring(i, i + 2);
            } else {
                table[i][i + 1] = false;
            }
        }

        // length > 2;
        for (int len = 3; len <= table.length; len++) {
            for (int i = 0; i + len <= table.length; i++) {
                char front = s.charAt(i);
                char end = s.charAt(i + len - 1);
                if (front == end) {
                    table[i][i + len - 1] = table[i + 1][i + len - 2];
                } else {
                    table[i][i + len - 1] = false;
                }
                if(table[i][i + len - 1]){
                    result = s.substring(i, i + len);
                }
            }
        }
        return result;
    }
}
