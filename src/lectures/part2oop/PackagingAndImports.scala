package lectures.part2oop
import playground._ //{PrinceCharming,Cinderella}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {
  
  // package members are accessible by their name
  val writer = new Writer("Dan", "Brown",2018)
  
  // import the package
  val princess = new Cinderella
 // val princess = new playground.Cinderella  
  //if package is not imported
  // fully qualified name
  
  // package are in hierarchy
  // matching folder structures
  
  // package object
  
  sayHello
  println(SPEED_OF_LIGHT)
  
  // imports
  
  val prince  = new PrinceCharming
  
  // 1. use fully qualified names
  //val d = new Date
  val sqlDate = new java.sql.Date(2018,5,4)
  
  // 2. Aliasing
  
  val d = new SqlDate(2018,5,4)
  
  // default imports
  // java.lang = String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println , ???
}