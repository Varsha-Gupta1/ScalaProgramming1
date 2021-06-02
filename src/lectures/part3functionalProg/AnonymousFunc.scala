package lectures.part3functionalProg

object AnonymousFunc extends App{
  
  // Anonymous function (LAMBDA)
  val doubler = (x: Int) => x*2
  
  /*val doubler = new Function1[Int,Int]{
    def apply(x: Int) : Int = x*2
  } */
  
  // multiple parameter in a LAMBDA
  val adder = (x: Int, y: Int) => x+y
  val adder1: (Int, Int) => Int = (x: Int, y: Int) => x+y
  
  // no parameters
  val justDoSomething = () => 3
  
  // () is must while calling the function
  println(justDoSomething) // function itself
  println(justDoSomething()) // call
  
  // curly braces with lambda
  
  val stringToInt = { (str: String) =>
    str.toInt
  }
  
  val stringToInt1 = (x: String) => x.toInt
  
  
  // more syntactic sugar
  val niceIncrementer : Int => Int = _+1 // equivalent to x=> x+1
  val niceAdder : (Int,Int) => Int = _+_ // equivalent to (a,b) => a+b
  
  println(niceAdder(3,6))
  
  
}