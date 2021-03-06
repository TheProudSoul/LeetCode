# Week 3: September 15th - September 21st

## Length of Last Word (Sept. 15th)

Given a string s consists of upper/lower-case alphabets and empty space characters `' '`, return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

**Note:** A word is defined as a **maximal substring** consisting of non-space characters only.

**Example:**

```
Input: "Hello World"
Output: 5
```

## Maximum XOR of Two Numbers in an Array (Sept. 16th)

Given an integer array `nums`, return the maximum result of `nums[i] XOR nums[j]`, where `0 ≤ i ≤ j < n`.

**Follow up:** Could you do this in `O(n)` runtime?

**Example 1:**

```
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
```

**Example 2:**

```
Input: nums = [0]
Output: 0
```

**Example 3:**

```
Input: nums = [2,4]
Output: 6
```

**Example 4:**

```
Input: nums = [8,10,2]
Output: 10
```

**Example 5:**

```
Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
```

**Constraints:**

- `1 <= nums.length <= 2 * 104`
- `0 <= nums[i] <= 231 - 1`

## Robot Bounded In Circle (Sept. 17th)

On an infinite plane, a robot initially stands at `(0, 0)` and faces north.  The robot can receive one of three instructions:

- `"G"`: go straight 1 unit;
- `"L"`: turn 90 degrees to the left;
- `"R"`: turn 90 degress to the right.

The robot performs the `instructions` given in order, and repeats them forever.

Return `true` if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

**Example 1:**

```
Input: "GGLLGG"
Output: true
Explanation: 
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
```

**Example 2:**

```
Input: "GG"
Output: false
Explanation: 
The robot moves north indefinitely.
```

**Example 3:**

```
Input: "GL"
Output: true
Explanation: 
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
```

**Note:**

1. `1 <= instructions.length <= 100`
2. `instructions[i]` is in `{'G', 'L', 'R'}`

**Hint #1:**

Calculate the final vector of how the robot travels after executing all instructions once - it consists of a change in position plus a change in direction.

**Hint #2:**

The robot stays in the circle iff (looking at the final vector) it changes direction (ie. doesn't stay pointing north), or it moves 0.

## Best Time to Buy and Sell Stock (Sept. 18th)

Say you have an array for which the *ith* element is the price of a given stock on day *i*.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

**Example 1:**

```
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
```

**Example 2:**

```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

## Sequential Digits (Sept. 19th)

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a **sorted** list of all the integers in the range `[low, high]` inclusive that have sequential digits.

 

**Example 1:**

```
Input: low = 100, high = 300
Output: [123,234]
```

**Example 2:**

```
Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
```

**Constraints:**

- `10 <= low <= high <= 10^9`

**Hint #1:**

Generate all numbers with sequential digits and check if they are in the given range.

**Hint #2:**

Fix the starting digit then do a recursion that tries to append all valid digits.

## Unique Paths III (Sept. 20th)

On a 2-dimensional `grid`, there are 4 types of squares:

- `1` represents the starting square.  There is exactly one starting square.
- `2` represents the ending square.  There is exactly one ending square.
- `0` represents empty squares we can walk over.
- `-1` represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that **walk over every non-obstacle square exactly once**.

**Example 1:**

```
Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
```

**Example 2:**

```
Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
```

**Example 3:**

```
Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
```

**Note:**

1. `1 <= grid.length * grid[0].length <= 20`

## Car Pooling (Sept. 21st)

You are driving a vehicle that has `capacity` empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of `trips`, `trip[i] = [num_passengers, start_location, end_location]` contains information about the `i`-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return `true` if and only if it is possible to pick up and drop off all passengers for all the given trips. 

**Example 1:**

```
Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
```

**Example 2:**

```
Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
```

**Example 3:**

```
Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
```

**Example 4:**

```
Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
```

**Constraints:**

- `trips.length <= 1000`
- `trips[i].length == 3`
- `1 <= trips[i][0] <= 100`
- `0 <= trips[i][1] < trips[i][2] <= 1000`
- `1 <= capacity <= 100000`
