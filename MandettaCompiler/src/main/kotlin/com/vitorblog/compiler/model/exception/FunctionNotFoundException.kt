package com.vitorblog.compiler.model.exception

class FunctionNotFoundException(name: String) : Exception("The function '$name' does not exist.")