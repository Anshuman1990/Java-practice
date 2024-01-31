package  com.practice.java8_17.leetcode;
//Given two strings needle and haystack, return the index of the first
//occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//
// Example 1:
//
//
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
//
//
// Example 2:
//
//
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
//
//
//
// Constraints:
//
//
// 1 <= haystack.length, needle.length <= 10⁴
// haystack and needle consist of only lowercase English characters.
//
//
// Related Topics Two Pointers String String Matching 👍 5292 👎 327
public class LC28 {
    public static void main(String[] args) {
        LC28 lc28 = new LC28();
        System.out.println(lc28.strStr("adasasad", "sad"));
    }
    public int strStr(String haystack, String needle) {
        int index = -1;
        if(haystack.contains(needle)){
            return haystack.indexOf(needle, 0);
        }
        return index;
    }
}
