package com.practice.java8_17.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(3, null)));
//        ListNode reverse = reverseLinkedList(l1);
        ListNode AddedValues = addTwoNumbers(l1,l2);
        display(AddedValues);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;
            int sum = v1 + v2+ carry;
            int lastDigit = sum%10;
            carry = sum/10;
            curr.next = new ListNode(lastDigit, null);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return head.next;
    }

    public static ListNode reverseLinkedList(ListNode listNode) {
        ListNode prev = null;
        ListNode current = listNode;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        listNode = prev;
        return listNode;
    }

    public static void display(ListNode listNode) {
        while (listNode != null) {
            System.out.println("Value = " + listNode.val + "\n Next Node = " + listNode.next);
            listNode = listNode.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
