package com.luo.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 *
 * @author luoxiangnan
 * @date 2020-10-06
 */
public class CheckInclusion {

    public static void main(String[] args) {
        {
            String s1 = "ab", s2 = "eidbaooo";
            System.out.println(new CheckInclusion().checkInclusion(s1, s2));
        }

        {
            String s1 = "ab", s2 = "eidboaoo";
            System.out.println(new CheckInclusion().checkInclusion(s1, s2));
        }
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.computeIfAbsent(c, k -> 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.computeIfAbsent(c, k -> 0) + 1);
                if (Objects.equals(need.get(c), window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(need.get(d), window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return false;
    }
}
