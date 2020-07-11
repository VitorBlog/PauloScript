package com.vitorblog.compiler.function

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.model.Function
import com.vitorblog.compiler.model.Variable
import kotlin.random.Random

class RandomFunction : Function {

    override val name = "random"
    override val args = 1

    override
    fun execute(arguments: List<String>) {

        val arg = arguments[0]
        val max = if (arguments.size > 1) {
            arguments[1]
        } else {
            null
        }
        val variable = if (VariableDao.contains(arg)) {
            VariableDao[arg]!!
        } else {
            Variable("var $arg = \"\"")
        }

        variable.value = if (max != null) {
            Random.nextInt(max.toInt())
        } else {
            Random.nextInt()
        }

        VariableDao.add(variable)

    }

}