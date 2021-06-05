package lectures.part4patternMatching

import excercises.{Cons, MyList}

import scala.collection.immutable.TreeSeqMap.Empty

object AllThePattern extends App{
 /* // 1. Constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllThePattern => "A singleton object"
  }
  // 2. match anything
  // 2.1 wildcard

  val matchAnything = x match{
    case _ =>
  }

  // 2.2 variable

  val matchVariable = x match{
    case something => s"I've found $something"
  }

  // 3. Tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1,1) =>
    case (something,2) => s"I've found $something"
  }

  val nestedTuple = (1,(2,3))
  val matchANestedTuple = nestedTuple match {
    case (_,(2,v)) =>
  }
  //PMs can be nested

  // 4. case classes - constructor pattern
  // PMs can be nested with case classes as well
  val aList: MyList[Int] = Cons(1, new Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head,Cons(subhead, subtail)) =>
  }

  // 5. List patterns
  val aStandardList = List(1,2,3,42)
val standardListMatching = aStandardList match {
  case List(1,_,_,_) => // extractor - advance
  case List(1,_*) => // list of arbitrary length - advance
  case 1 :: List(_) => // Infix pattern
  case List(1,2,3) :+ 42 => // Infix pattern
}

  // 6. type specifier
  val unknown: Any = 2
  val unknownMatch = unknown match{
    case list: List[Int] => // explicit type specifier

  }

  // 7. name binding
  val nameBinidingMatch = aList match{
    case nonEmptyList @ Cons(_,_) => //name binding=> use the name later(here)
    case Cons(1,rest @ Cons(2,_)) => // name binding inside nested patterns
  }

  // 8. Multi pattern
  val multipattern = aList match{
    case Empty | Cons(0,_) => //compound pattern (multi pattern)
  }

  // 9. if guards
  val secondElementSpecial = aList match {
    case Cons(_,Cons(specialElement,_)) if specialElement%2==0 =>
  }
*/
  val numbers= List(1,2,3)
  val numbersMatch = numbers match{
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers : List[Int] => "a list of numbers"
    case _=> ""
  }

  println(numbersMatch) //JVM trick question
}
