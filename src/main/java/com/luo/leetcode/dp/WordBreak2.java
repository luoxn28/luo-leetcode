package com.luo.leetcode.dp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 单词拆分 II
 * https://leetcode-cn.com/problems/word-break-ii/
 *
 * @author luoxiangnan
 * @date 2020-11-01
 */
public class WordBreak2 {

    public static void main(String[] args) {
        {
            String s = "catsanddog";
            List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
            System.out.println(new WordBreak2().wordBreak(s, wordDict));
        }

        {
            String s = "pineapplepenapple";
            List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
            System.out.println(new WordBreak2().wordBreak(s, wordDict));
        }

        {
            String s = "catsandog";
            List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
            System.out.println(new WordBreak2().wordBreak(s, wordDict));
        }

        {
            String s = "aaaaaaa";
            List<String> wordDict = Arrays.asList("aaaa", "aa", "a");
            System.out.println(new WordBreak2().wordBreak(s, wordDict));
        }

        {
            String s = "aggegbnngohbggalojckbdfjakgnnjadhganfdkefeddjdnabmflabckflfljafdlmmbhijojiaaifedaihnoinedhhnolcjdam";
            List<String> wordDict = Arrays.asList("o", "b", "gbdfgiokkfnhl", "glibjohcmd", "bblcnhelanckn", "mflabckflflja", "mgda", "oheafhajjo", "cc", "cffalholojikojm", "haljiamccabh", "gjkdlonmhdacd", "ee", "bc", "mjj", "fdlmmbhij", "nn", "jiaaifedaihn", "nhligg", "hooaglldlei", "hajhebh", "ebijeeh", "me", "eibm", "ekkobhajgkem", "ohaofonhjakc", "n", "kjjogm", "mhn", "odcamjmodie", "edmagbkejiocacl", "kcbfnjialef", "lhifcohoe", "akgnn", "fbgakjhjb", "belggjekmn", "oinedhhnolc", "ddekcnag", "oneoakldakalb", "bodnokemafkhkhf", "dkefeddjdnab", "gflcngff", "fgnfmbcogmojgm", "ad", "jadhganf", "lojckbdfj", "gadkaoe", "jdam", "ljjndlnednnombl", "aggegbnngohbgga");
            System.out.println(new WordBreak2().wordBreak(s, wordDict));
        }

        {
            String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
            System.out.println(new WordBreak2().wordBreak(s, wordDict));
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordDict = wordDict.stream().filter(s::contains).collect(Collectors.toList());
        List<List<String>> result = backtrack(s, 0, new HashSet<>(wordDict));
        return result.stream().map(o -> String.join(" ", o)).collect(Collectors.toList());
    }

    private Map<Integer, List<List<String>>> memo = new HashMap<>();

    private List<List<String>> backtrack(String s, int index, Set<String> wordDict) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        List<List<String>> paths = new ArrayList<>();
        if (index == s.length()) {
            paths.add(new LinkedList<>());
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);
            if (wordDict.contains(word)) {
                List<List<String>> nextPaths = backtrack(s, i, wordDict);
                for (List<String> nextPath : nextPaths) {
                    LinkedList<String> path = new LinkedList<>(nextPath);
                    path.addFirst(word);
                    paths.add(path);
                }
            }
        }

        memo.put(index, paths);
        return paths;
    }
}
