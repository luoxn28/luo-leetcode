package com.luo.leetcode.search;

/**
 * 1011. 在 D 天内送达包裹的能力
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * @author luoxiangnan
 * @date 2021-01-24
 */
public class ShipWithinDays {

    public static void main(String[] args) {
        System.out.println(new ShipWithinDays().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(new ShipWithinDays().shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(new ShipWithinDays().shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights);
        int right = getSum(weights) + 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (canFinish(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 如果载重为 cap，是否能在 D 天内运完货物？
    boolean canFinish(int[] weights, int D, int cap) {
        int n = 0;
        for (int i = 0; i < D; i++) {
            int curCap = cap;
            while ((curCap -= weights[n]) >= 0) {
                n++;
                if (n == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }

    int getSum(int[] weights) {
        int sum = 0;
        for (int n : weights) {
            sum += n;
        }
        return sum;
    }

    int getMax(int[] weights) {
        int max = 0;
        for (int n : weights) {
            max = Math.max(n, max);
        }
        return max;
    }
}
