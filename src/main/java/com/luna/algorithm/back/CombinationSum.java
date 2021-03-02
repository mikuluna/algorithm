package com.luna.algorithm.back;
//39. 组合总和
//        给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的数字可以无限制重复被选取。
//
//        说明：
//
//        所有数字（包括 target）都是正整数。
//        解集不能包含重复的组合。 
//        示例 1：
//
//        输入：candidates = [2,3,6,7], target = 7,
//        所求解集为：
//        [
//        [7],
//        [2,2,3]
//        ]
//        示例 2：
//
//        输入：candidates = [2,3,5], target = 8,
//        所求解集为：
//        [
//          [2,2,2,2],
//          [2,3,3],
//          [3,5]
//        ]
//         
//
//        提示：
//
//        1 <= candidates.length <= 30
//        1 <= candidates[i] <= 200
//        candidate 中的每个元素都是独一无二的。
//        1 <= target <= 500

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSumTest(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTest(candidates,target,0,result,list);
        return result;
    }
    public void backTest(int[] candidates, int target,int index,List<List<Integer>> result,List<Integer> list){
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        backTest(candidates,target,index +1,result,list);
        if(target >= candidates[index]){
            list.add(candidates[index]);
            backTest(candidates, target-candidates[index], index, result, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        candidates = new int[]{2,3,5};
        target = 8;
        CombinationSum c = new CombinationSum();
        List<List<Integer>> combinations = c.combinationSumTest(candidates,target);
        for(List<Integer> lists:combinations){
            for(Integer i:lists){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }





    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        back(candidates,0,target,res,result);
        return result;

    }

    public void back(int[] candidates,int index ,int target,List<Integer> res,List<List<Integer>> result){
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(res));
            return;
        }
        back(candidates,index+1,target,res,result);
        if(target - candidates[index] >= 0){
            res.add(candidates[index]);
            back(candidates,index,target-candidates[index],res,result);
            res.remove(res.size()-1);
        }

    }
}
