package cn.theproudsoul.leetcode.august.week1;

class DictionaryNode {
  DictionaryNode[] letters = new DictionaryNode[26];
  boolean isEnd;
}

public class WordDictionary {

  private static final char ANY_ONE_LETTER = '.';
  DictionaryNode root;

  /**
   * Initialize your data structure here.
   */
  public WordDictionary() {
    root = new DictionaryNode();
  }

  /**
   * Adds a word into the data structure.
   */
  public void addWord(String word) {
    int len = word.length();
    DictionaryNode p = root;
    for (int i = 0; i < len - 1; i++) {
      int c = word.charAt(i) - 'a';
      if (p.letters[c] == null) {
        p.letters[c] = new DictionaryNode();
      }
      p = p.letters[c];
    }
    int endLetter = word.charAt(len - 1) - 'a';
    if (p.letters[endLetter] == null) {
      p.letters[endLetter] = new DictionaryNode();
    }
    p.letters[endLetter].isEnd = true;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
   */
  public boolean search(String word) {
    return searchHelper(root, word, 0, word.length());
  }

  private boolean searchHelper(DictionaryNode root, String word, int index, int len) {
    if (index==len) {
      if (root.isEnd) return true;
      return false;
    }
    if (word.charAt(index) == ANY_ONE_LETTER) {
      for (int i = 0; i < 26; i++) {
        if (root.letters[i] != null) {
          if (searchHelper(root.letters[i], word, index + 1, len))
            return true;
        }
      }
      return false;
    }

    int c = word.charAt(index) - 'a';
    if (root.letters[c] == null) return false;
    return searchHelper(root.letters[c], word, index + 1, len);
  }

  public static void main(String[] args) {
    WordDictionary obj = new WordDictionary();
    obj.addWord("at");
    obj.addWord("and");
    obj.addWord("an");
    obj.addWord("add");
    assert !obj.search("a");
    assert !obj.search(".at");
    obj.addWord("bat");
    assert obj.search(".at");
  }
}
