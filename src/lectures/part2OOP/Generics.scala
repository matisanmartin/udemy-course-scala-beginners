package lectures.part2OOP

object Generics extends App {

    class MyList[+A] {
        //def add(element: A): MyList[A] = ??? // error ->
        def add[B >: A](element: B) : MyList[B] = ???
    }

    //A = Cat
    //B = Dog -> Animal


    class MyMap[Key, Value]

    val listOfIntegers = new MyList[Int]
    val listOfStrings = new MyList[String]

    // Generic methods -> Objects cannot be parameterized
    object MyList {
        def empty[A]: MyList[A] = ???
    }

    val emptyListOfIntegers = MyList.empty[Int]

    // variance problem
    class Animal
    class Dog extends Animal
    class Cat extends Animal

    // cat extends animal, List[Cat] extendes List[Animal] ?
    //
    // 1) yes -> COVARIANCE

    class CovariantList[+A]
    val animal: Animal = new Cat
    val animalList: CovariantList[Animal] = new CovariantList[Cat]

    //add any animal to it?
    //animalList.add(new Dog) --> in theory yes, but will pollute, hard question -> return a list of animals

    //2) No = INVARIANCE
    class InvariantList[A]
    //val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] //error
    val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

    //3) Hell, no! CONTRAVARIANCE
    class ContravariantList[-A]
    val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

    class Trainer[-A]
    val trainer: Trainer[Cat] = new Trainer[Animal] // can also train other animals

    // Bounded types

    //upper bounded type
    class Cage[A <: Animal](animal: A) //subtypes of animal
    val cage = new Cage(new Dog)

    class Car
    //val newCage = new Cage(new Car) //error when running

    //lower bounded type
    class AnotherCage[A >: Animal](animal: A)

    // expand my list to be generic

}
