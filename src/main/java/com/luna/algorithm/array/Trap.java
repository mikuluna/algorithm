package com.luna.algorithm.array;

//42. 接雨水
//        给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//         
//
//        示例 1：
//
//
//
//        输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//        输出：6
//        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//        示例 2：
//
//        输入：height = [4,2,0,3,2,5]
//        输出：9
//         
//
//        提示：
//
//        n == height.length
//        0 <= n <= 3 * 104
//        0 <= height[i] <= 105

public class Trap {

    public int trapTest(int[] height) {
        int len = height.length;
        if(len == 0 ||len == 1){
            return 0;
        }
        int[] right = new int[len];
        right[0] = height[0];
        int[] left = new int[len];
        left[len-1] = height[len -1];
        for(int i = 1 ; i < len ; i ++){
            right[i] = Math.max(height[i],right[i-1]);
        }
        for(int i = len-1; i > 0 ; i --){
            left[i -1] = Math.max(left[i],height[i-1]);
        }
        int sum = 0;
        for(int i = 0 ; i < len ; i ++){
            sum = sum + Math.min(left[i],right[i])-height[i];
        }
        return sum;
    }



    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        height = new int[]{4,2,0,3,2,5};
        Trap t = new Trap();
        int res = t.trapTest(height);
        System.out.println(res);

    }

    public int trap(int[] height) {
        int len = height.length;
        if(len == 0){
            return 0;
        }
        int[] right = new int[len];
        int[] left = new int[len];
        right[0] = height[0];
        for(int i = 1 ;i< len ; i++){
            right[i] = Math.max(right[i-1],height[i]);
        }
        left[len-1] = height[len-1];
        for(int i = len-2 ; i >= 0 ; i--){
            left[i] = Math.max(left[i+1],height[i]);
        }
        int sum = 0;
        for(int i = 0;i<len;i++){
            sum += Math.min(right[i],left[i])-height[i];
        }
        return sum;
    }
}
