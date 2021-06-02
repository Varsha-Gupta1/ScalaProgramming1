package lectures.part1basics

object Recursion extends App{
  def factorial(n: Int) : Int = {
    if (n==1) 1
    else {
     println("Computing factorial of "+n+"- I first need factorial of "+(n-1)) 
    val result = n* factorial(n-1)
      println("Computed factorial of " +n)
      result
    }
  }
  println(factorial(10))
  
  def anotherFactorial(n: Int) : BigInt = {
    def factHelper(x: Int,accumulator: BigInt) : BigInt = {
      if (x==1) accumulator
      else factHelper(x-1, x*accumulator) //TAIL RECURSION = use recursive call as the LAST expression
    }
      factHelper(n,1)
   
  }
  println(anotherFactorial(50))
  
  //WHEN YOU NEED LOOPS, USE _TAIL_RECURSION
  
  def stringCat(x: Int, aString: String) : String= {
   def helper(n: Int,accumulator: String ) : String = {
     if (n==1) accumulator
     else helper(n-1,aString+accumulator)     
   }  
   helper(x,aString)
  }
  println(stringCat(5,"Hello "))
  
  def isPrime(n: Int) : Boolean ={
    def isPrimeTailrec(t: Int, isStillPrime: Boolean) : Boolean = {
      if (isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1, n % t !=0 && isStillPrime)
    }
    isPrimeTailrec(n/2, true)
    }
  
  println(isPrime(37))
  
  def fibonacci(n: Int) : Int ={
    def fiboTailrec(i: Int, last: Int,nextLast: Int): Int = {
      if (i>=n) last
      else fiboTailrec(i+1, last+nextLast, last)
    }
    if (n<=2) 1
    else fiboTailrec(2,1,1)
  }
  println(fibonacci(8))
}