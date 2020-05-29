package com.vitorblog.compiler.process

import com.andreapivetta.kolor.red
import com.vitorblog.compiler.model.MandettaClass
import com.vitorblog.compiler.model.Status

object CodeProcess {
    var actualLine = 0
    var status = Status.NOTHING

    fun load(lines: List<String>) {
        for (obj in lines.withIndex()) {
            val line = obj.value
            actualLine = obj.index

            try {

                when {

                    line.startsWith("//") -> {}
                    (status == Status.IN_IF || status == Status.IN_ELSE)
                            && (!line.startsWith("else") && !line.startsWith("end")) -> {}

                    line.startsWith("var") -> {

                        VariableProcess.load(line.replace("  ", ""))

                    }

                    line.startsWith("if") -> {

                        IFProcess.loadIF(line)

                    }

                    line.startsWith("else") -> {
                        
                        IFProcess.loadElse()

                    }

                    line.startsWith("end") -> {

                        status = Status.NOTHING

                    }

                    line.contains("(") && line.contains(")") -> {

                        FunctionProcess.load(line.replace("  ", ""))

                    }

                }

            } catch (exception: Exception) {
                MandettaClass.instance.print("Exception found at line ${actualLine + 1}: ${exception.message}\n".red())
            }

        }
    }

}