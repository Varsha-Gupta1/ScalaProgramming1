package lectures.part3functionalProg

object Whatafunction extends App{
  // Dream: use functions as first class elements
  // Problem: OOP
  
  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int) : Int = element*2
  }
  
  println(doubler(2))
  
   //function types = Function[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String) : Int = string.toInt
  }
  
  println(stringToIntConverter("3")+7)
  
  val adder = new Function2[Int,Int,Int]{
    override def apply(a: Int, b: Int) : Int = a+b
  }
  
  // Function types Function2[A,B,R] == [A,B]=>R
  
  // ALL SCALA FUNCTIONS ARE OBJECTS
  
 val concat = new Function2[String, String, String]{
   override def apply(x: String, y: String): String = s"$x + $y"
 }
 
 println(concat("Hello","Scala"))
 
 // Function1[Int, Function1[Int, Int]]
 
 val superAdder = new Function1[Int, Function1[Int, Int]]{
   override def apply(x: Int) : Function1[Int, Int] = new Function1[Int, Int]{
     override def apply(y: Int) : Int  = x + y
   }
 }
 
 val superAdder1 = (x : Int) =>  (y: Int) => x+y
 val adder3 = superAdder(3)
 println(adder3(7))
 println(superAdder1(3)(4)) //Curried function
}

trait MyFunction[A,B]{
  def apply(element: A) : B
}