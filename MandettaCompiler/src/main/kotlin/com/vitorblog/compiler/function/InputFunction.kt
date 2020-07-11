package com.vitorblog.compiler.function

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.model.Function
import com.vitorblog.compiler.model.MandettaClass
import com.vitorblog.compiler.model.Variable
import java.util.function.Consumer

class InputFunction : Function {

    override val name = "input"
    override val args = 1

    override
    fun execute(arguments: List<String>) {

        val arg = arguments[0]
        val variable = if (VariableDao.contains(arg)) {
            VariableDao[arg]!!
        } else {
            Variable("var $arg = \"\"")
        }

        MandettaClass.instance.mandettaHandler.consoleInput(Consumer { variable.value = it })

        VariableDao.add(variable)

    }

}