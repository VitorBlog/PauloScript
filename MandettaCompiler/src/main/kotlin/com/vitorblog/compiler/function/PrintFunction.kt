package com.vitorblog.compiler.function

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.model.Function
import com.vitorblog.compiler.model.MandettaClass
import com.vitorblog.compiler.parser.ValueParser
import com.vitorblog.compiler.util.StringUtils

class PrintFunction : Function {

    override val name = "print"
    override val args = 1

    override
    fun execute(arguments: List<String>) {

        val arg = arguments[0]
        val text = if (StringUtils.isString(arg)) {
            ValueParser.parseValue(arg).toString()
        } else {
            VariableDao[arg]!!.value.toString()
        }

        MandettaClass.instance.print(text)

    }

}