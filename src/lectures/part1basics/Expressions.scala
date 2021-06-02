package lectures.part1basics

object Expressions extends App{
  val x =1+2 //Expression 
  println(x)
  println(2+3*4) //+ - * / & | ^ << >> >>> (right shift with zero extension)
  println(1 == x) // == != > >= < <= (Relational operator)
  println(!(1==x)) //! && || (Logical operator)
  var aVariable =2
  aVariable+=3 //also works with -= *= /= ---Side effects
  println(aVariable)
  
  // Instructions(Do) Vs Expressions (VALUE)
  
  // if Expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 //if Expression
  println(aConditionedValue)
  println (if(aCondition) 5 else 3)
  
  var i = 0
  while(i<10){
    println(i)
    i+=1
}
  
  //NEVER WRITE THIS AGAIN
  
  //EVERYTHING IN SCALA IS EXPRESSION!
  
  val aWeirdValue = (aVariable=3) // Unit == void
  println(aWeirdValue)
  
  // side effects: println(), while, reassigning 
  
  // Code blocks
  
  val aCodeBlock = {
    val y =2
    val z =y+1
    
    if (z>2) "Hello" else "Goodbye"
  }
  
println(aCodeBlock)

"Hello world" //string type
println("Hello World") //unit type

val someValue = {
  2<3
}

val someOtherValue = {
  if(someValue) 239 else 986
  42
}

println(someValue)
println(someOtherValue)

}