package com.jpetruk.advent

interface Day {
    fun challenges(): List<() -> String>

    fun readFile(filename: String): List<String> {
        return object {}.javaClass.getResourceAsStream(filename).bufferedReader(Charsets.UTF_8)?.readLines() ?: throw RuntimeException("file not found");
    }
}
