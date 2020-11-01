package com.luo.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
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
        backtrack(s, wordDict);
        return result;
    }

    private List<String> result = new ArrayList<>();
    private LinkedList<String> paths = new LinkedList<>();

    private void backtrack(String s, List<String> wordDict) {
        String toString = pathsToString("");
        if (toString.equals(s)) {
            result.add(pathsToString(" "));
            return;
        } else if (toString.length() >= s.length() || !s.startsWith(toString)) {
            return;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            paths.add(wordDict.get(i));
            backtrack(s, wordDict);
            paths.removeLast();
        }
    }

    private String pathsToString(String split) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paths.size(); i++) {
            sb.append(paths.get(i));
            if (i < paths.size() - 1) {
                sb.append(split);
            }
        }
        return sb.toString();
    }
}
