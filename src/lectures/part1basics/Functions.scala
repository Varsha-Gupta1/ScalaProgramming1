package lectures.part1basics

object Functions extends App {
  
  def aFunction(a: String,b: Int) : String = {
    a+" "+b
  } 
  println(aFunction("Hello",3))
  
  def aParameterlessFunction() : Int =42
  println(aParameterlessFunction())
 println(aParameterlessFunction)
 
 def aRepeatedFunction(aString: String, n: Int) : String = {
    if(n==1) aString
    else aString + aRepeatedFunction(aString,n-1)
      
  }
  println(aRepeatedFunction("Hello ",3))
  
  //WHEN YOU NEED LOOPS USE RECURSSION.
  def aFunctionWithSideEffects(aString: String) : Unit = println(aString)
  
  def aBigFuntion(n: Int) : Int = {
    def aSmallerFuntion(a: Int, b: Int): Int = a+b
    aSmallerFuntion(n,n-1)
  }
  println(aBigFuntion(4))
  def Greeting(name: String, age: Int) : Unit= println(s"Hi,my name is $name and I am $age years old")
Greeting("David",12)

def factorial(n: Int): Int = {
    if (n==1) 1
    else n * factorial(n-1)
  }
println(factorial(7))

def fibonacci(n: Int): Int = {
  if (n<=2) 1
  else fibonacci(n -1 ) + fibonacci(n-2)
}

println(fibonacci(8))

def isPrimeNumber(x: Int) : Boolean = {
  def isPrimeUntil(t: Int) : Boolean = 
    if (t<=1) true
    else x%t != 0 && isPrimeUntil(t-1)
    
    isPrimeUntil(x/2)
}

println(isPrimeNumber(1))
}