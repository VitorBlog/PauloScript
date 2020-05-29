package com.vitorblog.compiler.function

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.model.Function
import com.vitorblog.compiler.model.Variable

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

        variable.value = readLine()!!

        VariableDao.add(variable)

    }

}