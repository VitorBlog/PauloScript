package com.vitorblog.compiler.process

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.model.MandettaClass
import com.vitorblog.compiler.model.Variable
import com.vitorblog.compiler.parser.ValueParser
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
                var text = ""
                val arg = arguments[0]
                if (arg.contains("\"")){
                    text = ValueParser.parseValue(arg).toString()
                } else {
                    text = VariableDao[arg]!!.value.toString()
                }

                MandettaClass.instance.print("$text\n")
            }

        }
    }

}