package lectures.part2oop

object AbstractDataTypes extends App{
  //Abstract class - no definition, can't be instantiated
  abstract class Animal{
    val creatureType: String
    def eat: Unit
  }
 
  class Dog extends Animal{
     val creatureType: String  = "Canine"
     def eat: Unit = println("crunch crunch")
    }
  
  //traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }
  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I am a $creatureType and I am eating a ${animal.creatureType}")
  }
  
  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
//traits Vs abstract classes
 /*
  1. Traits do not have constructor parameters(arguments)
  2. multiple traits can be inherited by the same class
  3. traits = behavior but abstract class = 'thing'
*/
}
