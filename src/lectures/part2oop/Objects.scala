package lectures.part2oop

object Objects extends App{
  
  //SCALA DOEN NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")
  
  object Person { // type + its only instance
    // "static"/"class" level fuctionality
    val N_EYES = 2
    def canFly: Boolean = false
    
    //factory method
    def apply(mother: Person, father: Person) : Person = new Person("Bobbie")
  }
  
  class Person (val name: String){
    //instance level functionality
  }
  
  //COMPANIONS class Person and object Person(resides in same scope and same name)
  println(Person.N_EYES)
  println(Person.canFly)
  
  //Scala object = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)
  val bobbie = Person(mary,john) //Person.apply(mary,john)
  
  //Scala applications = Scala object with
  // def main(args: Array[String]): Unit
  
}