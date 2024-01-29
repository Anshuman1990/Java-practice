# Recursion Algorithm

### 1. Algorithm Overview

#### 1.1 Description

A recursive algorithm is a problem-solving approach that solves a problem by solving smaller instances of the same problem. It involves breaking down a complex problem into simpler subproblems, solving each subproblem, and combining their solutions to obtain the solution to the original problem.

The process in which a function calls itself directly or indirectly is called recursion and the corresponding function is called a recursive function. Using a recursive algorithm, certain problems can be solved quite easily. Examples of such problems are Towers of Hanoi (TOH), Inorder/Preorder/Postorder Tree Traversals, DFS of Graph, etc. A recursive function solves a particular problem by calling a copy of itself and solving smaller subproblems of the original problems. Many more recursive calls can be generated as and when required. It is essential to know that we should provide a certain case in order to terminate this recursion process. So we can say that every time the function calls itself with a simpler version of the original problem.
#### 1.2 Purpose

The purpose of the algorithm is to provide a clear and concise way of solving problems that can be naturally divided into smaller, similar subproblems.

### 2. Pseudocode

Provide pseudocode that outlines the steps of the Recursive Algorithm.

```plaintext
procedure RecursiveAlgorithm(problem):
    if problem is small enough:
        solve problem directly
    else:
        divide problem into smaller subproblems
        solve each subproblem recursively
        combine solutions of subproblems to solve the original problem
```

### 3. Time Complexity

The time complexity of a recursive algorithm depends on the number of recursive calls and the work done per call. Let's discuss a few common examples with their time complexities using Java.

1. **Factorial Calculation:**
   ```java
   public class Factorial {
       public static int factorial(int n) {
           if (n == 0 || n == 1) {
               return 1;
           } else {
               return n * factorial(n - 1);
           }
       }

       public static void main(String[] args) {
           int result = factorial(5);
           System.out.println("Factorial of 5 is: " + result);
       }
   }
   ```
   Time Complexity: O(n) - Each recursive call decrements `n` by 1 until it reaches the base case.

2. **Fibonacci Series:**
   ```java
   public class Fibonacci {
       public static int fibonacci(int n) {
           if (n <= 1) {
               return n;
           } else {
               return fibonacci(n - 1) + fibonacci(n - 2);
           }
       }

       public static void main(String[] args) {
           int result = fibonacci(6);
           System.out.println("Fibonacci of 6 is: " + result);
       }
   }
   ```
   Time Complexity: O(2^n) - Each call leads to two more recursive calls, resulting in an exponential time complexity.

3. **Binary Search:**
   ```java
   public class BinarySearch {
       public static int binarySearch(int[] arr, int low, int high, int target) {
           if (low <= high) {
               int mid = low + (high - low) / 2;
               if (arr[mid] == target) {
                   return mid;
               } else if (arr[mid] < target) {
                   return binarySearch(arr, mid + 1, high, target);
               } else {
                   return binarySearch(arr, low, mid - 1, target);
               }
           }
           return -1; // Element not found
       }

       public static void main(String[] args) {
           int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
           int target = 6;
           int result = binarySearch(arr, 0, arr.length - 1, target);
           System.out.println("Index of " + target + " is: " + result);
       }
   }
   ```
   Time Complexity: O(log n) - Each recursive call divides the search space in half.

It's important to note that recursive algorithms might suffer from issues like stack overflow for large inputs. In practice, some recursive algorithms can be converted to iterative ones to avoid this problem and improve efficiency.

Example:
- O(2^n) for a naive recursive approach to certain problems, but it can be improved with memoization or dynamic programming.

### 4. Space Complexity

The space complexity of a recursive algorithm is determined by the amount of memory required for the function call stack. Each recursive call adds a new frame to the call stack, and the space complexity is related to the maximum depth of the stack during the execution of the algorithm.

Let's look at examples and discuss their space complexities in Java:

1. **Factorial Calculation:**
   ```java
   public class Factorial {
       public static int factorial(int n) {
           if (n == 0 || n == 1) {
               return 1;
           } else {
               return n * factorial(n - 1);
           }
       }

       public static void main(String[] args) {
           int result = factorial(5);
           System.out.println("Factorial of 5 is: " + result);
       }
   }
   ```
   Space Complexity: O(n) - The maximum depth of the call stack is equal to the value of `n`.

2. **Fibonacci Series:**
   ```java
   public class Fibonacci {
       public static int fibonacci(int n) {
           if (n <= 1) {
               return n;
           } else {
               return fibonacci(n - 1) + fibonacci(n - 2);
           }
       }

       public static void main(String[] args) {
           int result = fibonacci(6);
           System.out.println("Fibonacci of 6 is: " + result);
       }
   }
   ```
   Space Complexity: O(n) - The maximum depth of the call stack is equal to the value of `n`.

3. **Binary Search:**
   ```java
   public class BinarySearch {
       public static int binarySearch(int[] arr, int low, int high, int target) {
           if (low <= high) {
               int mid = low + (high - low) / 2;
               if (arr[mid] == target) {
                   return mid;
               } else if (arr[mid] < target) {
                   return binarySearch(arr, mid + 1, high, target);
               } else {
                   return binarySearch(arr, low, mid - 1, target);
               }
           }
           return -1; // Element not found
       }

       public static void main(String[] args) {
           int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
           int target = 6;
           int result = binarySearch(arr, 0, arr.length - 1, target);
           System.out.println("Index of " + target + " is: " + result);
       }
   }
   ```
   Space Complexity: O(log n) - The maximum depth of the call stack is log(n) in the binary search algorithm.

It's important to consider both time and space complexity when analyzing the efficiency of recursive algorithms. Some recursive algorithms can be optimized to reduce space complexity, such as using memoization or dynamic programming techniques.

Example:
- O(n) for the depth of the recursion stack, but it depends on the specific problem and optimizations.

### 5. Implementation

Provide a sample implementation of a Recursive Algorithm in Java. For example, the following code demonstrates calculating the factorial of a number using recursion:

```java
public class RecursiveFactorial {

    public static void main(String[] args) {
        int number = 5;
        long result = factorial(number);
        System.out.println("Factorial of " + number + " = " + result);
    }

    // Recursive algorithm to calculate factorial
    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
```

### 6. Use Cases

Describe scenarios or types of problems for which the Recursive Algorithm is suitable.

Example:
- Traversing tree structures, calculating Fibonacci sequence, solving problems with optimal substructure.

### 7. Advantages and Disadvantages

#### 7.1 Advantages

- Clear and intuitive solution for certain types of problems.
- Elegant representation of certain algorithms.

#### 7.2 Disadvantages

- May lead to inefficient solutions for large problems.
- Risk of stack overflow for deep recursion.

### 8. Examples

Provide examples of other problems that can be solved using Recursive Algorithms.

Example:
- Tower of Hanoi problem, binary tree traversals, quicksort algorithm.

### 9. References

Include any references or sources that were consulted during the algorithm design and documentation process.

### 10. Author

Include information about the person or team that developed the algorithm and wrote the documentation.

---

This template provides a basic structure for documenting a Recursive Algorithm. Depending on the algorithm, you may need to add or modify sections to provide comprehensive documentation.