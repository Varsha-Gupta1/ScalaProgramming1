package lectures.part3functionalProg
import scala._
object TuplesAndMaps extends App{
//tuples = finite ordered "lists"
  val aTuple = new Tuple2(2, "Hello, Scala") // Tuple2[Int, String] = (Int, String)
  println(aTuple._1)
println(aTuple.copy(_2 = "goodbye, Java"))
println(aTuple.swap)
  println(aTuple.toString)

  //Map- Keys-> values

  val aMap: Map[String,Int]=Map()
  val phonebook = Map(("Jim",555), "Daniel"->789).withDefaultValue(-1)
  // a->b is sugar for (a,b)
  println(phonebook)

  // map operation

  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  println(phonebook("Mary"))

  //add apairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)
  val name= phonebook.get("Jim")
  println(name)

  //functions on maps
  // map, filter, flatMap

  println(newPhonebook.map(pair => pair._1.toLowerCase -> pair._2))
  println(phonebook.filterKeys(x=> x.startsWith("J")))

  //mapValues
  println(phonebook.mapValues(number => number*10))
  println(phonebook.mapValues(number => "0245-" + number))

  // conversion to other collection

  println(phonebook.toList)
  println(List((2,555)).toMap)
  val names = List("Bobs", "James","Angela","Mary","Daniel","Jim")
  println(names.groupBy(name=> name.charAt(1)))
  val anotherPair = ("JIM" -> 900)
  val anotherPhonebook = phonebook + anotherPair
  println(anotherPhonebook)


}
