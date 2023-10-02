package com.practice.leetcode;

public class LC646 {

/*
    Question:-
    You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
    A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
    Return the length longest chain which can be formed.
     You do not need to use up all the given intervals. You can select pairs in any order.
     Example 1:
    Input: pairs = [[1,2],[2,3],[3,4]]
    Output: 2
    Explanation: The longest chain is [1,2] -> [3,4].

    Example 2:
    Input: pairs = [[1,2],[7,8],[4,5]]
    Output: 3
    Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
    Constraints:
    n == pairs.length
    1 <= n <= 1000
    -1000 <= lefti < righti <= 1000
    Related Topics
    Array
    Dynamic Programming
    Greedy
    Sorting
    */
    public static void main(String[] args) {
        LC646 lc646 = new LC646();
        int [][] pairs = {{9,10},{1,2},{4,5},{7,8}};
        System.out.println(lc646.findLongestChain(pairs));
    }
    public int findLongestChain(int[][] pairs) {
        int _l = 0;
        int _r=0;
        sortedPairs(pairs);
        return 1;
    }

    int[][] sortedPairs(int[][] pairs) {
        System.out.println("pairs length= "+pairs.length);
        int [][] sortedPairs = new int[2][pairs.length];
        for(int i =0; i<pairs.length;i++){
            int l = pairs[i][0];
            int r = pairs[i][1];
            System.out.println(l+","+r);
            int index = -1;
            int difference = 0;
            for(int j=i+1; j < pairs.length;j++){
                 int localDifference = pairs[j][0] - r;
                System.out.println(j+">>>>>>>>>>>>>>>>>>>>>>>>>>"+pairs[j][0]+","+pairs[j][1]);
                System.out.println(">>>>>>>>>>>localDifference>>>>>>>>>>"+localDifference+">>>>>>>>>>>difference>>>>>>>>>>>"+difference);
                if(localDifference > difference){
                    if(index > 0){
                        index++;
                    }
                    index = 0;
                } else {
                    index = j;
                }
                difference = localDifference;
                System.out.println(index);
            }
        }
        return sortedPairs;
    }
}
