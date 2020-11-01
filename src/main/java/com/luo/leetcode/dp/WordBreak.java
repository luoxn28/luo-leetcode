package com.luo.leetcode.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 *
 * @author luoxiangnan
 * @date 2020-11-01
 */
public class WordBreak {

    public static void main(String[] args) {
        {
            String s = "catsanddog";
            List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
            System.out.println(new WordBreak().wordBreak(s, wordDict));
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
