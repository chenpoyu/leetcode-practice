package dev.poyuchen.leetcode.linked_list;

import dev.poyuchen.leetcode.common.Checks;
import dev.poyuchen.leetcode.common.ListNode;

public final class P0021MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var dummy = new ListNode();
        var tail = dummy;
        var left = list1;
        var right = list2;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        tail.next = left != null ? left : right;
        return dummy.next;
    }

    public static void main(String[] args) {
        var solution = new P0021MergeTwoSortedLists();

        Checks.checkListEquals(
                new int[]{1, 1, 2, 3, 4, 4},
                solution.mergeTwoLists(ListNode.of(1, 2, 4), ListNode.of(1, 3, 4)),
                "example 1"
        );
        Checks.checkListEquals(new int[]{}, solution.mergeTwoLists(null, null), "example 2");
        Checks.checkListEquals(new int[]{0}, solution.mergeTwoLists(null, ListNode.of(0)), "example 3");

        System.out.println("P0021MergeTwoSortedLists checks passed.");
    }
}
