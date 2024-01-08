# Hashing Algorithm
Below is a documentation template for a Hashing Algorithm, along with a Java example of implementing a basic hash table. This example focuses on demonstrating the concept of hashing and handling collisions using separate chaining.

## Hashing Algorithm Documentation

### 1. Algorithm Overview

#### 1.1 Description

Hashing is a technique used to map data of arbitrary size to a fixed-size array, called a hash table, using a hash function. The hash function computes a hash code that determines the index where the data will be stored in the hash table.

#### 1.2 Purpose

The purpose of the algorithm is to efficiently store, retrieve, and search for data by converting it into a fixed-size representation.

### 2. Pseudocode

Provide pseudocode that outlines the steps of the Hashing Algorithm.

```plaintext
procedure HashingAlgorithm(data, hashTable):
    hashValue = hashFunction(data)
    index = hashValue % tableSize
    
    // Handling collisions using separate chaining
    if hashTable[index] is empty:
        create a new linked list and insert data
    else:
        traverse the linked list and insert data if not already present
```

### 3. Time Complexity

Describe the time complexity of the algorithm in terms of Big O notation. Discuss how the time complexity is influenced by the size of the hash table and the efficiency of the hash function.

Example:
- O(1) for ideal cases (constant time), but it depends on the quality of the hash function and the handling of collisions.

### 4. Space Complexity

Describe the space complexity of the algorithm in terms of Big O notation. Discuss how the space complexity scales with the size of the hash table.

Example:
- O(n) for the hash table size, where n is the number of stored elements.

### 5. Implementation

Provide a sample implementation of a Hashing Algorithm in Java. For example, the following code demonstrates a basic hash table with separate chaining:

```java
import java.util.LinkedList;

public class HashTable {

    private static final int TABLE_SIZE = 10;
    private LinkedList<String>[] table;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(String data) {
        int hash = 0;
        for (char c : data.toCharArray()) {
            hash += c;
        }
        return hash;
    }

    public void insert(String data) {
        int index = hashFunction(data) % TABLE_SIZE;
        table[index].add(data);
    }

    public boolean search(String data) {
        int index = hashFunction(data) % TABLE_SIZE;
        return table[index].contains(data);
    }

    public void display() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("Index " + i + ": ");
            for (String item : table[i]) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert("Alice");
        hashTable.insert("Bob");
        hashTable.insert("Charlie");
        hashTable.insert("Dave");
        hashTable.insert("Eve");

        System.out.println("Hash Table Contents:");
        hashTable.display();

        String searchData = "Charlie";
        System.out.println("Search for '" + searchData + "': " + hashTable.search(searchData));
    }
}
```

### 6. Use Cases

Describe scenarios or types of problems for which the Hashing Algorithm is suitable.

Example:
- Storing and retrieving data efficiently, implementing symbol tables, databases, caches.

### 7. Advantages and Disadvantages

#### 7.1 Advantages

- Fast retrieval and storage of data.
- Suitable for scenarios with a large dataset.

#### 7.2 Disadvantages

- Handling collisions might add complexity.
- Quality of the hash function is crucial for optimal performance.

### 8. Examples

Provide examples of other problems that can be solved using Hashing Algorithms.

Example:
- Password storage, URL shortening services, spell checkers.

### 9. References

Include any references or sources that were consulted during the algorithm design and documentation process.

### 10. Author

Include information about the person or team that developed the algorithm and wrote the documentation.

---

This template provides a basic structure for documenting a Hashing Algorithm. Depending on the algorithm, you may need to add or modify sections to provide comprehensive documentation.