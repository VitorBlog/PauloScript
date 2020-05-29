package com.vitorblog.compiler.function

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.model.Function
import com.vitorblog.compiler.model.Variable
import java.net.Socket
import kotlin.random.Random

class SendSocketMessageFunction : Function {

    override val name = "sendSocketMessage"
    override val args = 2

    override
    fun execute(arguments: List<String>) {

        val varName = arguments[0]
        val message = arguments[1]

        val variable = VariableDao[varName]!!

        val outputStream = (variable.value as Socket).getOutputStream()
        outputStream.write(message.replace("\"", "").toByteArray())
        outputStream.flush()

    }

}