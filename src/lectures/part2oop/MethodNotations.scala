package lectures.part2oop

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String,val age: Int = 0){
    def likes(movie: String): Boolean = movie == favoriteMovie
   def +(person: Person): String = {
      s"${this.name} hangs out with ${person.name}"
    }
    def unary_! : String = s"$name, what the heck?!"
     def unary_+ : Person = new Person(name,favoriteMovie,age+1)
    
    
    def isAlive: Boolean = true
    def apply() : String = s"Hi, my name is $name and I like $favoriteMovie and I am $age years old"
    def apply(times: Int) = s"$name watched $favoriteMovie $times times"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
     
     
   def learns(): Unit = println(s"$name learns scala")
   def learnScala  = learns();
  }
  
  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //Infix notation = operator notation (syntactic sugar)
  //methods with single parameter can be called in the infix style
  
  //*operator* in scala
  
  val tom = new Person("Tom", "Fight Club")
  println(mary.+(tom))
  println(mary + tom)
  println((mary + "the rockstar")())
  println((mary.+("the rockstar")).apply())
  
  println(1 + 2)
  println(1.+(2))
  
  //ALL OPERATORS ARE METHODS.
  //AKKA ACTORS HAVE ! ?
  
  //prefix notation 
  val x= -1 //equivalent with 1.unary_-
  val y=1.unary_-
  // unary_prefix works with - + ~ !
  
  println(!mary)
  println(mary.unary_!)
  println((+mary).age)
  println((+mary)())
  
  
  // postfix notation - methods without parameters
  println(mary.isAlive)
  println(mary isAlive)
  println(mary learnScala)
  
  //apply
  println(mary.apply())
  println(mary()) //looks for 'apply' method
  println(mary(2))
  
 
}

