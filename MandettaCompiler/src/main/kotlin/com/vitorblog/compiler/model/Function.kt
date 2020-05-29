package com.vitorblog.compiler.model

interface Function {

    val name: String
    val args: Int

    fun execute(arguments: List<String>)

}