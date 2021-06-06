package lectures.part4patternMatching

object PatternsEverywhere extends App{

// big idea
  try {
    //code
  } catch{
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }
  // catches are MATCHES
  /*
  try{
  //code
  } catch(e){
  e match{
   case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
    }
    }
   */

  //big idea #2
  val list = List(1,2,3,4)
  val evenOnes = for{
    x<- list if x%2==0
  } yield 10 * x

  // generators are also based on PATTERN MATCHING
  val tuples = List((1,2),(3,4))
  val filterTuples = for{
    (first,second) <- tuples
  } yield first * second
  println(filterTuples)
  // case classes, :: operators, ...

    // big idea #3

  val tuple = (1,2,3)
  val (a,b,c) = (1,2,3)
  // multiple value def based on pattern matching
  // ALL THE POWER





  val head::tail = list
  println(head)
  println(tail)

  //big idea #4
  // partial function

  val mappedList = list.map {
    case v if v%2 == 0 => v + " is even"
    case 1=> "the one"
    case _ => "something else"
  }
  println(mappedList)
}
