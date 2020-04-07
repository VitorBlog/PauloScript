package com.vitorblog.compiler.process

import com.andreapivetta.kolor.lightRed
import com.vitorblog.compiler.model.MandettaClass

object CodeProcess {
    var actualLine = 0

    fun load(lines:List<String>){
        lines.withIndex().forEach { obj ->
            val line = obj.value
            actualLine = obj.index

            try {

                when {
                    line.startsWith("//") -> {}

                    line.contains("var") -> {

                        VariableProcess.load(line)

                    }
                    else -> {

                        FunctionProcess.load(line)

                    }
                }

            } catch (exception:Exception) {
                MandettaClass.instance.print("Exception found at line ${actualLine+1}: ${exception.message}\n".lightRed())
            }

        }
    }

}