package com.luna.algorithm.number;
//9. 回文数
//        判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//        示例 1:
//
//        输入: 121
//        输出: true
//        示例 2:
//
//        输入: -121
//        输出: false
//        解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//        示例 3:
//
//        输入: 10
//        输出: false
//        解释: 从右向左读, 为 01 。因此它不是一个回文数。

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int index = x;
        int sum = 0;
        while(index >0){
            if(sum  > Integer.MAX_VALUE/10){
                return false;
            }
            sum = sum *10 + index%10;

            index = index/10;
        }
        return sum == x;
    }

    public static void main(String[] args) {
        int x = 1000000001;
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome(x);
    }
}
