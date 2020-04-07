import com.vitorblog.compiler.model.Variable

object TestMain {

    @JvmStatic
    fun main(args: Array<String>) {
        var variable = Variable("var iam = true")
        println(variable.name)
        println(variable.value)

        println("--------------------------------------")

        variable = Variable("var none = 5")
        println(variable.name)
        println(variable.value)
    }

}