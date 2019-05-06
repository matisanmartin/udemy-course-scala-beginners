package lectures.part2OOP

object OOPBasics extends App {

    val person = new Person("John", 26)
    println(person.age)
    println(person.x)
    person.greet("Daniel")
    person.greet
}

//age -> class parameter but not class member (fields)
// constructor
class Person(name: String, val age: Int = 0) {

    val x = 2

    //at every instantiation, whole block of code will be evaluated
    println(1 + 3)

    def greet(name: String): Unit = println(s"${this.name} says Hi, $name")

    def greet(): Unit = println(s"Hi, I am $name")

    def this() = this("John Doe")
}

/*
    Novel, writer

    Writer: first name, surname, year
    - method fullname

    Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy (new year of release) = new instance of novel

    Counter class:
    - receives an int value
    - method current count
    - method to increment and decrement => new counter
    - overload inc/dec methods to receive a parameter wich is the amount => new counter
  */

class Writer(val firstName: String, val surname: String, val year: Int) {

    def fullName(): String = s"$firstName $surname"

}

class Novel(val name: String, val year: Int, val author: Writer) {

    def authorAge(): Int = year - author.year

    def isWrittenBy(author: Writer): Boolean = {
        //this.author.fullName() == author.fullName()
        author == this.author
    }

    def copy(yearOfRelease: Int): Novel = {
        new Novel(this.name, yearOfRelease, author)
    }
}

class Counter(val count: Int = 0) {

    def increment(): Counter = {
        println("Incrementing")
        new Counter(count+1) // inmutabilidad
    }

    def decrement(): Counter = {
        println("Decrementing")
        new Counter(count-1)
    }

    def increment(quantity: Int): Counter =
        if (quantity <= 0) this
        else increment.increment(quantity-1)

    def decrement(quantity: Int): Counter =
        if(quantity <= 0) this
        else decrement.decrement(quantity-1)

    def print = println(count)
}
