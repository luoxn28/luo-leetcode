package com.luo.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 视频拼接
 * https://leetcode-cn.com/problems/video-stitching/
 *
 * @author luoxiangnan
 * @date 2020-10-24
 */
public class VideoStitching {

    public static void main(String[] args) {
        
    }

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[T + 1];

        for (int[] clip : clips) {
            if (clip[0] >= T) {
                continue;
            }
            if (clip[0] != 0 && dp[clip[0]] == 0) {
                return -1;
            }

            if (clip[1] > T) {
                clip[1] = T;
            }

            if (clip[0] == 0) {
                for (int i = 0; i <= clip[1]; i++) {
                    dp[i] = 1;
                }
            } else {
                int num = dp[clip[0]] + 1;
                for (int i = clip[0]; i <= clip[1]; i++) {
                    if (dp[i] == 0 || dp[i] > num) {
                        dp[i] = num;
                    }
                }
            }
        }

        return dp[T] == 0 ? -1 : dp[T];
    }
}
