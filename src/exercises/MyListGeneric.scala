package exercises

abstract class MyGenericList[+A] {

    def head: A
    def tail: MyGenericList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyGenericList[B]

    /*
        List of integers
        Single linked list
        head = returns the first element of the list
        tail = reminder of the list
        isEmpty = is this lis empty
        add = receives an integer and returns a new list with this element added
        toString = string representation
     */
    def printElements: String
    override def toString: String = "[" + printElements + "]"

    def map[B](transformer: MyTransformer[A,B]): MyGenericList[B]
    def flatMap[B](transformer: MyTransformer[A, MyGenericList[B]]): MyGenericList[B]
    def filter(predicate: MyPredicate[A]): MyGenericList[A]

    def ++[B >: A](list: MyGenericList[B]): MyGenericList[B]
}

object GenericEmpty extends MyGenericList[Nothing] {

    def head: Nothing = throw new NoSuchElementException
    def tail: MyGenericList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyGenericList[B] = new GenericCons(element,GenericEmpty)

    def printElements: String = ""
    def map[B](transformer: MyTransformer[Nothing,B]): MyGenericList[B] = GenericEmpty
    def flatMap[B](transformer: MyTransformer[Nothing, MyGenericList[B]]): MyGenericList[B] = GenericEmpty
    def filter(predicate: MyPredicate[Nothing]): MyGenericList[Nothing] = GenericEmpty

    override def ++[B >: Nothing](list: MyGenericList[B]): MyGenericList[B] = list
}

class GenericCons[+A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {

    def head: A = h
    def tail: MyGenericList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyGenericList[B] = new GenericCons(element, this)

    def printElements: String =
        if(t.isEmpty) "" + h
        else h + " " + t.printElements

    def filter(predicate: MyPredicate[A]): MyGenericList[A] =
        if( predicate.test(h)) new GenericCons(h, t.filter(predicate))
        else t.filter(predicate)

    def map[B](transformer: MyTransformer[A, B]): MyGenericList[B] =
        new GenericCons[B](transformer.transform(h), t.map(transformer))

    def flatMap[B](transformer: MyTransformer[A, MyGenericList[B]]): MyGenericList[B] =
        transformer.transform(h) ++ t.flatMap(transformer)

    override def ++[B >: A](list: MyGenericList[B]): MyGenericList[B] = new GenericCons[B](h, t ++ list)


}

object GenericListTest extends App {
    val listOfIntegers: MyGenericList[Int] = new GenericCons(1, new GenericCons(2, new GenericCons(3, GenericEmpty)))
    val listOfStrings: MyGenericList[String] = new GenericCons("Hello", new GenericCons("Scala", GenericEmpty))

    println(listOfIntegers.toString)
    println(listOfStrings.toString)
}


trait MyPredicate[-T] {
    def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
    def transform(element: A): B
}