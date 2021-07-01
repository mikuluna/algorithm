package com.luna.algorithm.back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//17. 电话号码的字母组合
//        给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//        put('2', "abc");
//        put('3', "def");
//        put('4', "ghi");
//        put('5', "jkl");
//        put('6', "mno");
//        put('7', "pqrs");
//        put('8', "tuv");
//        put('9', "wxyz");
//
//
//        示例:
//
//        输入："23"
//        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        Map<Character,String> phoneTable = new HashMap<>();
        phoneTable.put('2',"abc");
        phoneTable.put('3',"def");
        phoneTable.put('4',"ghi");
        phoneTable.put('5',"jkl");
        phoneTable.put('6',"mno");
        phoneTable.put('7',"pqrs");
        phoneTable.put('8',"tuv");
        phoneTable.put('9',"wxyz");
        back(result,phoneTable,0,digits,new StringBuffer());
        return result;
    }
    public void back(List<String> result,Map<Character,String> phoneTable,int index,String digits,StringBuffer target){
        if(index == digits.length()){
            result.add(target.toString());
            return;
        }
        char phoneChar = digits.charAt(index);
        String charPhones = phoneTable.get(phoneChar);
        for(int i = 0 ; i< charPhones.length();i++){
            target.append(charPhones.charAt(i));
            back(result, phoneTable, index+1, digits, target);
            target.deleteCharAt(index);
        }
    }




    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        String digits = "23";
//        digits = "45";
//        digits = "3256";
        List<String> re = l.letterCombinations(digits);
        System.out.println(re.toString());
    }


    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack1(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack1(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack1(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
