package com.luna.algorithm.back;

import java.util.ArrayList;
import java.util.List;
//22. 括号生成
//        数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//         
//
//        示例：
//
//        输入：n = 3
//        输出：[
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]

public class GenerateParenthesis {


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        back(result,n,0,0,"");
       return result;
    }
    public void back(List<String> result,int n,int left,int right,String str){
        if(str.length() == n *2){
            result.add(str);
            return;
        }
        if(left  < n){
            back(result,n,left+1,right,str+"(");
        }
        if(right < left){
            back(result,n,left,right+1,str+")");
        }
    }



    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> res = g.generateParenthesis(3);
        System.out.println(res.toString());
    }

    public List<String> generateParenthesis1(int n) {

        List<String> result = new ArrayList<>();
        backParenthesis("", result, 0, 0, n);
        return result;
    }

    public void backParenthesis(String res, List<String> result, int open, int close, int max) {
        if (res.length() == max * 2) {
            result.add(res);
            return;
        }
        if (open < max) {
            backParenthesis(res + "(", result, open + 1, close, max);
        }
        if (close < open) {
            backParenthesis(res + ")", result, open, close + 1, max);
        }
    }
}

