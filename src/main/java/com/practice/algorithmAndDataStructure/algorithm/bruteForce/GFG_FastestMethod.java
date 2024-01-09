package com.practice.algorithmAndDataStructure.algorithm.bruteForce;
/**
 * Geek lives in a multi-story building. Everyday he has to get from the Nth floor to the ground floor. He has three options to come down,
 *
 * the lift,
 * the stairs or
 * the escalator.
 * He has different speeds for the lift, the stairs and the escalator which are V1 m/s, V2 m/s and V3 m/s respectively.
 * Assuming each floor has a height of 1m and the stairs and the escalator are inclined at an angle of 45 degrees.
 * Find out which is the fastest way for Geek to reach the ground floor.
 * If any of the methods consume same time, give preference to lift, then stairs and then escalator.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 5, V1 = 1, V2 = 2, V3 = 3
 * Output: 3
 * Explaination: Option 3, ie the escalator
 * will be the fastest.
 *
 * Example 2:
 *
 * Input:
 * N = 5, V1 = 3, V2 = 2, V3 = 1
 * Output: 1
 * Explaination: Option 2, ie the lift
 * will be the fastest.
 *
 * Your Task:
 * You do not need to read input or print anything. Your task is to complete the function fastest() which takes N, V1, V2 and V3 as input parameters and returns 1, 2 or 3 if lift, stair or escalator is the fastes way respectively.
 *
 *
 * Expected Time Complexity: O(1)
 * Expected Auxiliary Space: O(1)
 *
 *
 * Constraints:
 * 1 ≤ N ≤ 1000
 * 1 ≤ V1, V2, V3 ≤ 1000
 * */
public class GFG_FastestMethod {
    public static void main(String[] args) {
        System.out.println(fastest(5, 1,2,3));
    }

    static int fastest(int N, int V1, int V2, int V3)
    {
        int v1 = N*V1;
        int v2 = N*V2;
        int v3 = N*V3;
        System.out.println(v1+","+v2+","+v3);

        if(v1>v2 && v1>v3){
            return 1;
        }
        if(v2>v1 && v2>=v3){
            return 2;
        }
        if(v3>v1 && v3>v2){
            return 3;
        }
        return 0;
    }
}
