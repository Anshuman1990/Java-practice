# Brute Force Algorithm
	
   In computer science, brute-force search or exhaustive search, also known as generate and test, is a very general problem-solving technique 
   and algorithmic paradigm that consists of systematically checking all possible candidates for whether or not each candidate satisfies the problem's statement.
	
A brute-force algorithm that finds the divisors of a natural number n would enumerate all integers from 1 to n, and check whether each of them divides n without remainder.A brute-force approach for the eight queens puzzle would examine all possible arrangements of 8 pieces on the 64-square chessboard and for each arrangement, check whether each (queen) piece can attack any other.

While a brute-force search is simple to implement and will always find a solution if it exists, implementation costs are proportional to the number of candidate solutions – which in many practical problems tends to grow very quickly as the size of the problem increases (§Combinatorial explosion).Therefore, brute-force search is typically used when the problem size is limited, or when there are problem-specific heuristics that can be used to reduce the set of candidate solutions to a manageable size. The method is also used when the simplicity of implementation is more important than processing speed.

A brute force algorithm is a straightforward approach to solving a problem that relies on trying all possible solutions systematically. This method is often used when the problem size is small, and the time and computational resources required for exhaustive search are reasonable. Below is a basic documentation template that you can use to document a brute force algorithm:

In this article, we will discuss what is Brute Force Algorithm and what are its pros and cons. Below given are some features of the brute force algorithm are:
- It is an intuitive, direct, and straightforward technique of problem-solving in which all the possible ways or all the possible solutions to a given problem are enumerated.
- Many problems solved in day-to-day life using the brute force strategy, for example exploring all the paths to a nearby market to find the minimum shortest path.
- Arranging the books in a rack using all the possibilities to optimize the rack spaces, etc.
- In fact, daily life activities use a brute force nature, even though optimal algorithms are also possible.


### 1. Algorithm Overview

#### 1.1 Description

The brute force algorithm exhaustively searches through all possible solutions to a problem until a satisfactory solution is found.

#### 1.2 Purpose

The purpose of the algorithm is to find an optimal or acceptable solution to a problem by considering every possible combination.

### 2. Pseudocode

Provide pseudocode that outlines the steps of the brute force algorithm.

```plaintext
procedure BruteForceAlgorithm(problem):
    for each possible solution in the solution space:
        if solution meets problem criteria:
            return solution
    return no solution found
```

### 3. Time Complexity

The time complexity of a brute-force algorithm is often expressed in Big O notation, which describes the upper bound on the growth rate of the algorithm's time requirements relative to the input size. The time complexity depends on how the algorithm explores the solution space and the number of possible solutions it needs to examine.

Common time complexities for brute-force algorithms include:

1. **O(2^n):** This is common for algorithms that consider all subsets of a set. Each element in the set can be included or excluded, leading to an exponential growth in the number of possibilities.

   Example:
	- Subset Sum Problem.

2. **O(n!):** This occurs when the algorithm generates all permutations of a set. The number of permutations grows factorially with the size of the input.

   Example:
	- Traveling Salesman Problem.

3. **O(n^k):** In some cases, the brute-force algorithm may involve nested loops or recursive calls, resulting in polynomial time complexity.

   Example:
	- Brute-force matrix multiplication.

It's important to note that brute-force algorithms are generally not efficient for large input sizes due to their exponential or factorial growth rates. They are more suitable for small problem instances where the exhaustive search is feasible and acceptable.

When analyzing the time complexity, consider the number of iterations or recursive calls made by the algorithm in terms of the input size. Additionally, factor in any pruning techniques or optimizations that might reduce the search space, as these can significantly impact the actual performance of the algorithm.

Example:
- O(n!) for a permutation problem where n is the size of the problem.

### 4. Space Complexity

The space complexity of a brute-force algorithm is a measure of the amount of memory or storage required by the algorithm relative to the input size. Unlike time complexity, which focuses on the computational time needed, space complexity looks at the additional memory resources consumed during the execution of the algorithm.

The space complexity is often expressed using Big O notation, indicating the upper bound on the growth rate of the algorithm's space requirements concerning the input size. The space complexity can vary depending on the specific details of the algorithm, including data structures used, recursion depth, and auxiliary variables.

Common scenarios for space complexity in brute-force algorithms include:

1. **Constant Space (O(1)):** Some brute-force algorithms use a fixed amount of memory that does not depend on the input size. This is typical when the algorithm does not use any additional data structures or when the memory required remains constant regardless of the input.

   Example:
	- Checking a condition in a loop without using additional memory.

