package test;

import java.util.List;

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];  // 假设字典中的单词只包含小写字母
        isWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    public TrieNode getRoot() {
        return root;
    }
}

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // 空字符串可以被分割

        for (int i = 1; i <= n; i++) {
            TrieNode node = trie.getRoot();
            for (int j = i; j >= 0; j--) {
                if (node == null) break;
                char c = s.charAt(j - 1);
                node = node.children[c - 'a'];
                if (node != null && node.isWord && dp[j - 1]) {
                    dp[i] = true;
                    // 继续向前搜索，不立即返回，以便找到更长的匹配
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        String s = "apple";
        List<String> wordDict = List.of("app", "apple");
        boolean result = solution.wordBreak(s, wordDict);
        System.out.println("Can the string \"" + s + "\" be segmented? " + result);
    }
}
