package com.luna.algorithm.string;
//14. 最长公共前缀
//        编写一个函数来查找字符串数组中的最长公共前缀。
//
//        如果不存在公共前缀，返回空字符串 ""。
//
//        示例 1:
//
//        输入: ["flower","flow","flight"]
//        输出: "fl"
//        示例 2:
//
//        输入: ["dog","racecar","car"]
//        输出: ""
//        解释: 输入不存在公共前缀。
//        说明:
//
//        所有输入只包含小写字母 a-z 。

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return  strs[0];
        }
        for(int i = 1; i < strs.length ; i ++){
            String pre = strs[i-1];
            String index = strs[i];
            strs[i] = twoSame(pre,index);
            if(strs[i].length() == 0){
                return "";
            }
        }
        return strs[strs.length-1];
    }
    public String twoSame(String pre,String index){
        if(pre.length() == 0  || index.length() == 0){
            return "";
        }
        int len = Math.min(pre.length(),index.length());
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < len ;i ++){
            if(pre.charAt(i) == index.charAt(i)){
                sb.append(pre.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
//        strs = new String[]{"dog", "racecar", "car"};
        LongestCommonPrefix l = new LongestCommonPrefix();
        String res = l.longestCommonPrefix(strs);
        System.out.println(res);
    }

}
