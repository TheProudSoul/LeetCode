package cn.theproudsoul.leetcode.august.week4;

class TrieNode {
  TrieNode[] children = new TrieNode[26];
  boolean isEndOfWord = false;
}

public class StreamChecker {
  // Store the words in the trie with reverse order, and check the query string from the end
  TrieNode root = new TrieNode();
  StringBuilder sb = new StringBuilder();

  public StreamChecker(String[] words) {
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      TrieNode current = root;
      for (int j = words[i].length() - 1; j >= 0; j--) {
        int index = word.charAt(j) - 'a';
        if (current.children[index] == null)
          current.children[index] = new TrieNode();
        current = current.children[index];
      }
      current.isEndOfWord = true;
    }
  }

  public boolean query(char letter) {
    sb.append(letter);
    TrieNode current = root;

    boolean result = false;
    for (int i = sb.length() - 1; i >= 0 && current != null; i--) {
      current = current.children[sb.charAt(i) - 'a'];
      if (current != null && current.isEndOfWord) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    StreamChecker obj = new StreamChecker(new String[]{"ab","ba","aaab","abab","baa"});
    boolean param_1 = obj.query('a');
    boolean param_11 = obj.query('a');
    boolean param_111 = obj.query('a');
    boolean param_1111 = obj.query('a');
    boolean param_11111 = obj.query('a');
    boolean param_111111 = obj.query('a');
    boolean param_2 = obj.query('b');
    boolean param_1111111 = obj.query('a');
    boolean param_22 = obj.query('b');
    boolean param_11111111 = obj.query('a');
    boolean param_222 = obj.query('b');
    boolean param_2222 = obj.query('b');
    boolean param_22222 = obj.query('b');
    boolean param_111111111 = obj.query('a');
    boolean param_222222 = obj.query('b');
    boolean param_1111111111 = obj.query('a');
    boolean param_2222222 = obj.query('b');
    boolean param_3 = obj.query('c');
    boolean param_4 = obj.query('d');
    boolean param_5 = obj.query('e');
    boolean param_6 = obj.query('f');
    boolean param_7 = obj.query('g');
    boolean param_8 = obj.query('h');
    boolean param_9 = obj.query('i');
  }
}
