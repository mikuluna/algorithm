package com.luna.algorithm.string;

//43. 字符串相乘
//        给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
//        示例 1:
//
//        输入: num1 = "2", num2 = "3"
//        输出: "6"
//        示例 2:
//
//        输入: num1 = "123", num2 = "456"
//        输出: "56088"
//        说明：
//
//        num1 和 num2 的长度小于110。
//        num1 和 num2 只包含数字 0-9。
//        num1 和 num2 均不以零开头，除非是数字 0 本身。
//        不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

public class Multiply {


    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2];
        for(int i = len1-1; i >=0 ; i --){
            int charNum1 = num1.charAt(i) - '0';
            for(int j = len2-1;j >=0 ; j --){
                int charNum2 = num2.charAt(j) - '0';
                int mul = charNum1* charNum2 + result[i+j+1];
                result[i+j] = mul/10+result[i+j];
                result[i+j+1] = mul%10;
            }
        }
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for(;index<result.length;index++ ){
            if(result[index] != 0 ){
                break;
            }
        }
        for(int i = index; i< result.length ; i++){
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
