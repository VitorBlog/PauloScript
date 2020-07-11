import com.vitorblog.compiler.model.Variable
import com.vitorblog.compiler.util.StringUtils

object TestMain {

    @JvmStatic
    fun main(args: Array<String>) {
        var variable = Variable("var iam = \"hell\"")
        println(variable.name)
        println(variable.value)
        println(StringUtils.isString("\""))

        println("--------------------------------------")

        variable = Variable("var none = 5")
        println(variable.name)
        println(variable.value)
        println(StringUtils.isString(variable.value.toString()))
    }

}