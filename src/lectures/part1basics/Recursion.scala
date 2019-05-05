package lectures.part1basics

import lectures.part1basics.Functions.{aRepeatedFunction, fibonacci}

import scala.annotation.tailrec

object Recursion extends App {

    //@tailrec -> throws error cause the function is not tail recursive
    def factorial(n: Int): Int =
        if(n <=1) 1
        else {
            println("Computing factorial of " + n + " -- first need facotiral of " + (n-1))
            val result = n * factorial(n-1)
            println("computed factorial of " + n)
            result
        }

    //println(factorial(10))

    //Stack overflow ---> stack blows up
    //println(factorial(5000))

    def anotherFactorial(n: Int): BigInt = {
        @tailrec
        def factorialHelper(x: Int, accumulator: BigInt): BigInt =
            if(x <= 1) accumulator
            else factorialHelper(x -1, x*accumulator) // tail recursion, use recursive call as the last expression

        factorialHelper(n, 1)
    }

    println(anotherFactorial(10))
    println(anotherFactorial(5000))

    // how to iterate? use tail recursion

    // 1. String concatenation N times
    def aRepeatedFunction(aString: String, n: Int): String = {
        if(n == 1) aString
        else aString + aRepeatedFunction(aString, n -1)
    }

    def aRepeatedFunctionTail(aString: String, n: Int): String = {
        @tailrec
        def aRepeatedFunctionHelper(aString: String, n: Int, accumulator: String): String = {
            if(n == 1) accumulator
            else aRepeatedFunctionHelper(aString, n -1, aString + accumulator)

        }

        aRepeatedFunctionHelper(aString, n, "")
    }
    // 2. isPrime with tail recursion
    def isPrime(n: Long): Boolean = {
        def isPrimeUntil(t: Long): Boolean =
            if (t <= 1) true
            else n % t != 0 && isPrimeUntil(t-1)

        isPrimeUntil(n / 2)
    }

    def isPrimeTailRec(n: Long): Boolean = {
        def isPrimeUntil(t: Long, isStillPrime: Boolean): Boolean =
            if(!isStillPrime) false
            else if (t <= 1) true
            else isPrimeUntil(t-1, n % t != 0 && isStillPrime)

        isPrimeUntil(n / 2, true)
    }

    // 3. fibonacci with tail recursion
    def fibonacci(n: Long): Long = {
        if(n == 1 || n == 2)
            1
        else fibonacci(n-1) + fibonacci(n-2)
    }

    def fibonacciTail(n: Long): Long = {
        def fibonacciTailHelper(t: Long, last: Long, nextLast: Long): Long =
            if(t >= n) last
            else {
                fibonacciTailHelper(t+1, last + nextLast, last)
            }

        if(n <= 2) 1
        else fibonacciTailHelper(2, 1,1)
    }
}
