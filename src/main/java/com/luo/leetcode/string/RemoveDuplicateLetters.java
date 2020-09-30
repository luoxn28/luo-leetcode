package com.luo.leetcode.string;

import java.util.Stack;

/**
 * 去除重复字母
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 使用单调栈来解决
 *
 * @author luoxiangnan
 * @date 2020-09-30
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("bcabc"));
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("bbcaac"));
    }

    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        boolean[] visited = new boolean[256];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            count[c]--;
            if (visited[c]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek()] > 0) {
                visited[stack.pop()] = false;
            }

            visited[c] = true;
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

//    public String removeDuplicateLetters2(String s) {
//        TreeMap<Character, LinkedList<Integer>> treeMap = new TreeMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            treeMap.computeIfAbsent(s.charAt(i), k -> new LinkedList<>()).add(i);
//        }
//
//        TreeMap<Character, Integer> cacheMap = new TreeMap<>();
//        Integer prev = Integer.MAX_VALUE;
//        for (Character key : treeMap.keySet()) {
//            LinkedList<Integer> value = treeMap.get(key);
//            if (prev == Integer.MAX_VALUE) {
//                cacheMap.put(key, value.getFirst());
//                prev = value.getFirst();
//                continue;
//            }
//
//            if (value.getLast() < prev) {
//                cacheMap.put(key, value.getLast());
//                prev = Math.min(prev, value.getLast());
//                continue;
//            }
//
//            Integer finalPrev = prev;
//            Integer res = value.stream().filter(o -> o > finalPrev).collect(Collectors.toList()).get(0);
//            cacheMap.put(key, res);
//            prev = Math.min(prev, res);
//        }
//
//        StringBuilder result = new StringBuilder();
//        cacheMap.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(o -> result.append(o.getKey()));
//        return result.toString();
//    }
}
