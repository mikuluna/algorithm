package com.luna.algorithm.string;
//6. Z 字形变换
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
//        比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
//        L   C   I   R
//        E T O E S I I G
//        E   D   H   N
//        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
//        请你实现这个将字符串进行指定行数变换的函数：
//
//        string convert(string s, int numRows);
//        示例 1:
//
//        输入: s = "LEETCODEISHIRING", numRows = 3
//        输出: "LCIRETOESIIGEDHN"
//        示例 2:
//
//        输入: s = "LEETCODEISHIRING", numRows = 4
//        输出: "LDREOEIIECIHNTSG"
//        解释:
//
//        L     D     R
//        E   O E   I I
//        E C   I H   N
//        T     S     G


public class Convert {

    public static String convertNew(String s, int numRows){
        if(s.length() ==1 || numRows == 1){
            return s;
        }
        int len = Math.min(s.length(),numRows);
        String[] res = new String[len];
        boolean down = true;
        int resIndex = 0;
        for(int i = 0 ; i < len;i++){
            res[i] = "";
        }
        for(int i = 0;i< s.length();i++){
            res[resIndex] = res[resIndex]+s.substring(i,i+1);
            if(resIndex == 0){
                down = true;
            }else if(resIndex == len-1){
                down = false;
            }
            resIndex = down?resIndex+1:resIndex-1;
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < len ; i ++){
            sb.append(res[i]);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        System.out.println(convertNew(s,numRows));

        String s2 = "LEETCODEISHIRING";
        int numRows2=4;

        System.out.println(convertNew(s2,numRows2));


    }





    public String convert(String s, int numRows) {
        if(s.length() == 1 || numRows == 1){
            return s;
        }
        int len = Math.min(s.length(),numRows);
        String[] res = new String[len];
        boolean down = true;
        int resIndex = 0;
        for(int i = 0 ; i <len;i ++){
            res[i] = "";
        }
        for(int i = 0 ; i < s.length();i++){
            res[resIndex] = res[resIndex]+s.substring(i,i+1);
            if(resIndex == 0){
                down = true;
            }else if(resIndex == len-1){
                down = false;
            }
            if(down){
                resIndex++;
            }else{
                resIndex--;
            }
        }
        StringBuffer result = new StringBuffer();
        for(int i  = 0 ; i < len ;i++){
            result.append(res[i]);
        }
        return result.toString();
    }

}
