package com.luo.leetcode.dp;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 *
 * @author luoxiangnan
 * @date 2021-04-18
 */
public class MaxEnvelopes {

    public static void main(String[] args) {
        System.out.println(new MaxEnvelopes().maxEnvelopes(new int[][]{
                new int[]{5, 4},
                new int[]{6, 4},
                new int[]{6, 7},
                new int[]{2, 3}
        }));

        System.out.println(new MaxEnvelopes().maxEnvelopes(new int[][]{
                new int[]{1, 1},
                new int[]{1, 1},
                new int[]{1, 1}
        }));

        System.out.println(new MaxEnvelopes().maxEnvelopes(new int[][]{
                new int[]{4, 5},
                new int[]{6, 7},
                new int[]{2, 3}
        }));

        System.out.println(new MaxEnvelopes().maxEnvelopes(new int[][]{
                new int[]{10, 8},
                new int[]{1, 12},
                new int[]{6, 15},
                new int[]{2, 18}
        }));

        System.out.println(new MaxEnvelopes().maxEnvelopes(new int[][]{
                new int[]{1, 1}
        }));
    }

    public int maxEnvelopes(int[][] envelopes) {

        // 先排序
        Arrays.sort(envelopes, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        // fn(n) = max(fn(1), fn(2), ..., f(n-1))，如果对应n的元素都小于当前元素的话
        int res = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0]
                        && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
