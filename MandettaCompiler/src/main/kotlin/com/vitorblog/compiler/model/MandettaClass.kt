package com.vitorblog.compiler.model

import com.vitorblog.compiler.process.CodeProcess
import com.vitorblog.compiler.process.VariableProcess
import java.io.File

/*

    

 */
class MandettaClass(val file:File) {

    companion object { lateinit var instance:MandettaClass }
    val name = file.nameWithoutExtension
    val code = file.readText()
    private val lines = file.readLines()
    var output:String = ""

    init {
        instance = this

        CodeProcess.load(lines)
    }

    fun print(s: String) {
        output += s
    }

}