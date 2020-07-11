package com.vitorblog.compiler.dao

import com.vitorblog.compiler.model.Variable

object VariableDao {

    val VARIABLES = hashMapOf<String, Variable>()

    fun add(variable: Variable) = VARIABLES.put(variable.name, variable)

    operator fun get(name:String) = VARIABLES[name]

    fun contains(name:String) = VARIABLES.containsKey(name)

}