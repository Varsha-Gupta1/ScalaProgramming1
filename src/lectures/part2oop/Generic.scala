package lectures.part2oop

object Generic extends App{
  
  class MyList[+A]{
    // use the type A - traits can also be implemented in same way
    def add[B>:A](element: B) : MyList[B] = ???
  }
  class MyMap[Key, Value]
  
  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]
  
  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]
  
  //variance problem
  
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  
  //1. List of Cat extends List of Animal = Covariance
  
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? Hard Question - We return a list of Animals
  
  // 2. Invariance
  
  class InvariantList[A]
  val InvariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
  
  // 3. Contavariance
  
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  
  // bounded types
  
  //class Cage[A <: Animal](animal: A)
  //val cage = new Cage(new Dog)
  
  
}