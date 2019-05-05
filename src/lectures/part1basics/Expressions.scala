package lectures.part1basics

object Expressions extends App {

    val x = 1 + 2 // right hand side -> expressions
    println(x)
    println(2 + 3 * 4)

    // == test for equality, != >= <= < >
    println(1 == x)

    println(!(1 == x)) // ! && ||

    var aVariable = 2

    aVariable += 3 //also works with -=, *= /=, only with variables -> side effects
    println(aVariable)


    // Instructions (DO) vs expressions (VALUE)

    // if expression
    val aCondition = true
    val aConditionValue = if(aCondition) 5 else 3 //if expressions (different than diff instruction)
    println(aConditionValue)

    //while
    // NEVER WRITE THIS AGAIN, specific to imperative programming
    // Everything in scala is an expression
    var i = 0
    while(i < 10) {
        println(i)
        i+=1
    }

    val aWeirdValue = (aVariable = 3) // Unit === void -> dont return anything meaningful
    println(aWeirdValue) // side effects -> expressions returning unit, println(), whiles, reassigning

    //code block is an expression,
    // vals defined outside have the scope of the block
    val aCodeBlock = {
        val y = 2
        val z = 1 + y
        if(z>2) "Hello" else "Goodbye"
    }

    // i. what is the difference between "Hello World" and println("Hello world")
    // Hello world is a literal string and println is an expression returning unit (side effect -> printing))

    // ii.
    val someValue = {
        2 < 3
    }
    // returns true

    val someOtherValue = {
        if(someValue) 239 else 986
        42
    }
    //returns 42




}
