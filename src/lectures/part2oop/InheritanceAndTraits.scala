package lectures.part2oop

import scala.language.postfixOps

object Inheritance extends App{
  
  //Single class inheritance
  class Animal{
    val creatureType= "Wild"
   protected def eat = println("nomnom")
  }
  
  class Cat extends Animal{
    def crunch = {
      eat
      println("chrunch chrunch")
    }
  }
  
  val cat = new Cat
cat crunch

//constructor

class Person(name: String, age: Int)
class Adult(name: String, age: Int, idCard: String) extends Person(name,age)
  
  //overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType = "Domestic"
    override def eat = {
      super.eat
      println("chrunch chrunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)
  
  //type substitution (in broad sense: Polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
 // unknownAnimal.eat -- even if eat method is not protected, it will take overridden value
  
  //overridding(diff implementation of same method in derived classes) 
  //vs overloading(methods within same class with same name but different signature)
  
  //super
  //preventing override
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevents extension in other files(keyword sealed before class name)
}