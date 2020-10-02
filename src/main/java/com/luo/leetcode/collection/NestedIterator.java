package com.luo.leetcode.collection;

import com.luo.leetcode.collection.base.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 扁平化嵌套列表迭代器
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 *
 * @author luoxiangnan
 * @date 2020-10-02
 */
public class NestedIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.getFirst().isInteger()) {
            NestedInteger data = list.removeFirst();
            for (int i = data.getList().size() - 1; i >= 0; i--) {
                list.addFirst(data.getList().get(i));
            }
        }

        return !list.isEmpty();
    }
}