2. **Linear Space (O(n)):** In some cases, the space complexity may grow linearly with the input size. This often occurs when the algorithm uses an array or other data structure to store intermediate results for each input element.

   Example:
	- Storing intermediate solutions in an array during the algorithm execution.

3. **Exponential or Factorial Space (O(2^n) or O(n!)):** Algorithms that generate all combinations or permutations may require an exponential or factorial amount of space to store intermediate results.

   Example:
	- Storing all subsets or permutations of a set.

It's important to consider the trade-off between time and space complexity. Brute-force algorithms may consume a significant amount of memory, especially when exploring a large solution space. In practice, optimizing space usage is crucial, and sometimes it's possible to make trade-offs between time and space efficiency. Additionally, some brute-force algorithms may benefit from dynamic programming techniques to reduce space requirements by memoizing and reusing intermediate results.

Example:
- O(1) for constant space if no additional data structures are used.

### 5. Implementation

A brute-force algorithm is a straightforward approach that systematically explores all possible solutions to a problem. Here's a simple example of a brute-force algorithm to solve the Subset Sum problem in Java:

```java
import java.util.ArrayList;
import java.util.List;

public class BruteForceSubsetSum {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int targetSum = 9;

        List<Integer> subset = findSubset(numbers, targetSum);

        if (subset.isEmpty()) {
            System.out.println("No subset found with the target sum.");
        } else {
            System.out.println("Subset with the target sum: " + subset);
        }
    }

    // Brute-force algorithm to find a subset with the target sum
    private static List<Integer> findSubset(int[] numbers, int targetSum) {
        List<Integer> subset = new ArrayList<>();
        boolean[] currentSubset = new boolean[numbers.length];

        while (true) {
            // Add numbers to the current subset based on the boolean array
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (currentSubset[i]) {
                    sum += numbers[i];
                    subset.add(numbers[i]);
                }
            }

            // Check if the current subset has the target sum
            if (sum == targetSum) {
                return subset;
            }

            // Generate the next subset
            int i = 0;
            while (i < numbers.length && currentSubset[i]) {
                currentSubset[i] = false;
                i++;
            }

            if (i == numbers.length) {
                break; // All subsets generated
            }

            currentSubset[i] = true;
            subset.clear(); // Clear the previous subset
        }

        return new ArrayList<>(); // No subset found with the target sum
    }
}
```

In this example, the `findSubset` method uses a brute-force approach to generate all possible subsets of the given array of numbers and checks if any subset has the target sum. The algorithm uses a boolean array `currentSubset` to represent the inclusion/exclusion of each element in the subset. The process continues until a subset with the target sum is found or all possible subsets are examined.

Keep in mind that brute-force algorithms might not be efficient for large problem sizes, and more sophisticated algorithms are often preferred.

### 6. Use Cases

Describe scenarios or types of problems for which the brute force algorithm is suitable.

Example:
- Small problem sizes where the exhaustive search is feasible.

### 7. Pros and Cons

#### 7.1 Pros

1. The brute force approach is a guaranteed way to find the correct solution by listing all the possible candidate solutions for the problem.
2. It is a generic method and not limited to any specific domain of problems.
3. The brute force method is ideal for solving small and simpler problems.
4. It is known for its simplicity and can serve as a comparison benchmark.

#### 7.2 Cons

1. The brute force approach is inefficient. For real-time problems, algorithm analysis often goes above the O(N!) order of growth.
2. This method relies more on compromising the power of a computer system for solving a problem than on a good algorithm design.
3. Brute force algorithms are slow.
4. Brute force algorithms are not constructive or creative compared to algorithms that are constructed using some other design paradigms.

### 8. Conclusion
Brute force algorithm is a technique that guarantees solutions for problems of any domain helps in solving the simpler problems and also provides a solution that can serve as a benchmark for evaluating other design techniques, but takes a lot of run time and inefficient.
### 9. Examples

Provide examples of problems where a brute force algorithm is an appropriate solution.

Example:
- Traveling Salesman Problem for a small number of cities.

### 10. References

Include any references or sources that were consulted during the algorithm design and documentation process.

### 11. Author

Include information about the person or team that developed the algorithm and wrote the documentation.

---

This template provides a basic structure for documenting a brute force algorithm. Depending on the complexity of your specific algorithm, you may need to add or modify sections to provide comprehensive documentation.