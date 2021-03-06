package com.luna.algorithm.string;
//32. 最长有效括号
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
//         
//
//        示例 1：
//
//        输入：s = "(()"
//        输出：2
//        解释：最长有效括号子串是 "()"
//        示例 2：
//
//        输入：s = ")()())"
//        输出：4
//        解释：最长有效括号子串是 "()()"
//        示例 3：
//
//        输入：s = ""
//        输出：0
//         
//
//        提示：
//
//        0 <= s.length <= 3 * 104
//        s[i] 为 '(' 或 ')'


import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses1(String s){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0 ; i  < s.length(); i ++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(i,i-stack.peek());
                }
            }
        }
        return max;
    }






    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        String s = "(()";
        s = ")()())";
        s = "";
        s =")";
        s ="(";
        System.out.println(l.longestValidParentheses1(s));
    }


    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
