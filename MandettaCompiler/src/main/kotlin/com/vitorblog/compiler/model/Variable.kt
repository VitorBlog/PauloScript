package com.vitorblog.compiler.model

import com.vitorblog.compiler.model.exception.InvalidVarNameException
import com.vitorblog.compiler.model.exception.VarNameParseException
import com.vitorblog.compiler.parser.ValueParser
import com.vitorblog.compiler.util.StringUtils
import java.util.regex.Pattern

class Variable(string: String) {

    var name:String
    var value:Any? = null

    init {
        var pattern = Pattern.compile(" (.*?) ")
        var matcher = pattern.matcher(string)

        if (matcher.find()){
            name = matcher.group(0).replace(" ", "")

            if (StringUtils.isInvalid(name)){
                throw InvalidVarNameException()
            }
        } else {
            throw VarNameParseException()
        }

        pattern = Pattern.compile("([^=]+)")
        matcher = pattern.matcher(string)

        value = if (matcher.find()){
            val unparsedValue = string.replace("${matcher.group(1)}= ", "")
            ValueParser.parseValue(unparsedValue)
        } else {
            null
        }
    }

}