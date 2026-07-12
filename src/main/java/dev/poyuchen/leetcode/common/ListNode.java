package dev.poyuchen.leetcode.common;

import java.util.ArrayList;

public final class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int... values) {
        var dummy = new ListNode();
        var tail = dummy;

        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }

        return dummy.next;
    }

    public static int[] toArray(ListNode head) {
        var values = new ArrayList<Integer>();

        for (var current = head; current != null; current = current.next) {
            values.add(current.val);
        }

        var result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }

        return result;
    }
}
