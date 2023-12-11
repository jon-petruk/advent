package com.jpetruk.advent

import java.util.regex.Pattern

class Day2 : Day {
    override fun challenges(): List<() -> String> {
        return arrayListOf(::elfCubes, ::elfCubesPower)
    }

    private val cubeCounts = mapOf("red" to 12, "green" to 13, "blue" to 14)
    private val gamePattern: Pattern = Pattern.compile("(\\d+) (\\w+)")
    private val lines = readFile("/Day2-input.txt")
    private val pattern: Pattern = Pattern.compile("^Game (\\d+): (.*)$")

    private fun elfCubesPower(): String {
        var sumOfPowers = 0
        for (line in lines) {
            val matcher = pattern.matcher(line)
            if (matcher.find()) {
                sumOfPowers += iveGotThePower(matcher.group(2))
            }
        }
        return "" + sumOfPowers

    }

    private fun elfCubes(): String {
        var sumOfIDs = 0
        for (line in lines) {
            val matcher = pattern.matcher(line)
            if (matcher.find()) {
                var gameNumber = matcher.group(1).toInt()
                if (processGames(matcher.group(2))) {
                    sumOfIDs += gameNumber
                }
            }
        }
        return "" + sumOfIDs
    }

    private fun processGames(semicolonSeparatedList: String): Boolean {
        var gameStrings = semicolonSeparatedList.split(";")
        for (gameString in gameStrings) {
            var gameMatcher = gamePattern.matcher(gameString)
            while (gameMatcher.find()) {
                var count = gameMatcher.group(1).toInt()
                var colour = gameMatcher.group(2)
                if ((cubeCounts[colour] ?: 0) < count)
                    return false
            }
        }
        return true
    }


    private fun iveGotThePower(semicolonSeparatedList: String): Int {
        var highestValues = HashMap<String, Int>()

        var gameStrings = semicolonSeparatedList.split(";")
        for (gameString in gameStrings) {
            var gameMatcher = gamePattern.matcher(gameString)
            while (gameMatcher.find()) {
                var count = gameMatcher.group(1).toInt()
                var colour = gameMatcher.group(2)
                if ((highestValues[colour] ?: 0) < count) {
                    highestValues[colour] = count
                }
            }
        }
        var thePoweredResult = 1
        highestValues.values.forEach { thePoweredResult *= it }
        return thePoweredResult
    }

}