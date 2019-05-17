package lectures.part2OOP

object AnonymousClasses extends App {

    abstract class Animal {
        def eat: Unit
    }

    // Real class, anonymous
    val funnyAnimal: Animal = new Animal {
        override def eat: Unit = println("AAAAA")
    }
    println(funnyAnimal.getClass)

    //equivalent
    class AnonymousClasses$$anon$1 extends Animal {
        override def eat: Unit = println("AAAAAA")
    }

    val funnyAnimal2 = new AnonymousClasses$$anon$1

    class Person(name: String) {
        def sayHi: Unit = println(s"Hi, my name is ${name}. How can I help?")
    }

    // illegal to instantiate anonymous class without parameters
    val jim = new Person("Jim") {
        override def sayHi: Unit = println(s"Hi, my name is Jim. How can I help?")
    }

    /*
        1. Generic trait MyPredicate[T] with a method test(T) => Boolean
        2. Generic trait MyTransformer[A,B] with a method transform(A) => B
        3. MyList:
           - map(transformer) => MyList
           - filter(predicate) => MyList
           - flatMap(transformer from A to MyList[B] => MyList[B]
     */

}
