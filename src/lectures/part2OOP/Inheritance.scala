package lectures.part2OOP

object Inheritance extends App {

    class Animal {
        val creatureType = "wild"
        def eat = println("nomnomnom")
    }

    class Cat extends Animal {
        def crunch = {
            eat
            println("crunch crunch")
        }
    }

    val cat = new Cat

    cat.crunch

    //Constructors
    class Person(name: String, age: Int) {
        def this(name: String) = this(name, 0)
    }

    class Adult(name: String, age:Int, idCard: String) extends Person(name)

    //Overriding
    class Dog(override val creatureType: String) extends Animal {
        //override val creatureType: String = "domestic"
        override def eat: Unit = {
            super.eat
            println("crunch crunch")
        }
    }

    val dog = new Dog("canine")
    dog.eat

    println(dog.creatureType)

    class AnotherDog(dogType: String) extends Animal {
        override val creatureType: String = dogType
    }

    //type substitution (polymorphism)
    val unknownAnimal: Animal = new Dog("K9")
    unknownAnimal.eat

    // preventing overrides
    // 1- Use final on the method
    // 2- final on the class -> cannot be extended
    // 3- Seal the class (softer restriction) -> extend classes in this file only but prevent in other files

    sealed class AnotherAnimal {

    }


}
