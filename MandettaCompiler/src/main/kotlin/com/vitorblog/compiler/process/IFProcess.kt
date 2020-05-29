package com.vitorblog.compiler.process

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.model.Status
import com.vitorblog.compiler.model.exception.InvalidIFException
import com.vitorblog.compiler.parser.ValueParser
import com.vitorblog.compiler.util.StringUtils
import java.util.regex.Pattern

object IFProcess {

    fun loadIF(line:String) {

        val pattern = Pattern.compile("\\((.*?)\\)")
        val matcher = pattern.matcher(line)

        if (!matcher.find()) {
            throw InvalidIFException("args")
        }

        val arguments = matcher.group(0)
            .removePrefix("(")
            .removeSuffix(")")
        val split = arguments.split(" ")

        val comparisonType = ComparisonType.byValue(split[1]) ?: throw InvalidIFException("comparison type")
        CodeProcess.status = if (makeComparison(split, comparisonType)) {
            Status.IN_IF_TRUE
        } else {
            Status.IN_IF
        }

    }

    fun loadElse() {

        CodeProcess.status = if (CodeProcess.status == Status.IN_IF) {
            Status.IN_ELSE_TRUE
        } else {
            Status.IN_ELSE
        }

    }

    private fun makeComparison(split:List<String>, comparisonType: ComparisonType):Boolean {
        val firstValue = ValueParser.getRealValue(split[0])
        val secondValue = ValueParser.getRealValue(split[2])

        return when {

            comparisonType == ComparisonType.EQUALS
                    && firstValue == secondValue -> {

                true

            }

            comparisonType == ComparisonType.BIGGER
                    && firstValue.toString().toInt() > secondValue.toString().toInt() -> {

                true

            }

            comparisonType == ComparisonType.MINOR
                    && firstValue.toString().toInt() < secondValue.toString().toInt() -> {

                true

            }

            comparisonType == ComparisonType.BIGGER_OR_EQUALS
                    && firstValue.toString().toInt() >= secondValue.toString().toInt() -> {

                true

            }

            comparisonType == ComparisonType.MINOR_OR_EQUALS
                    && firstValue.toString().toInt() <= secondValue.toString().toInt() -> {

                true

            }

            else -> false

        }

    }

    enum class ComparisonType(val value: String) {

        EQUALS("=="),
        NOT_EQUALS("!="),
        BIGGER(">"),
        MINOR("<"),
        BIGGER_OR_EQUALS(">="),
        MINOR_OR_EQUALS("<=");

        companion object {

            fun byValue(value: String):ComparisonType? {
                return values().firstOrNull { it.value == value }
            }

        }

    }

}