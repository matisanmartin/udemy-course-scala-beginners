package lectures.part1basics

object BasicOperationsOnStrings extends App {

    val str: String = "Hello, I am learning Scala"

    println(str.charAt(2))
    println(str.substring(7, 11))
    println(str.split(" ").toList)
    println(str.startsWith("Hello"))
    println(str.replace(" ", "-"))
    println(str.toLowerCase())
    println(str.length)

    val aNumberString = "45"
    val aNumber = aNumberString.toInt
    println('a' +: aNumberString :+ 'z') // preappend + append
    println(str.reverse)
    println(str.take(2))

    //Scala-specific (String interpolators)

    //S-interpolators
    val name = "David"
    val age = 12
    val greeting = s"Hello, my name is $name and I am $age years old"
    val greeting2 = s"Hello, my name is $name and I will be turning ${age+1} years old"
    println(greeting)
    println(greeting2)

    //F-interpolators (printf-style format)
    val speed = 1.2f
    val myth = f"$name can eat $speed%2.2f burgers per minute"
    println(myth)

    //raw-interpolators (backlashes doesn't scape)
    println(raw"This is a \n newline")

    //if injected, backlash is ignored
    val escaped = "This is a \n newline"
    println(raw"$escaped")
}
