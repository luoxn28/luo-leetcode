package com.luo.leetcode.array;

import java.util.*;

/**
 * @author luoxiangnan
 * @date 2020-11-05
 */
public class LadderLength {

    public static void main(String[] args) {
        System.out.println(new LadderLength().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(new LadderLength().ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log")));

        System.out.println(new LadderLength().ladderLength("lost", "miss",
                Arrays.asList("most", "mist", "miss", "lost", "fist", "fish")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        ladderLength(beginWord, endWord, new HashSet<>(wordList));
        return size == Integer.MAX_VALUE ? 0 : size;
    }

    private int size = Integer.MAX_VALUE;
    private LinkedList<String> paths = new LinkedList<>();

    public void ladderLength(String beginWord, String endWord, Set<String> wordSet) {
        if (!paths.isEmpty() && Objects.equals(paths.getLast(), endWord)) {
            size = Math.min(size, paths.size() + 1);
            return;
        } else if (paths.size() >= wordSet.size()) {
            return;
        } else if (paths.size() >= size) {
            return;
        }

        for (String world : wordSet) {
            if (paths.contains(world)) {
                continue;
            }
            if (!canConvert(paths.isEmpty() ? beginWord : paths.getLast(), world)) {
                continue;
            }

            paths.add(world);
            ladderLength(world, endWord, wordSet);
            paths.removeLast();
        }
    }

    private boolean canConvert(String a, String b) {
        int len = 0;
        for (int i = 0; i < a.toCharArray().length; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                len++;
            }
        }
        return len == b.length() - 1;
    }
}
