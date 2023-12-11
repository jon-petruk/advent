package com.jpetruk.advent

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day3Test {
    val day3 = Day3()

    @Test
    fun `Test Char Equality`() {
        Assertions.assertTrue(day3.isCharASymbol('c'));
        Assertions.assertTrue(day3.isCharASymbol('3'));
        Assertions.assertFalse(day3.isCharASymbol('.'));
    }

    @Test
    fun `Test is anything in range`() {
        var txt = ".311..*...*...";
        var charArray = txt.toCharArray().toTypedArray();
        Assertions.assertTrue(day3.isAnythingInRangeASymbol(charArray, 0, 14));
        Assertions.assertTrue(day3.isAnythingInRangeASymbol(charArray, -1, 5));
        Assertions.assertFalse(day3.isAnythingInRangeASymbol(charArray, -1, 0));
        Assertions.assertFalse(day3.isAnythingInRangeASymbol(charArray, 7, 9));
        Assertions.assertTrue(day3.isAnythingInRangeASymbol(charArray, 7, 10));

    }
}