package com.vitorblog.compiler.model.exception

class InvalidArgsException(name: String, args:Int) : Exception("The function '$name' need $args arguments to work.")