package com.vitorblog.compiler.parser

import com.vitorblog.compiler.util.StringUtils
import java.lang.Exception

object ValueParser {

    fun parseValue(string: String):Any? {
        when {
            StringUtils.isString(string) -> {
                return string.substring(1, string.length-1)
            }
            StringUtils.isBoolean(string) -> {
                return string == "true"
            }
            string == "null" -> {
                return null
            }
            else -> {
                return try {
                    string.toInt()
                } catch (exception:Exception) {
                    null
                }
            }
        }
    }

}