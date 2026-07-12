package dev.poyuchen.leetcode.common;

import java.util.Arrays;
import java.util.Objects;

public final class Checks {
    private Checks() {
    }

    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void checkEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + " expected=" + expected + " actual=" + actual);
        }
    }

    public static void checkEquals(Object expected, Object actual, String message) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(message + " expected=" + expected + " actual=" + actual);
        }
    }

    public static void checkArrayEquals(int[] expected, int[] actual, String message) {
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError(
                    message + " expected=" + Arrays.toString(expected) + " actual=" + Arrays.toString(actual)
            );
        }
    }

    public static void checkListEquals(int[] expected, ListNode actual, String message) {
        checkArrayEquals(expected, ListNode.toArray(actual), message);
    }
}
