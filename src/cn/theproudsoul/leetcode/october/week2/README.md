# Week 2: October 8th - October 14th

## Binary Search (Oct. 8th)

Given a sorted (in ascending order) integer array `nums` of `n` elements and a `target` value, write a function to search `target` in `nums`. If `target` exists, then return its index, otherwise return -1.

**Example 1:**

```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```

**Example 2:**

```
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```

**Note:**

1. You may assume that all elements in `nums` are unique.
2. n will be in the range `[1, 10000]`.
3. The value of each element in `nums` will be in the range `[-9999, 9999]`.

## Serialize and Deserialize BST (Oct. 9th)

Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a **binary search tree**. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

**The encoded string should be as compact as possible.**

**Example 1:**

```
Input: root = [2,1,3]
Output: [2,1,3]
```

**Example 2:**

```
Input: root = []
Output: []
```

**Constraints:**

- The number of nodes in the tree is in the range `[0, 104]`.
- `0 <= Node.val <= 104`
- The input tree is **guaranteed** to be a binary search tree.

## Minimum Number of Arrows to Burst Balloons (Sept. 10th)

There are some spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and end of the diameter suffice. The start is always smaller than the end.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with `xstart` and `xend` bursts by an arrow shot at `x` if `xstart ≤ x ≤ xend`. There is no limit to the number of arrows that can be shot. An arrow once shot keeps traveling up infinitely.

Given an array `points` where points`[i] = [xstart, xend]`, return the minimum number of arrows that must be shot to burst all balloons.

**Example 1:**

```text
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
```

**Example 2:**

```text
Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
```

**Example 3:**

```
Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2
```

**Example 4:**

```text
Input: points = [[1,2]]
Output: 1
```

**Example 5:**

```text
Input: points = [[2,3],[2,3]]
Output: 1
```

**Constraints:**

- `0 <= points.length <= 104`
- `points.length == 2`
- `-231 <= xstart < xend <= 231 - 1`

## Remove Duplicate Letters (Sept. 11th)

Given a string `s`, remove duplicate letters so that every letter appears once and only once. You must make sure your result is **the smallest in lexicographical order** among all possible results.

**Note:** This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

**Example 1:**

```
Input: s = "bcabc"
Output: "abc"
```

**Example 2:**

```
Input: s = "cbacdcbc"
Output: "acdb"
```

**Constraints:**

- `1 <= s.length <= 104`
- `s` consists of lowercase English letters.

**Hint #1:**

Greedily try to add one missing character. How to check if adding some character will not cause problems ? Use bit-masks to check whether you will be able to complete the sub-sequence if you add the character at some index i.

## Buddy Strings (Sept. 12th)

Given two strings `A` and `B` of lowercase letters, return `true` if you can swap two letters in `A` so the result is equal to `B`, otherwise, return `false`.

Swapping letters is defined as taking two indices `i` and `j` (0-indexed) such that `i != j` and swapping the characters at `A[i]` and `A[j]`. For example, swapping at indices `0` and `2` in `"abcd"` results in `"cbad"`.

**Example 1:**

```
Input: A = "ab", B = "ba"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
```

**Example 2:**

```
Input: A = "ab", B = "ab"
Output: false
Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.
```

**Example 3:**

```
Input: A = "aa", B = "aa"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.
```

**Example 4:**

```
Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
```

**Example 5:**

```
Input: A = "", B = "aa"
Output: false
```

**Constraints:**

- `0 <= A.length <= 20000`
- `0 <= B.length <= 20000`
- `A` and `B` consist of lowercase letters.
   
## Sort List (Sept. 13th)

Given the `head` of a linked list, return the list after sorting it in ***ascending order***.

**Follow up:** Can you sort the linked list in `O(n logn)` time and `O(1)` memory (i.e. constant space)?

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/09/14/sort_list_1.jpg)

```
Input: head = [4,2,1,3]
Output: [1,2,3,4]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/09/14/sort_list_2.jpg)

```
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
```

**Example 2:**

```
Input: head = []
Output: []
```

**Constraints:**

- The number of nodes in the list is in the range `[0, 5 * 104]`.
- `-105 <= Node.val <= 105`

## House Robber II (Sept. 14th)

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are ***arranged in a circle***. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and ***it will automatically contact the police if two adjacent houses were broken into on the same night***.

Given a list of non-negative integers `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight ***without alerting the police***.

**Example 1:**

```
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
```

**Example 2:**

```
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
```

**Example 3:**

```
Input: nums = [0]
Output: 0
```

**Constraints:**

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 1000`