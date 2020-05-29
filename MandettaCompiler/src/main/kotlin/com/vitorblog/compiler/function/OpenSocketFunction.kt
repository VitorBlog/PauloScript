package com.vitorblog.compiler.function

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.model.Function
import com.vitorblog.compiler.model.Variable
import java.net.Inet4Address
import java.net.Socket
import java.net.SocketAddress
import kotlin.random.Random

class OpenSocketFunction : Function {

    override val name = "openSocket"
    override val args = 2

    override
    fun execute(arguments: List<String>) {

        val varName = arguments[0]
        val ip = arguments[1]
        val port = arguments[2].toInt()

        val variable = if (VariableDao.contains(varName)) {
            VariableDao[varName]!!
        } else {
            Variable("var $varName = \"\"")
        }

        variable.value = Socket(ip.replace("\"", ""), port)

        VariableDao.add(variable)

    }

}