package lectures.part1basics

object ValuesVariablesTypes extends App {

    //Vals cannot be reasigned, they are inmutable
    //Types of vals are optional, infered by the compiler
    val x = 42
    println(x)

    val aString: String = "hello"
    val anotherString = "goodbye"

    val aBoolean: Boolean = false
    val aChar: Char = 'a'

    val anInt: Int = x

    val aShort: Short = 4613

    val aLong: Long = 1308123103819031102L

    val aFloat: Float = 2.0f

    val aDouble: Double = 3.14


    //Variables
    var aVariable: Int = 4

    aVariable = 5 // functional programming -> side effects
}
