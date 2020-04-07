package com.vitorblog.compiler.parser

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.util.StringUtils
import java.lang.Exception
import java.util.regex.Pattern

object ValueParser {

    fun parseValue(string: String):Any? {
        when {
            StringUtils.isString(string) -> {
                val pattern = Pattern.compile("\\{(.*?)\\}")
                val matcher = pattern.matcher(string)
                if (matcher.find()){
                    var newString = string

                    for (match in 0 until matcher.groupCount()){

                        val matchString = matcher.group(match)
                        newString = newString.replace(matchString, VariableDao[matchString.substring(1, matchString.length-1)]!!.value.toString())

                    }

                    return newString.substring(1, newString.length-1)
                }

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