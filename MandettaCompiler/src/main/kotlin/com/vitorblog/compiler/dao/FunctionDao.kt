package com.vitorblog.compiler.dao

import com.vitorblog.compiler.model.Function

object FunctionDao {

    val FUNCTIONS = hashMapOf<String, Function>()

    fun add(function: Function) = FUNCTIONS.put(function.name, function)

    operator fun get(name: String) = FUNCTIONS[name]

    fun contains(name: String) = FUNCTIONS.containsKey(name)

}