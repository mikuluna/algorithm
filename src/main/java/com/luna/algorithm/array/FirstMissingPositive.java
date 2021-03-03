package com.luna.algorithm.array;
//41. 缺失的第一个正数
//        给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//
//         
//
//        进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
//
//         
//
//        示例 1：
//
//        输入：nums = [1,2,0]
//        输出：3
//        示例 2：
//
//        输入：nums = [3,4,-1,1]
//        输出：2
//        示例 3：
//
//        输入：nums = [7,8,9,11,12]
//        输出：1
//         
//
//        提示：
//
//        0 <= nums.length <= 300
//        -231 <= nums[i] <= 231 - 1

public class FirstMissingPositive {
    public int firstMissingPositiveTest(int[] nums) {
        int len = nums.length;
        for(int i = 0 ; i < len ; i ++){
            if(nums[i] <= 0 ){
                nums[i] = len+1;
            }
        }
        for(int i = 0 ; i < len ; i ++){
            int num = Math.abs(nums[i]);
            if(num <= len){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        for(int i = 0 ; i < len ; i ++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return len+1;
    }



    public static void main(String[] args) {
        int[]nums = new int[]{1,2,0};
//        nums = new int[]{3,4,-1,1};
//        nums = new int[]{7,8,9,11,12};
        FirstMissingPositive f = new FirstMissingPositive();
        int res = f.firstMissingPositiveTest(nums);
        System.out.println(res);


    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //最小正数不会大于n+1,将所有负数去掉
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                //在不改变原来值的情况下打标记
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
