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
