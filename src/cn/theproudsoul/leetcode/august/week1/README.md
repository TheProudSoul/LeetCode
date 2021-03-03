# Week 1: August 1st - August 7th

## Detect Capital (August 1st)

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

1. All letters in this word are capitals, like "USA".
2. All letters in this word are not capitals, like "leetcode".
3. Only the first letter in this word is capital, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way. 

**Example 1:**

```
Input: "USA"
Output: True
```

**Example 2:**

```
Input: "FlaG"
Output: False
```

**Note:** The input will be a non-empty word consisting of uppercase and lowercase latin letters.

## Design HashSet (August 2nd)

Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

- `add(value)`: Insert a value into the HashSet. 
- `contains(value)` : Return whether the value exists in the HashSet or not.
- `remove(value)`: Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

**Example:**

```java
MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)
```

**Note:**

All values will be in the range of `[0, 1000000]`.
The number of operations will be in the range of `[1, 10000]`.
Please do not use the built-in HashSet library.

## Valid Palindrome (August 3rd)

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

**Note:** For the purpose of this problem, we define empty string as valid palindrome.

**Example 1:**

```
Input: "A man, a plan, a canal: Panama"
Output: true
```

**Example 2:**

```
Input: "race a car"
Output: false
```


**Constraints:**

- `s` consists only of printable ASCII characters.

## Power of Four (August 4th)

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

**Example 1:**

```
Input: 16
Output: true
```

**Example 2:**

```
Input: 5
Output: false
```

**Follow up:** Could you solve it without loops/recursion?

## Add and Search Word - Data structure design (August 5th)

Design a data structure that supports the following two operations:

```java
void addWord(word)
bool search(word)
```

`search(word)` can search a literal word or a regular expression string containing only letters `a-z` or `.`. A `.` means it can represent any one letter.

**Example:**

```java
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
```

**Note:**

You may assume that all words are consist of lowercase letters `a-z`.

## Find All Duplicates in an Array (August 6th)

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear **twice** and others appear **once**.

Find all the elements that appear **twice** in this array.

Could you do it without extra space and in O(n) runtime?

Example:

```
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
```

## Vertical Order Traversal of a Binary Tree (August 7th)

Given a binary tree, return the *vertical order* traversal of its nodes values.

For each node at position `(X, Y)`, its left and right children respectively will be at positions `(X-1, Y-1)` and `(X+1, Y-1)`.

Running a vertical line from `X = -infinity` to `X = +infinity`, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing `Y` coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of `X` coordinate.  Every report will have a list of values of nodes.

**Example 1:**

![](https://assets.leetcode.com/uploads/2019/01/31/1236_example_1.PNG)

```
Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2019/01/31/tree2.png)

```
Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
```

**Note:**

1. The tree will have between 1 and 1000 nodes.
2. Each node's value will be between 0 and 1000.