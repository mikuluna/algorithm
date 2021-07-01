package com.luna.algorithm.array;

import java.util.*;
import java.util.stream.Collectors;

//49. 字母异位词分组
//        给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//        示例:
//
//        输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        说明：
//
//        所有输入均为小写字母。
//        不考虑答案输出的顺序。
public class GroupAnagrams {

    public List<List<String>> groupAnagramsTest(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            List<String> list = map.getOrDefault(sortStr,new ArrayList<>());
            list.add(str);
            map.put(sortStr,list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams g = new GroupAnagrams();
        List<List<String>> res = g.groupAnagrams(strs);
        for(List<String> list:res){
            for(String str:list){
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str :strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            List<String> list = map.getOrDefault(sortStr,new ArrayList<>());
            list.add(str);
            map.put(sortStr,list);
        }
        return new ArrayList<>(map.values());
    }
}
