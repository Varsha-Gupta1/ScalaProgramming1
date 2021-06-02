package lectures.part1basics

object ValuesVariablesTypes extends App{
  val x : Int = 42 
  println(x)
  //VALS ARE IMMUTATABLE
  //COMPILER CAN INFER TYPES
  
  val aStrings: String = "Hello"
  
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val aInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 56479823099836575L
  val aFloat: Float = 2.0f
  val aDoubla: Double = 3.14
  
  //variables
  
  var aVariable: Int = 4
  aVariable = 5 //side effects
}