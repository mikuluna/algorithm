package com.luna.algorithm.number;
//50. Pow(x, n)
//        实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
//
//         
//
//        示例 1：
//
//        输入：x = 2.00000, n = 10
//        输出：1024.00000
//        示例 2：
//
//        输入：x = 2.10000, n = 3
//        输出：9.26100
//        示例 3：
//
//        输入：x = 2.00000, n = -2
//        输出：0.25000
//        解释：2-2 = 1/22 = 1/4 = 0.25
//         
//
//        提示：
//
//        -100.0 < x < 100.0
//        -231 <= n <= 231-1
//        -104 <= xn <= 104

public class MyPow {

    double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }




}
