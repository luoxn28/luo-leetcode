package com.luo.leetcode.string;

import java.util.*;

/**
 * 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 *
 * @author luoxiangnan
 * @date 2020-10-07
 */
public class FindAnagrams {

    public static void main(String[] args) {
        {
            String s = "cbaebabacd", p = "abc";
            System.out.println(new FindAnagrams().findAnagrams(s, p));
        }
        {
            String s = "abaacbabc", p = "abc";
            System.out.println(new FindAnagrams().findAnagrams(s, p));
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(need.get(c), window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    result.add(left);
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(need.get(d), window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return result;
    }
}
