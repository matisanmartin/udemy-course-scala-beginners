package lectures.part2OOP

object Objects extends App {

    // Scala does not have class level functionality ("static")
    object Person {
        val N_EYES = 2

        def canFly: Boolean = false

        //factory method -> build person given parameters
        //def from(mother: Person, father: Person): Person = new Person("bobby")
        def apply(mother: Person, father: Person): Person = new Person("bobby")
    }

    // Instance level funcionality
    class Person(val name: String) {

    }

    //COMPANION --> Class and object are companions, same scope same name

    println(Person.N_EYES)
    println(Person.canFly)

    //Scala object is a singleton instance
    val mary = new Person("mary")
    val john = new Person("john")
    println(mary == john) // point to the same instance

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    val bobby = Person(mary, john) // apply method in the person singleton object

    //Scala applications --> A scala object with a main method, main(args: Array[String]): Unit



}
