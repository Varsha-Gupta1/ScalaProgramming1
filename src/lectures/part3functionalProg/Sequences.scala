package lectures.part3functionalProg

import scala.util.Random


object Sequences extends App {
  //Seq
  val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7,5,6))
  val aSequence1 = aSequence ++ Seq(7,5,6)
  println(aSequence1.sorted)
  
  //Range
  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println)
  
  (1 to 5).foreach(x=> println("Hello"))
  val y = (1 to 5).map((x: Int) => x*2)
  println(y)
  
  //Lists
  val aList = List(1,2,3)
  val pend = 42 +: aList :+ 89
  println(pend)
  
  val apples5 = List.fill(5)("apple")
  println(apples5)
  
  println(aList.mkString("-|-"))
  println(apples5.mkString("-|-"))
  
  //Arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)
  
  println(threeElements)
  threeElements.foreach(println)
  
  //mutation
  numbers(2)= 0 // syntax sugar for numbers.update(2,0)
  println(numbers.mkString("-"))
  
  //arrays and seq
  val numberSeq: Seq[Int]= numbers // implicit conversions
  println(numberSeq)
  
  //vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)
  
  //vectors vs lists
  val maxCapacity = 1000000
  val maxRuns = 1000
  def getWriteTime(collection: Seq[Int]) : Double = {
    val r = new Random //scala.util.Random
    val times = for{
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity),r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0/ maxRuns
  }
  // advantage - keeps reference to tail
  // disadvantage - updating an element in the middle takes long
  val numbersList= (1 to maxCapacity).toList
  
  // advantage - depth of the tree is small
  // needs to replace an entire 32-element chunk
  val numbersVector = (1 to maxCapacity).toVector
  
  
  //println(getWriteTime(numbersList))
   //println(getWriteTime(numbersVector))
  
}