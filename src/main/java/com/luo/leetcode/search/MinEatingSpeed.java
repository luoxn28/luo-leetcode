package com.luo.leetcode.search;

/**
 * @author luoxiangnan
 * @date 2021-01-24
 */
public class MinEatingSpeed {

    public static void main(String[] args) {
        System.out.println(new MinEatingSpeed().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(new MinEatingSpeed().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(new MinEatingSpeed().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    public int minEatingSpeed(int[] piles, int H) {
        // 套用搜索左侧边界的算法框架
        int left = 1, right = getMax(piles) + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 时间复杂度 O(N)
    boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int n : piles) {
            time += (n / speed) + ((n % speed > 0) ? 1 : 0);
        }
        return time <= H;
    }

    int getMax(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }
        return max;
    }
}
