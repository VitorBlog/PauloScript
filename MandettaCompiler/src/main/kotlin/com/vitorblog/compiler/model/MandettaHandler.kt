package com.vitorblog.compiler.model

import java.util.function.Consumer

interface MandettaHandler {

    fun consoleOutput(string: String)

    fun consoleInput(consumer: Consumer<String>)

}