package cn.theproudsoul.leetcode.february.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1178. 猜字谜
 * https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/
 */
public class FindNumOfValidWords {

  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    // key: wordBit number value: number of words
    Map<Integer, Integer> wordBit2Count = new HashMap<>();

    for (String word : words) {
      int wordBit = 0;
      for (int i = 0; i < word.length(); i++) {
        wordBit |= (1 << (word.charAt(i) - 'a'));
      }
      wordBit2Count.put(wordBit, wordBit2Count.getOrDefault(wordBit, 0) + 1);
    }

    List<Integer> result = new ArrayList<>(puzzles.length);
    for (String puzzle : puzzles) {
      int puzzleBit = 0;
      for (int i = 1; i < 7; i++) {
        puzzleBit |= (1 << (puzzle.charAt(i) - 'a'));
      }
      int total = 0;
      int firstCharBit = 1 << (puzzle.charAt(0) - 'a');
      int subset = puzzleBit;
      do {
        int s = subset | firstCharBit;
        total += wordBit2Count.getOrDefault(s, 0);
        subset = (subset - 1) & puzzleBit;
      } while (subset != puzzleBit);
      result.add(total);
    }
    return result;
  }

  public static void main(String[] args) {
    String[] words = {"apple", "pleas", "please"};
    String[] puzzles = {"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"};
    FindNumOfValidWords testObj = new FindNumOfValidWords();
    List<Integer> result = testObj.findNumOfValidWords(words, puzzles);
    System.out.println(result);
  }
}
