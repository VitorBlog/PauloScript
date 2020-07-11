package com.vitorblog.compiler

import com.andreapivetta.kolor.lightBlue
import com.vitorblog.compiler.model.MandettaClass
import com.vitorblog.compiler.process.FunctionProcess
import java.io.File
import java.time.Duration
import java.time.Instant

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isEmpty()) {
            println("No file selected.")
            return
        }

        FunctionProcess.load()
        val mandettaClass = MandettaClass(File(args.first()))

        println("\nExecuted in: ${mandettaClass.elapsedTime}ms".lightBlue())
    }

}