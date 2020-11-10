package com.luo.leetcode.array;

/**
 * @author luoxiangnan
 * @date 2020-11-04
 */
public class ArrayInsert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][];
        for (int i = 0, j = 0; i < intervals.length; i++) {
            return null;
        }
        return null;
    }

    private boolean hasOverlapping(int[] interval, int[] newInterval) {
        if (interval[0] > newInterval[1] || newInterval[0] > interval[1]) {
            return false;
        }
        return true;
    }

    private int[] merge(int[] interval, int[] newInterval) {
        return new int[]{Math.min(interval[0], newInterval[0]),
                Math.max(interval[1], newInterval[1])};
    }
}
