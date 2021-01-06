package com.luna.algorithm.array;
//4. 寻找两个正序数组的中位数
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
//
//        进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
//
//         
//
//        示例 1：
//
//        输入：nums1 = [1,3], nums2 = [2]
//        输出：2.00000
//        解释：合并数组 = [1,2,3] ，中位数 2
//        示例 2：
//
//        输入：nums1 = [1,2], nums2 = [3,4]
//        输出：2.50000
//        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//        示例 3：
//
//        输入：nums1 = [0,0], nums2 = [0,0]
//        输出：0.00000
//        示例 4：
//
//        输入：nums1 = [], nums2 = [1]
//        输出：1.00000
//        示例 5：
//
//        输入：nums1 = [2], nums2 = []
//        输出：2.00000
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int []temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0 ;
        int right = m;
        int totalLeft = (m+n+1)/2;
        while(left < right){
            int i = (left + right +1)/2;
            int j = totalLeft -i;
            if(nums1[i -1] > nums2[j]){
                right = i-1;
            }else{
                left = i;
            }
        }
        int i = left;
        int j = totalLeft -i;
        int nums1LeftMax = i == 0 ?Integer.MIN_VALUE:nums1[i-1];
        int nums1RightMin = i == m? Integer.MAX_VALUE:nums1[i];
        int nums2LeftMax = j == 0? Integer.MIN_VALUE:nums2[j-1];
        int nums2RightMin = j == n?Integer.MAX_VALUE:nums2[j];

        if((m+n)%2 == 1){
            return Math.max(nums1LeftMax,nums2LeftMax);
        }else{
            return (double)(Math.max(nums1LeftMax,nums2LeftMax)+Math.min(nums1RightMin,nums2RightMin))/2;
        }

    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,3};
//        int[] nums2 = new int[]{2};
//        int[] nums1 = new int[]{1,2};
//        int[] nums2 = new int[]{3,4};
//        int[] nums1 = new int[]{0,0};
//        int[] nums2 = new int[]{0,0};
//        int[] nums1 = new int[]{1};
//        int[] nums2 = new int[]{};
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2};
        FindMedianSortedArrays f = new FindMedianSortedArrays();
        System.out.println(f.findMedianSortedArrays(nums1,nums2));
    }


}

