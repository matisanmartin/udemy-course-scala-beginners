package lectures.part1basics

object CallByNameCallByValue extends App {

    // value evaluated before function execution and used it through function definition
    def calledByValue(x: Long): Unit = {
        println("by value " + x)
        println("by value " + x)
    }

    // expression is passed literally and evaluated inside the function
    def calledByName(x: => Long): Unit = {
        println("by name " + x)
        println("by name " + x)
    }

    calledByValue(System.nanoTime())
    calledByName(System.nanoTime())

    def infinite(): Int = 1 + infinite()
    def printFirst(x: Int, y: => Int) = print(x)

    //Crash, stackOveflow
    //printFirst(infinite(), 34)

    // byName delays the evaluation until used, so it's never evaluated
    printFirst(34, infinite())

}
