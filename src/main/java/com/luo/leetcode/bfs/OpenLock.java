package com.luo.leetcode.bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 开转盘锁
 * https://leetcode-cn.com/problems/open-the-lock/
 *
 * @author luoxiangnan
 * @date 2020-10-05
 */
public class OpenLock {

    public static void main(String[] args) {
        {
            String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
            String target = "0202";
            System.out.println(new OpenLock().openLock(deadends, target));
        }

        {
            String[] deadends = new String[]{"8888"};
            String target = "0009";
            System.out.println(new OpenLock().openLock(deadends, target));
        }

        {
            String[] deadends = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
            String target = "8888";
            System.out.println(new OpenLock().openLock(deadends, target));
        }

        {
            String[] deadends = new String[]{"0000"};
            String target = "8888";
            System.out.println(new OpenLock().openLock(deadends, target));
        }
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deads = Arrays.stream(deadends).collect(Collectors.toSet());
        Set<String> visited = Arrays.stream(deadends).collect(Collectors.toSet());
        Queue<String> queue = new ArrayDeque<>();
        queue.add("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();

                if (deads.contains(s)) {
                    continue;
                }
                if (Objects.equals(s, target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String add = addOne(s, j);
                    if (!visited.contains(add)) {
                        queue.add(add);
                        visited.add(add);
                    }
                    String sub = subOne(s, j);
                    if (!visited.contains(sub)) {
                        queue.add(sub);
                        visited.add(sub);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    private String addOne(String s, int i) {
        char[] array = s.toCharArray();

        char c = array[i];
        array[i] = c == '9' ? '0' : ++c;
        return new String(array);
    }

    private String subOne(String s, int i) {
        char[] array = s.toCharArray();

        char c = array[i];
        array[i] = c == '0' ? '9' : --c;
        return new String(array);
    }
}
