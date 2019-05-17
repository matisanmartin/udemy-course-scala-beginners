package lectures.part2OOP

object AbstractDataTypes extends App {

    // abstract -> unimplemented methods / classes
    abstract class Animal {
        val creatureType: String // no implementation -> abstract
        def eat: Unit
    }

    //val animal = new Animal

    //override keyword not mandatory on abstract
    class Dog extends Animal {
        override val creatureType: String = "Canine" //
        def eat: Unit = println("crunch crunch")
    }

    //traits
    trait Carnivore {
        def eat(animal: Animal): Unit
        def preferredMeal: String = "meat" //non abstract member
    }

    trait ColdBlooded

    //inherits members from Animal and Carnivore
    class Crocodile extends Animal with Carnivore with ColdBlooded {
        override val creatureType: String = "croc"
        def eat: Unit = println("nomnomnom")
        def eat(animal: Animal): Unit = println(s"Im a croc and I'm eating ${animal.creatureType}")
    }

    val dog = new Dog
    val crocodile = new Crocodile
    crocodile.eat(dog)

    /*
        Abstract classes and traits --> abstract and non abstract members
        Traits cannot have constructor parameters
        Multiple traits may be inherited by the same class
        Only one abstract class can be inherited
        Traits are behavior, abstract class is type
     */
}
