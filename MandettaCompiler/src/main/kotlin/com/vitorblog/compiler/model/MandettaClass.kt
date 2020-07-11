package com.vitorblog.compiler.model

import com.vitorblog.compiler.process.CodeProcess
import java.io.File
import java.time.Duration
import java.time.Instant
import java.util.function.Consumer

class MandettaClass(file: File, val mandettaHandler: MandettaHandler = TerminalHandler()) {

    companion object {
        lateinit var instance: MandettaClass
    }

    val name = file.nameWithoutExtension
    var elapsedTime = 0

    val code = file.readText()
    val lines = file.readLines()

    var input: Consumer<String>? = null

    init {
        instance = this

        val start = Instant.now()
        CodeProcess.load(lines)
        val finish = Instant.now()

        elapsedTime = (Duration.between(start, finish).toMillis()/1000.0).toInt()
    }

}