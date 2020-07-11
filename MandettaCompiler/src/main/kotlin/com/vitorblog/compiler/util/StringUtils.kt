package com.vitorblog.compiler.util

object StringUtils {

    private val invalidCharacters = " -=+§)(*&¨%$#@!/?€\\|°/~^][{}ºª`´.,<>©'\"".toCharArray()

    fun isInvalid(string: String): Boolean {
        var result = string.isEmpty()

        string.toCharArray().forEach {
            if (result) {
                return !result
            }

            result = invalidCharacters.contains(it)
        }

        return result
    }

    fun isString(string: String): Boolean {
        if (string.length < 2) {
            return false
        }
        return string.first().toString() == "\"" && string.last().toString() == "\""
    }

    fun isBoolean(string: String): Boolean {
        return string == "false" || string == "true"
    }

    fun isInt(string: String): Boolean {
        return string.toIntOrNull() == null
    }

}