package com.vitorblog.compiler.process

object CodeProcess {

    fun load(lines:List<String>){
        lines.forEach { line ->

            when {
                line.startsWith("//") -> {}

                line.contains("var") -> {

                    VariableProcess.load(line)

                }
                else -> {

                    FunctionProcess.load(line)

                }
            }

        }
    }

}