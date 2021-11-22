package com.javarush.task.pro.task02.task0202;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void main() {
        Solution solution = new Solution();
        int actual = solution.calculateMeters(243);
        int expected = 2;
        assertEquals(actual, expected);
    }
}