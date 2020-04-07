package com.vitorblog.compiler.process

import com.vitorblog.compiler.dao.VariableDao
import com.vitorblog.compiler.model.Variable

object VariableProcess {

    fun load(line:String){
        VariableDao.add(Variable(line))
    }

}