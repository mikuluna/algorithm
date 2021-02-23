package com.luna.algorithm.array;
//34. 在排序数组中查找元素的第一个和最后一个位置
//        给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//        如果数组中不存在目标值 target，返回 [-1, -1]。
//
//        进阶：
//
//        你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//         
//
//        示例 1：
//
//        输入：nums = [5,7,7,8,8,10], target = 8
//        输出：[3,4]
//        示例 2：
//
//        输入：nums = [5,7,7,8,8,10], target = 6
//        输出：[-1,-1]
//        示例 3：
//
//        输入：nums = [], target = 0
//        输出：[-1,-1]
//         
//
//        提示：
//
//        0 <= nums.length <= 105
//        -109 <= nums[i] <= 109
//        nums 是一个非递减数组
//        -109 <= target <= 109

public class SearchRange {

    //提供自己写一遍
    public int[] searchRangeTest(int[] nums, int target){
        int left = findLeftOrRight(nums,target,true);
        int right = findLeftOrRight(nums,target,false)-1;
        if(left <=right && right < nums.length-1 && nums[left] == target && nums[right] == target){
            return new int[]{left,right};
        }
        return new int[]{-1,-1};
    }

    public int findLeftOrRight(int[] nums,int target,boolean flag){
        int res = nums.length;
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(nums[mid] > target ||(flag && nums[mid] >= target )){
                right = mid-1;
                res = mid;
            }else{
                left = mid +1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[]nums = new int[]{5,7,7,8,8,10};
        int target = 8;
//        target = 6;
        SearchRange s = new SearchRange();
        int[] res = s.searchRangeTest(nums,target);
        for(int i:res){
            System.out.println(i);
        }

    }



    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
