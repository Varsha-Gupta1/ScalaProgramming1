package lectures.part2oop

object CaseClasses extends App{
  /*
   * equals, hashCode, toString
   */
  case class Person(name: String, age: Int)
 // 1. case class parameters are fields 
 val jim= new Person("Jim", 34)
  println(jim.name)
  
  // 2. sensible toString
  // println(instance) = println(instance.toString) - syntactic sugar
  println(jim.toString)
  println(jim)
  
  // 3. equals and hashCode implemented out of the box
  val jim2= new Person("Jim",34)
  println(jim==jim2)
  
  // 4. Case classes have handy copy method
  val jim3 = jim.copy()
  println(jim3)
  val jim4 = jim.copy(age=45)
  println(jim4)
  
  // 5. Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary",23)
  
  // 6. case classes are serializable
  // useful in Akka frameworks
  
  // 7. case classes have extractor patterns = case classes can be used in pattern matching
  
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}