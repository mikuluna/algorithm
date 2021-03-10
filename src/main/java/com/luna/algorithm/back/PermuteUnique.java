package com.luna.algorithm.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//47. 全排列 II
//        给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,1,2]
//        输出：
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
//        示例 2：
//
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//         
//
//        提示：
//
//        1 <= nums.length <= 8
//        -10 <= nums[i] <= 10
public class PermuteUnique {
    public static void main(String[] args) {
        int[]nums = new int[]{1,2,1};
        PermuteUnique p = new PermuteUnique();
        List<List<Integer>> res = p.permuteUnique(nums);
        for(int i = 0 ; i < res.size() ; i ++){
            for(int j = 0 ; j < res.get(i).size() ; j ++){
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        back(res,list,nums,visited,0);
        return res;
    }
    public void back(List<List<Integer>> res,List<Integer> list,int[] nums,boolean[] visited,int index){
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0 ; i < nums.length;i ++){
            if(visited[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            back(res,list,nums,visited,index+1);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
