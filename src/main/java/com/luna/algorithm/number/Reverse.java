package com.luna.algorithm.number;
//7. 整数反转
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//        示例 1:
//
//        输入: 123
//        输出: 321
//         示例 2:
//
//        输入: -123
//        输出: -321
//        示例 3:
//
//        输入: 120
//        输出: 21
//        注意:
//
//        假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

public class Reverse {
    public int reverse(int x) {
        int result = 0;
        while(x!= 0){
            if(result >Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10){
                return 0;
            }
            result = result*10 + x % 10;
            x = x/10;
        }
        return result;
    }


    public static void main(String[] args) {
        int n1 = 123;

        int n2 = -123;

        int n3 = 120;

        Reverse reverse = new Reverse();

        System.out.println(reverse.reverse(n1));
        System.out.println(reverse.reverse(n2));
        System.out.println(reverse.reverse(n3));

    }

    public int reverse1(int x) {
        int result = 0;
        while(x!= 0){
            if(result >Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10){
                return 0;
            }
            result = result*10 + x % 10;
            x = x/10;
        }
        return result;
    }




}
