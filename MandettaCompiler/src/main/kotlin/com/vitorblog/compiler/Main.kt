package com.vitorblog.compiler

import com.vitorblog.compiler.model.MandettaClass
import java.io.File

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val mandettaClass = MandettaClass(File("../test.sus"))
        println(mandettaClass.output)
    }

}