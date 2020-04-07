package com.vitorblog.compiler.validator

object NameValidator {
    private val invalidCharacters = " -=+§)(*&¨%$#@!/?€\\|°/~^][{}ºª`´.,<>©'\"".toCharArray()

    fun isValid(string: String):Boolean {
        var result = isEmpty(string)

        string.toCharArray().forEach {
            if (result){
                return !result
            }

            result = invalidCharacters.contains(it)
        }

        return !result
    }

    fun isEmpty(string:String) = string.isEmpty()

}