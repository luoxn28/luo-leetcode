package com.luo.leetcode.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流的中位数
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 * 大小堆结合的思想还是很强的
 *
 * @author luoxiangnan
 * @date 2020-10-02
 */
public class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (small.size() < large.size()) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        if (small.size() < large.size()) {
            return large.peek();
        } else if (small.size() > large.size()) {
            return small.peek();
        }

        return ((double) large.peek() + small.peek()) / 2;
    }
}
