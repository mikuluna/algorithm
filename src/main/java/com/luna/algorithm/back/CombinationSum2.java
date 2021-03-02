package com.luna.algorithm.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40. 组合总和 II
//        给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的每个数字在每个组合中只能使用一次。
//
//        说明：
//
//        所有数字（包括目标数）都是正整数。
//        解集不能包含重复的组合。 
//        示例 1:
//
//        输入: candidates = [10,1,2,7,6,1,5], target = 8,
//        所求解集为:
//        [
//        [1, 7],
//        [1, 2, 5],
//        [2, 6],
//        [1, 1, 6]
//        ]
//        示例 2:
//
//        输入: candidates = [2,5,2,1,2], target = 5,
//        所求解集为:
//        [
//          [1,2,2],
//          [5]
//        ]
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        back(candidates,target,0,result,list);
        return result;
    }
    public void back(int[] candidates, int target,int index,List<List<Integer>> result,List<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <candidates.length ; i++) {
            if(target - candidates[index] >= 0){
                if (i > index && candidates[i] == candidates[i -1]){
                    continue;
                }
                list.add(candidates[i]);
                back(candidates,target-candidates[i],i+1,result,list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
//        candidates = new int[]{2,5,2,1,2};
//        target = 5;
        CombinationSum2 c = new CombinationSum2();
        List<List<Integer>> combinations = c.combinationSum2(candidates,target);
        for(List<Integer> lists:combinations){
            for(Integer i:lists){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
}
