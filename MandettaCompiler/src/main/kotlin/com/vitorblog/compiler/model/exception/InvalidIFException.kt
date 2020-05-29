package com.vitorblog.compiler.model.exception

class InvalidIFException(text:String) : Exception("Invalid $text in if statement")