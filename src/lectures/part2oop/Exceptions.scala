package lectures.part2oop

object Exceptions extends App{
  val x: String = null
  // println(x.length) - this will crash with NullPointerException
  
  // 1. throwing  exceptions
  // val aWierdValue: String = throw new NullPointerException
  
  //throwable classes extend the Throwable class
  // Exception and error are the major throwable subtypes
  
  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int = 
    if (withExceptions) throw new RuntimeException("No Int for you!")
    else 42
    val potentialFail = try{
      // code that mit fail
     val x= getInt(true)
    } catch {
      //case e: RuntimeException => println("caught a Runtime Exception")
      case e: RuntimeException => 43
    } finally {
      // code that will get executed no matter what 
      // optional
      // does not influence the return type of this expression
      // use finally only for side effects
      println("Finally " +x)
      
      // 3. how to write own exceptions
      class myException extends Exception 
      
    }
    println("potentialFail: "+potentialFail)
    
    def factorial(n: Int): Int = {
      if (n==1) 1
      else n*factorial(n-1)
    }
    
   // val fact: Int = (factorial(500000000))
    class OverflowException extends RuntimeException
    class UnderflowException extends RuntimeException
    class MathCalculationException extends RuntimeException("Division by 0")
    case  class Calculator(x: Int, y: Int){
      def +() = {
        val result  = x+y
        if(x > 0 && y > 0 && result < 0) throw new OverflowException
        else if(x < 0 && y < 0 && result > 0) throw new UnderflowException
        else result
      }
      def -() = {
        val result  = x-y
        if(x > 0 && y < 0 && result < 0) throw new OverflowException
        else if(x < 0 && y > 0 && result < 0) throw new UnderflowException
        else result
      }
      def *() = {
        val result = x*y
        if(x > 0 && y > 0 && result < 0) throw new OverflowException
        else if(x < 0 && y < 0 && result < 0) throw new OverflowException
        else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
        else if(x > 0 && y < 0 && result > 0) throw new UnderflowException
        else result
      }
      def /() = {
        if (y == 0) throw new MathCalculationException
        else x/y
      }
    }
    val cal = new Calculator(2,0)
    println("Add")
    println(cal +)
    println("Sub")
    println(cal -)
    println("Mult")
    println(cal *)
    println("divide")
    println(cal /)
    
    // Out Of Memory 
   // val array = Array.ofDim(Int.MaxValue)
    
    //Stack overflow
    def indefinite : Int = 1+ indefinite
    //val noLimit = indefinite
    
    
} 