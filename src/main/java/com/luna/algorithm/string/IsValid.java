package com.luna.algorithm.string;
//20. 有效的括号
//        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        注意空字符串可被认为是有效字符串。
//
//        示例 1:
//
//        输入: "()"
//        输出: true
//        示例 2:
//
//        输入: "()[]{}"
//        输出: true
//        示例 3:
//
//        输入: "(]"
//        输出: false
//        示例 4:
//
//        输入: "([)]"
//        输出: false
//        示例 5:
//
//        输入: "{[]}"
//        输出: true

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> validStack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i ++){
            char ch = s.charAt(i);
            if(ch == '('|| ch == '[' || ch == '{'){
                validStack.push(ch);
                continue;
            }
            if(validStack.isEmpty()){
                return false;
            }
            char pop = validStack.pop();
            if((ch ==']'&& pop=='[')||(ch =='}'&& pop=='{')||(ch ==')'&& pop=='(')){

            }else{
                return false;
            }
        }
        return validStack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()";
        str = "()[]{}";
        str = "(]";
        str = "([)]";
        str = "{[]}";
        str = "}";
        IsValid is = new IsValid();
        System.out.println(is.isValid(str));
    }
}
