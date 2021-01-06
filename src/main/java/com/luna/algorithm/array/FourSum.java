package com.luna.algorithm.array;
//18. 四数之和
//        给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
//        注意：
//
//        答案中不可以包含重复的四元组。
//
//        示例：
//
//        给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//        满足要求的四元组集合为：
//        [
//        [-1,  0, 0, 1],
//        [-2, -1, 1, 2],
//        [-2,  0, 0, 2]
//        ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-3;i ++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] + nums[i+1]+ nums[i+2]+ nums[i+3] >target){
                break;
            }
            if(nums[i] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] < target){
                continue;
            }
            for(int j = i+1;j < nums.length-2 ; j ++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int newTarget = target- nums[i];

                if(nums[j] + nums[j+1]+ nums[j+2] >newTarget){
                    break;
                }
                if(nums[j] + nums[nums.length-1] + nums[nums.length-2]  < newTarget){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    if(nums[j] + nums[left] +nums[right] == newTarget){
                        List<Integer> addList = Arrays.asList(nums[i],nums[j],nums[left],nums[right]);
                        result.add(addList);
                        left ++;
                        right -- ;
                        while(left < right && nums[left] == nums[left-1]){
                            left ++;
                        }
                        while(left < right && nums[right] == nums[right+1]){
                            right --;
                        }
                    }else if(nums[j] + nums[left] +nums[right] < newTarget){
                        left++;
                    }else{
                        right --;
                    }
                }
            }
        }
        return result;

    }


    public static void main(String[] args) {

        FourSum f = new FourSum();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2,-2,0};
        nums = new int[]{0,0,0,0};
        int target = 0;
        List<List<Integer>> res = f.fourSum(nums,target);
        System.out.println(res.toString());

    }



    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }


}
