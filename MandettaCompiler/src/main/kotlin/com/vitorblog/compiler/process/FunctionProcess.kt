package com.vitorblog.compiler.process

import com.vitorblog.compiler.dao.FunctionDao
import com.vitorblog.compiler.model.Function
import com.vitorblog.compiler.model.exception.FunctionNotFoundException
import com.vitorblog.compiler.model.exception.InvalidArgsException
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import java.util.regex.Pattern

object FunctionProcess {

    fun load() {
        val reflections = Reflections("com.vitorblog", SubTypesScanner())

        val functions = reflections.getSubTypesOf(Function::class.java)
        functions.forEach {
            FunctionDao.add(it.newInstance())
        }
    }

    fun load(line: String) {
        val pattern = Pattern.compile("\\((.*?)\\)")
        val matcher = pattern.matcher(line)

        if (!matcher.find()) {
            return
        }

        val name = line.replace(matcher.group(0), "")
        val arguments = matcher.group(0)
            .replace("(", "")
            .replace(")", "")
            .split(", ")

        val function = FunctionDao[name] ?: throw FunctionNotFoundException(name)

        if (arguments.size < function.args) {
            throw InvalidArgsException(name, function.args)
        }

        function.execute(arguments)
    }

}