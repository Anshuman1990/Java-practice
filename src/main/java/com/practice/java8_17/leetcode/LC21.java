package com.practice.java8_17.leetcode;

//You are given the heads of two sorted linked lists list1 and list2.
//
// Merge the two lists into one sorted list. The list should be made by
//splicing together the nodes of the first two lists.
//
// Return the head of the merged linked list.
//
//
// Example 1:
//
//
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//
//
// Example 2:
//
//
//Input: list1 = [], list2 = []
//Output: []
//
//
// Example 3:
//
//
//Input: list1 = [], list2 = [0]
//Output: [0]
//
//
//
// Constraints:
//
//
// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both list1 and list2 are sorted in non-decreasing order.
//
//
// Related Topics Linked List Recursion 👍 20822 👎 1972




public class LC21 {

    public static void main(String[] args) {
        LC21 lc21 = new LC21();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode.display(lc21.mergeTwoLists(list1, list2));
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(list1 != null || list2 != null){
            int v1 = (list1 == null? Integer.MAX_VALUE : list1.val);
            int v2 = (list2 == null? Integer.MAX_VALUE : list2.val);
            if(v1<v2){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
            current.next = null;
        }
        return dummy.next;
    }
}
