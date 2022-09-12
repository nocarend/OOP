package com.example.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class with tests.
 */
class MainStackTest {

    /**
     * Simple test on push.
     */
    @Test
    void pushTest() {
        MainStack<String> testStack = new MainStack<>();
        String test = "baobab";
        testStack.push(test);
        String[] expectedResult = new String[MainStack.MAX_SIZE];
        expectedResult[0] = "baobab";
        assertArrayEquals(expectedResult, testStack.array);
    }

    /**
     * Simple test on pop.
     */
    @Test
    void popTest() {
        MainStack<String> testStack = new MainStack<>();
        testStack.push("baobab");
        final String expectedResult = "baobab";
        String test = testStack.pop();
        assertEquals(expectedResult, test);
    }

    /**
     * Simple test on pushStack.
     */
    @Test
    void pushStackTest() {
        MainStack<String> testStack = new MainStack<>();
        String[] inputValues = new String[]{"a", "b", "c", "d", "e"};
        testStack.pushStack(inputValues);
        String[] expectedResult = new String[MainStack.MAX_SIZE];
        expectedResult[0] = "a";
        expectedResult[1] = "b";
        expectedResult[2] = "c";
        expectedResult[3] = "d";
        expectedResult[4] = "e";
        assertArrayEquals(expectedResult, testStack.array);
    }

    /**
     * Simple test on popStack.
     */
    @Test
    void popStackTest() {
        MainStack<String> testStack = new MainStack<>();
        String[] inputValues = new String[]{"a", "b", "c", "d", "e"};
        testStack.pushStack(inputValues);
        String[] expectedResult = new String[MainStack.MAX_SIZE];
        expectedResult[0] = "b";
        expectedResult[1] = "c";
        expectedResult[2] = "d";
        expectedResult[3] = "e";
        MainStack<String> testResult = testStack.popStack(4);
        assertArrayEquals(expectedResult, testResult.array);
    }

    /**
     * Simple test on count.
     */
    @Test
    void countTest() {
        MainStack<String> testStack = new MainStack<>();
        String[] inputValues = new String[]{"a", "b", "c", "d", "e"};
        testStack.pushStack(inputValues);
        int expectedResult = 5;
        int testResult = testStack.count();
        assertEquals(expectedResult, testResult);
    }
}
