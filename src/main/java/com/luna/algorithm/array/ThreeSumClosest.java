package com.luna.algorithm.array;
//16. 最接近的三数之和
//        给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
//         
//
//        示例：
//
//        输入：nums = [-1,2,1,-4], target = 1
//        输出：2
//        解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//         
//
//        提示：
//
//        3 <= nums.length <= 10^3
//        -10^3 <= nums[i] <= 10^3
//        -10^4 <= target <= 10^4

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int closeSum = nums[0] +nums[1]+ nums[2];
        for(int i = 0 ; i < nums.length-2;i++){
            int left = i +1;
            int right = nums.length -1;
            while (left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target) < Math.abs(closeSum-target)){
                    closeSum = sum;
                }
                if(sum < target){
                    left++;
                }else if(sum > target){
                    right --;
                }else{
                    return target;
                }
            }
        }
        return closeSum;

    }

    public static void main(String[] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        int[] nums = new int[]{-1,2,1,-4};
        System.out.println(t.threeSumClosest(nums,1));

        int[] numsNew = new int[]{-1, 0, 1, 2, -1,1,0, -4};
        System.out.println(t.threeSumClosest(numsNew,1));
    }

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }

            }

        }
        return closestNum;
    }
}
