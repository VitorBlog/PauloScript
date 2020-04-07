package com.vitorblog.compiler.parser

import java.lang.Exception

object ValueParser {

    fun parseValue(string: String):Any? {

        if (string.contains("\"") || string.contains("'")) {
            return string.substring(1, string.length-1)
        }
        if (string.endsWith("e")){
            return string == "true"
        }
        if (string == "null") {
            return null
        }

        return try {
            string.toInt()
        } catch (exception:Exception) {
            null
        }
    }

}