package com.luna.algorithm.back;
//46. 全排列
//        给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        int[]nums = new int[]{1,2,1};
        Permute p = new Permute();
        List<List<Integer>> res = p.permute(nums);
        for(int i = 0 ; i < res.size() ; i ++){
            for(int j = 0 ; j < res.get(i).size() ; j ++){
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        back(res,list,nums,0,visited);
        return res;
    }

    public void back(List<List<Integer>> res,List<Integer> list,int[]nums,int index,int[] visited){
        if(nums.length == index){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0 ; i <nums.length; i ++){
            if(visited[i] == 1){
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            back(res,list,nums,index+1,visited);
            visited[i] = 0;
            list.remove(list.size()-1);
        }
    }
}
