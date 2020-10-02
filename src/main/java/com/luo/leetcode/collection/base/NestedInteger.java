package com.luo.leetcode.collection.base;

import java.util.List;

/**
 * @author luoxiangnan
 * @date 2020-10-02
 */
public class NestedInteger {

    private Integer val;
    private List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.val = null;
    }

    public boolean isInteger() {
        return val != null;
    }

    public Integer getInteger() {
        return this.val;
    }

    public List<NestedInteger> getList() {
        return this.list;
    }
}
