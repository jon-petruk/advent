package com.jpetruk.advent
import java.util.regex.Pattern

class Day3: Day {
    override fun challenges(): List<() -> String> {
        return arrayListOf(::findTheTotal)
    }

    val pattern : Pattern = Pattern.compile("(\\d+)");

    fun findTheTotal() : String {
        val fileLines = readFile("/Day3-input.txt")
        val theArray = extractAsArray(fileLines)
  /*      for ((index, line) in fileLines.withIndex()) {
            val matcher = pattern.matcher(line);
            while (matcher.find()) {
                matcher.g
            }
        } */
        return "sorry elf"
    }

    fun extractAsArray(lines: List<String>) : Array<Array<Char>> {
        val returnArray = Array(140) { Array<Char>(140) { '.' } }
        for ((index, value) in lines.withIndex()) {
            for ((index, line) in lines.withIndex()) {
                returnArray[index] = line.toCharArray().toTypedArray();
            }
        }
        println("The Array\n" + returnArray.contentDeepToString())

        return returnArray
    }

    // Check if the range
    fun isAnythingInRangeASymbol(aLittleArray: Array<Char>, requestedStartIndex: Int, requestedEndIndex: Int) : Boolean {
        val startIndex = if (requestedStartIndex<0) 0 else requestedStartIndex
        val endIndex = if (requestedEndIndex>=aLittleArray.size) (aLittleArray.size-1) else requestedEndIndex

        for (i in startIndex..endIndex)
            if (isCharASymbol(aLittleArray[i]))
                return true
        return false
    }

    // returns true if a character is a symbol (not a ".")
    fun isCharASymbol(aChar : Char) : Boolean {
        return aChar!='.'
    }

    // Returns true if we find a symbol (anything other than ".")
    fun isASymbolAroundString(theBigArray: Array<Array<Char>>, x: Int, startIndex: Int, endIndex: Int) : Boolean {
        // check the line above
        if (x > 0)  // nothing above the first row to check
            if (isAnythingInRangeASymbol(theBigArray[x-1],startIndex-1,endIndex+1)) return true

        // the line below
        if (x<theBigArray.size) {
            if (isAnythingInRangeASymbol(theBigArray[x+1],startIndex-1,endIndex+1)) return true
        }

        // the line of - char before and after is good
        if (startIndex > 1)
            if (isCharASymbol(theBigArray[x][startIndex-1])) return true
        if (endIndex < theBigArray[x].size)
            if (isCharASymbol(theBigArray[x][startIndex-1])) return true
        return false
    }
}