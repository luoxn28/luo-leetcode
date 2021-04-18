package com.luo.leetcode.math;

/**
 * @author luoxiangnan
 * @date 2021-04-18
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(8));
    }

    // 二分法不断逼近
    public int mySqrt(int x) {
        int ans = -1;
        int left = 0, right = x;
        while (left <= right) {
            int mid = (int) Math.ceil((left + right) / 2);
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
