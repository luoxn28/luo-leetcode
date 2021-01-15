package com.luo.leetcode.并查集;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 交换字符串中的元素
 * https://leetcode-cn.com/problemset/all/
 *
 * @author luoxiangnan
 * @date 2021-01-11
 */
public class SmallestStringWithSwaps {

    public static void main(String[] args) {
        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps(
                "dcab",
                Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2))));
        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps(
                "dcab",
                Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0, 2))));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs == null || pairs.isEmpty()) {
            return s;
        }

        // 求连通分量
        BF component = new BF(s.length());
        for (List<Integer> pair : pairs) {
            component.addPath(pair.get(0), pair.get(1));
        }
        List<List<Integer>> paths = component.paths();

        char[] chars = s.toCharArray();
        for (List<Integer> path : paths) {
            List<Integer> path2 = path.stream().sorted(Comparator.comparingInt(s::charAt)).collect(Collectors.toList());

            for (int i = 0; i < path.size(); i++) {
                chars[path.get(i)] = s.charAt(path2.get(i));
            }
        }

        return new String(chars);
    }

    static class BF {
        int[] parent;
        private int[] size;

        public BF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void addPath(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
        }

        public List<List<Integer>> paths() {
            HashMap<Integer, List<Integer>> paths = new HashMap<>();
            for (int i = 0; i < parent.length; i++) {
                paths.computeIfAbsent(find(i), k -> new ArrayList<>())
                        .add(i);
            }
            return new ArrayList<>(paths.values());
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
}
