package lectures.part2OOP

object MethodNotations extends App {

    class Person(val name: String, val favoriteMovie: String, val age: Int = 0) {
        def likes(movie: String): Boolean = movie == favoriteMovie
        def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
        def unary_! : String =s"${name} what the heck?!"
        def isAlive: Boolean = true
        def apply(): String = s"Hi, mi name is ${name} and i like ${favoriteMovie}"
        def +(nickname: String): Person = new Person(s"${this.name} ${nickname}", this.favoriteMovie)
        def unary_+ : Person = new Person(this.name, this.favoriteMovie, age + 1)
        def learns(s: String): String = s"${this.name} learns ${s}"
        def learnsScala(): String = this learns "Scala"
        def apply(number: Int): String = s"${name} watched ${favoriteMovie} ${number} times"

    }

    val mary = new Person("Mary", "Inception")

    println(mary.likes("Inception"))
    println(mary likes "inception") //infix notation or operator notation. Works with methods with one parameter

    // Operators
    val tom = new Person("Tom", "Fight club")
    println(mary hangoutWith tom)

    // Mathematical operators are methods --> ALL OPERATORS ARE METHODS
    println(1 + 2)
    println(1.+(2))

    //prefix notation -> unary operators
    val x = -1
    val y = 1.unary_-
    // unary_ only works with few operators, - + ~ !

    println(!mary)
    println(mary.unary_!)

    //postfix notation -> method without parameter
    println(mary.isAlive)
    println(mary isAlive)

    //apply
    println(mary.apply())
    println(mary())

    /*
     1. Overlad the plus operator wich receives a string and will return a new person with nickname
        mary + "the rockstar" => new person "Mary (the rockstar)"

     2. Add an age to the person class with default zero
        Add unary plus operator which incremente the value of age
        +mary => mary with the age increment

     3. Add "learns" method in the Person class => "Mary learns Scala"
        Add a "learnsScala" method, calls the learns method with "Scala" as a parameter
        use it in postfix notation

     4. Overload the apply method to receive a number and returns a string
        mary.apply(2) => "Mary watched inception 2 times"
     */

    println((mary + "The rockstar")())
    println((mary + "The rockstar").apply())

    println((+mary).age)

    println(mary learnsScala)

    println(mary(10)    )

}
