package com.vitorblog.compiler.process

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.model.MandettaClass
import com.vitorblog.compiler.model.Variable
import com.vitorblog.compiler.parser.ValueParser
import com.vitorblog.compiler.util.StringUtils
import java.util.regex.Pattern

object FunctionProcess {

    fun load(line:String){
        val pattern = Pattern.compile("\\((.*?)\\)")
        val matcher = pattern.matcher(line)

        if (!matcher.find()){
            return
        }

        val name = line.replace(matcher.group(0), "")
        val arguments = matcher.group(0)
            .replace("(", "")
            .replace(")", "")
            .split(", ")

        when (name) {

            "println" -> {
                val arg = arguments[0]
                val text = if (StringUtils.isString(arg)){
                    ValueParser.parseValue(arg).toString()
                } else {
                    VariableDao[arg]!!.value.toString()
                }

                MandettaClass.instance.print("$text\n")
            }

            "print" -> {
                val arg = arguments[0]
                val text = if (StringUtils.isString(arg)){
                    ValueParser.parseValue(arg).toString()
                } else {
                    VariableDao[arg]!!.value.toString()
                }

                MandettaClass.instance.print(text)
            }

            "input" -> {
                val arg = arguments[0]
                val variable = if (VariableDao.contains(arg)){
                    VariableDao[arg]!!
                } else {
                    Variable("var $arg = \"\"")
                }

                variable.value = readLine()!!

                VariableDao.add(variable)
            }

        }
    }

}