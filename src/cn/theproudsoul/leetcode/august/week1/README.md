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