# Week 5: September 29th - September 30th

## Word Break (Sept. 29th)

Given a **non-empty** string *s* and a dictionary *wordDict* containing a list of **non-empty** words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

**Note:**

- The same word in the dictionary may be reused multiple times in the segmentation.
- You may assume the dictionary does not contain duplicate words.

**Example 1:**

```
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
```

**Example 2:**

```
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
```

**Example 3:**

```
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
```

## First Missing Positive (Sept. 30th)

Given an unsorted integer array, find the smallest missing positive integer.

**Example 1:**

```
Input: [1,2,0]
Output: 3
```

**Example 2:**

```
Input: [3,4,-1,1]
Output: 2
```

**Example 3:**

```
Input: [7,8,9,11,12]
Output: 1
```

**Follow up:**

Your algorithm should run in *O(n)* time and uses constant extra space.

**Hint #1**

Think about how you would solve the problem in non-constant space. Can you apply that logic to the existing space?

**Hint 2:**

We don't care about duplicates or non-positive integers

**Hint 3:**

Remember that O(2n) = O(n)
