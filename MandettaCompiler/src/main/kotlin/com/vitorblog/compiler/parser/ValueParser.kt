package com.vitorblog.compiler.parser

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.util.StringUtils
import jdk.nashorn.tools.ShellFunctions.input
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.collections.ArrayList


object ValueParser {

    fun parseValue(string: String): Any? {
        when {
            StringUtils.isString(string) -> {
                val pattern = Pattern.compile("\\{(.*?)\\}")
                val matcher = pattern.matcher(string)
                val matches = matcher.allMatches()

                if (matches.isNotEmpty()) {

                    var newString = string
                    for (match in matches) {

                        newString = newString.replace(
                            match,
                            VariableDao[match.substring(1, match.length - 1)]!!.value.toString()
                        )

                    }

                    return newString.substring(1, newString.length - 1)

                }

                return string.substring(1, string.length - 1)
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
                } catch (exception: Exception) {
                    null
                }
            }
        }
    }

    fun getRealValue(string: String):Any? {

        return if (VariableDao.contains(string)) {
            VariableDao[string]!!.value
        } else {
            parseValue(string)
        }

    }

    private
    fun Matcher.allMatches(): ArrayList<String> {
        val arrayList = arrayListOf<String>()

        while (this.find()) {
            arrayList.add(this.group())
        }

        return arrayList
    }

}