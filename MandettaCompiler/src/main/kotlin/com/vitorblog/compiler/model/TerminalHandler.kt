package com.vitorblog.compiler.model

import java.util.function.Consumer

class TerminalHandler : MandettaHandler {

    override
    fun consoleOutput(string: String) {
        print(string)
    }

    override
    fun consoleInput(consumer: Consumer<String>) {
        MandettaClass.instance.input = consumer
        consumer.accept(readLine()!!)
    }

}