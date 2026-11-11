# LeetCode 172 --- Factorial Trailing Zeroes

**Difficulty:** Medium\
**Topics:** Math, Number Theory\
**Language:** Java\
**Time Complexity:** O(log₅ n)\
**Space Complexity:** O(1)

## Problem Statement

Given an integer `n`, return the number of trailing zeroes in `n!`.

A trailing zero is a zero at the end of a number.

Examples: - `3! = 6` has 0 trailing zeroes. - `5! = 120` has 1 trailing
zero. - `10! = 3628800` has 2 trailing zeroes.

**Constraint:** `0 <= n <= 10^4`

## Java Solution

``` java
class Solution {
    public int trailingZeroes(int n) {

        int count = 0;

        while (n >= 5) {
            n /= 5;
            count += n;
        }

        return count;
    }
}
```

## 1. Key Observation

A trailing zero is formed by multiplying `10`.

`10 = 2 * 5`

Therefore, every trailing zero requires one pair of factors: one `2` and
one `5`.

In a factorial, factors of `2` occur more frequently than factors of
`5`. For that reason, factors of `5` are the limiting factor.

**Instead of calculating the factorial, we only need to count how many
factors of `5` occur in `n!`.**

## 2. Why Do We Divide by 5 Repeatedly?

First, count the multiples of `5` between `1` and `n`. Every multiple of
`5` contributes at least one factor of `5`.

The count of multiples of `5` is:

`floor(n / 5)`

However, this is not enough. Multiples of `25` contribute an additional
factor of `5`, because:

`25 = 5 * 5`

Multiples of `125` contribute yet another additional factor, because:

`125 = 5 * 5 * 5`

So the complete formula is:

``` text
Trailing zeroes = floor(n / 5)
                + floor(n / 25)
                + floor(n / 125)
                + floor(n / 625)
                + ...
```

Continue until the divisor becomes greater than `n`.

### How the loop implements this formula

``` java
while (n >= 5) {
    n /= 5;
    count += n;
}
```

On each iteration, `n` is divided by `5`. The values added to `count`
are equivalent to:

-   `floor(originalN / 5)`
-   `floor(originalN / 25)`
-   `floor(originalN / 125)`
-   and so on.

This counts every factor of `5`, including the extra factors contributed
by multiples of `25`, `125`, etc.

## 3. Step-by-Step Dry Run --- `n = 25`

We need to find the number of trailing zeroes in `25!`.

Initial values:

``` text
n = 25
count = 0
```

  Iteration   Division     Updated n   Added to count   Total count
  ----------- ---------- ----------- ---------------- -------------
  1           25 / 5               5                5             5
  2           5 / 5                1                1             6

Now `n = 1`, so `n >= 5` is false and the loop stops.

**Output: `6`**

Using the formula:

`floor(25 / 5) + floor(25 / 25) = 5 + 1 = 6`

Why is there an extra count? The number `25` contains two factors of
`5`, while ordinary multiples of `5` contribute only one.

## 4. More Examples

### Example A: `n = 5`

`floor(5 / 5) = 1`

`5! = 120`, so the answer is **1**.

### Example B: `n = 10`

`floor(10 / 5) = 2`

There are two factors of `5` in `10!`, so the answer is **2**.

### Example C: `n = 100`

`floor(100 / 5) + floor(100 / 25) = 20 + 4 = 24`

The answer is **24**.

### Example D: `n = 0`

The loop never executes because `0 < 5`. `count` remains `0`, so the
answer is **0**.

## 5. Why Choose This Method?

### Approach 1: Calculate the factorial --- Not recommended

One possible approach is to calculate `n!` and then count the zeroes at
the end.

This is unsuitable because factorial values grow extremely quickly.
Standard integer types overflow for relatively small values of `n`.
Using a large-number type would also be unnecessary work.

### Approach 2: Check every number from `1` to `n` --- Less efficient

We could inspect every number, count its factors of `5`, and add them.

This works, but takes O(n) time.

### Approach 3: Repeated division by `5` --- Optimal

Instead of visiting every number, we count all multiples of `5`, then
all multiples of `25`, then `125`, and so on.

This takes only logarithmically many iterations and uses constant extra
space.

**That is why repeated division by `5` is the preferred method.**

## 6. Complexity Analysis

### Time Complexity: O(log₅ n)

In every iteration, `n` is divided by `5`. Therefore, the loop runs
approximately log base 5 of `n` times.

For example, even for `n = 10,000`, the loop executes only a small
number of times.

### Space Complexity: O(1)

Only one extra variable, `count`, is used. No arrays, lists, or other
data structures are required.

## 7. Important Edge Cases

    Input   Expected Output Reason
  ------- ----------------- ----------------------------------------
      `0`               `0` 0! = 1
      `1`               `0` No factor of 5
      `4`               `0` No multiple of 5
      `5`               `1` One multiple of 5
     `25`               `6` Includes the extra factor from 25
    `125`              `31` Includes extra factors from 25 and 125
    `100`              `24` 20 + 4

## 8. Final Takeaway

The central idea is that every trailing zero requires one factor of `2`
and one factor of `5`. Since factorials contain more factors of `2` than
factors of `5`, counting factors of `5` is sufficient.

Remember this pattern:

1.  Divide by `5` to count multiples of `5`.
2.  Divide again by `5` to count the additional factors contributed by
    multiples of `25`.
3.  Continue for `125`, `625`, and so on.
4.  Add all the quotients.

In mathematical notation, the answer is the sum of:

`floor(n / 5) + floor(n / 25) + floor(n / 125) + ...`

**Interview tip:** Whenever a problem asks for trailing zeroes in a
factorial, think about the prime factors of `10` (`2 * 5`) and identify
which factor is less frequent. Here, that factor is `5`.
