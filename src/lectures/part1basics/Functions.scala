package lectures.part1basics

object Functions extends App {

    // expressions
    //compiler doesnt complain if you delete de return value
    //best practice, specify them
    def aFunction(a: String, b: Int) : String = a + " " + b

    def aFunctionBlock(a: String, b: Int) : String = {
        a + " " + b
    }

    println(aFunction("hello", 3))

    def aParameterlessFunction() : Int = 42

    println(aParameterlessFunction())
    println(aParameterlessFunction) // compiler warn, can be called just by their name

    //In scala you use recursive functions instead of for's
    // Recursive function,
    // if function is recursive, it needs de result type
    def aRepeatedFunction(aString: String, n: Int): String = {
        if(n == 1) aString
        else aString + aRepeatedFunction(aString, n -1)
    }

    println(aRepeatedFunction("hello", 3))

    def aFunctionWithSideEffects(aString: String): Unit = println(aString)

    def aBigFunction(n: Int): Int = {
        def aSmallerFunction(a: Int, b: Int): Int = a + b
        aSmallerFunction(n, n-1)
    }

    // i. a greeting function (name, age) => "Hi, mi name is $name and I am $age years old
    def greeting(name: String, age: Int): Unit = println("Hi, mi name is " + name + " and I am " + age + " years old")

    // ii. Factorial Function 1 * 2 * 3 * .. * n (recursive)
    def factorial(n: Long): Long = {
        if(n <= 0 || n == 1)
            1
        else n*factorial(n-1)
    }
    // iii. Fibonacci function 1, 1, 2, 3, 5, 8, etc, f(n) = f(n-1) + f(n-2)
    def fibonacci(n: Long): Long = {
        if(n == 1 || n == 2)
            1
        else fibonacci(n-1) + fibonacci(n-2)
    }

    // iv. tests if a number is prime
    def isPrime(n: Long): Boolean = {
        def isPrimeUntil(t: Long): Boolean =
            if (t <= 1) true
            else n % t != 0 && isPrimeUntil(t-1)

        isPrimeUntil(n / 2)
    }


}
