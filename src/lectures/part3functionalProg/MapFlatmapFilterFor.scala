package lectures.part3functionalProg

object MapFlatmapFilterFor extends App{
  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)
  
  //map
  println(list.map(_+1))
  println(list.map(_+ " is a number"))
  
  //filter
  println(list.filter(_% 2==0))
  
  //flatmap
  val toPair = (x: Int) => List(x,x+1)
  println(list.flatMap(toPair))
  
  //print all combinations between two lists
  val numbers  = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black","white")
  // List("a1","a2" ....."d4")
  
  // Iteration
  val combination = numbers.filter(_%2==0).flatMap(n=> chars.flatMap(c=> colors.map(color=> " "+ c + n+"-" + color)))
  println(combination)
  
  //foreach
  list.foreach(println)
  
  // for-combinations
  val forCombinations = for {
    n <- numbers if n%2==0
    c <- chars
    color <- colors
  }yield  " "+ c + n+"-" + color
      println(forCombinations)
  
  // Syntax overload
  list.map { x=>
    x*2
    
  }
  
  
}