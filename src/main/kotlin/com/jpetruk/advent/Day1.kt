package com.jpetruk.advent

import java.util.regex.Pattern

class Day1 : Day {
    var mapOfDigits = mapOf("one" to 1, "two" to 2,"three" to 3,"four" to 4,"five" to 5,"six" to 6,"seven" to 7,"eight" to 8,"nine" to 9,"zero" to 0)

    override fun challenges(): List<() -> String> {
        return listOf(::firstChallenge, ::secondChallenge);
    }

    fun firstChallenge(): String {
        var total = 0;
        var lines = readFile("/puzzleInput.txt");
        var firstDigitPattern = Pattern.compile("^\\D*(\\d)");
        var lastDigitPattern = Pattern.compile("(\\d)\\D*$");

        for (line in lines) {
            var firstDigitMatcher = firstDigitPattern.matcher(line);
            var lastDigitMatcher = lastDigitPattern.matcher(line);
            (firstDigitMatcher.find() && lastDigitMatcher.find()) || throw RuntimeException("NO match " + line);
            var firstDigit = firstDigitMatcher.group(1).toInt();
            var lastDigit = lastDigitMatcher.group(1).toInt();
            total += (firstDigit*10) + lastDigit;
        }
        return "" + total;
    }


    fun secondChallenge(): String {
        var listOfValues = arrayOf("one", "two","three","four","five","six","seven","eight","nine","zero","1","2","3","4","5","6","7","8","9","0");


        var total = 0;
        var lines = object {}.javaClass.getResourceAsStream("/puzzleInput.txt").bufferedReader(Charsets.UTF_8)?.readLines() ?: throw RuntimeException("file not found");

        for (line in lines) {
            var firstDigit = -1;
            var lastDigit = -1;
            var firstDigitIndex = 99999;
            var lastDigitIndex = -1;

            for (digit in listOfValues) {
                var index = line.indexOf(digit);
                if (index>=0 && index<firstDigitIndex) {
                    firstDigitIndex = index;
                    firstDigit = wordsToDigit(digit);
                }
                index = line.lastIndexOf(digit);
                if (index>lastDigitIndex) {
                    lastDigitIndex = index;
                    lastDigit = wordsToDigit(digit);
                }
            }
            if (firstDigit == -1 || lastDigit == -1)
                throw RuntimeException("This line no good mate " + line);
            total += (firstDigit*10) + lastDigit;
        }
        return "" + total;
    }

    fun wordsToDigit(word: String): Int {
        return if (word.length > 1) mapOfDigits[word]!! else word.toInt();
    }
}

