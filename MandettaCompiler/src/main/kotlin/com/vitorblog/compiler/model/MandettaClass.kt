package com.vitorblog.compiler.model

import com.vitorblog.compiler.process.CodeProcess
import java.io.File
import java.time.Duration
import java.time.Instant

class MandettaClass(val file: File) {

    companion object {
        lateinit var instance: MandettaClass
    }

    val name = file.nameWithoutExtension
    val code = file.readText()
    private val lines = file.readLines()
    var output: String = ""
    var elapsedTime = 0

    init {
        instance = this

        val start = Instant.now()
        CodeProcess.load(lines)
        val finish = Instant.now()

        elapsedTime = (Duration.between(start, finish).toMillis()/1000.0).toInt()
    }

    fun print(s: String) {
        kotlin.io.print(s)
        output += s
    }

}