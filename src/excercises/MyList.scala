package excercises

abstract class MyList[+A] {
 def head : A
 def tail : MyList[A]
 def isEmpty: Boolean
 def add[B >: A](n: B): MyList[B]
 def printList: String
 override def toString: String = "[" + printList +"]"
 def map[B](transformer: Function1[A,B]): MyList[B]
 def filter(predicate: A=> Boolean): MyList[A]
 def flatMap[B](transformer: Function1[A,MyList[B]]): MyList[B]
 
 def ++[B>: A](list: MyList[B]): MyList[B]
 
 //hofs
 def foreach(f: A => Unit): Unit
 def sort(f1 :(A,A) => Int) : MyList[A]
 def zipWith[B,C](list: MyList[B], zip:(A,B) => C) : MyList[C]
 def fold[B](start: B)(operator: (B,A) => B): B
}

case object Empty extends MyList[Nothing]{
  def head : Nothing = throw new NoSuchElementException
 def tail : MyList[Nothing] = throw new NoSuchElementException
 def isEmpty: Boolean = true
 def add[B >: Nothing](n: B): MyList[B] = new Cons(n,Empty)

  //higher order functions
  def map[B](transformer: Function1[Nothing,B]): MyList[B] = Empty
 def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
 def flatMap[B](transformer: Function1[Nothing,MyList[B]]): MyList[B] = Empty
  def printList = " "
  
  def ++[B>: Nothing](list: MyList[B]): MyList[B] = list
  
  def foreach(f: Nothing => Unit): Unit = ()
  def sort(f1 :(Nothing, Nothing) => Int) : MyList[Nothing] = Empty
  def zipWith[B,C](list: MyList[B], zip:(Nothing,B) => C) : MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty
  }
  
  def fold[B](start: B)(operator: (B,Nothing) => B): B = start
}


case class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
    def head : A ={
      println("Head: "+h)
      h
    }
 def tail : MyList[A] = {
   println("tail: "+t)
      t
 }
 def isEmpty: Boolean = false
def add[B >: A](n: B): MyList[B] = new Cons(n,this)

  def  printList  = {
    
      if(t.isEmpty) "" + h
      else h + " "+ t.printList
    }
/*
 [1,2,3].filter(x%2 == 0)
 = [2,3].filter
 = new Cons(2, [3].filter(x%2 == 0)
 = new Cons(2, Empty.filter(x%2 == 0)
 = new Cons(2, Empty)
 */
  def filter(predicate: A => Boolean): MyList[A] = {
 if (predicate(h)) new Cons(h,t.filter(predicate)) 
 else t.filter(predicate)
  }
  /*
   [1,2,3].map(n*2)
    = new Cons(2, [2,3].map(n*2)
    = new Cons(2, new Cons(4, [3].map(n*2)
    = new Cons(2, new Cons(4, new Cons(6 , Empty.map(n*2)
    = new Cons(2, new Cons(4, new Cons(6 , Empty)
   */
  def map[B](transformer: Function1[A,B]): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }
  /*
   * [1,2] ++ [3,4]
   * = new Cons(1, 2 ++ [3,4])
   * = new Cons(1, new Cons(2, Empty ++ [3,4]
   * = new Cons(1, new Cons(2, [3,4]
   * = new Cons(1, new Cons(2, new Cons(4, new Cons(5, Empty)
   */
  def ++[B>: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
  
  def flatMap[B](transformer: Function1[A,MyList[B]]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }
  /*
   * [1,2].flatMap(n=> [n,n+1])
   * = [1,2] ++ [2].flatMap(n=> [n,n+1])
   * = [1,2] ++ [2,3] ++ Empty.flatMap(n=> [n,n+1])
   * = [1,2] ++ [2,3] ++ Empty
   * = [1,2,3,4]
   */
  
  def foreach(f: A => Unit): Unit = {
   f(h)
   t.foreach(f)
 }
  
  def sort(f1 :(A,A) => Int) : MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
     
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if(f1(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x,sortedList.tail))
    }
      
    val sortedTail = t.sort(f1)
    insert(h, sortedTail)
  }
  
  def zipWith[B,C](list: MyList[B], zip:(A,B) => C) : MyList[C]={
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail,zip))
  }
  
  /*
   * [1,2,3].fold(0)(+)
   * = [2,3].fold(1)(+)
   * = [3].fold(3)(+)
   * = [].fold(6)(+)
   * = 6
   */
 def fold[B](start: B)(operator: (B,A) => B): B = {
    val newStart = operator(start,h)
    t.fold(newStart)(operator)
  }
  
  
}



object ListTest extends App{
  val cons = new Cons(1, new Cons(2,new Cons(3,Empty)))
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2,new Cons(3,Empty)))
   val ClonelistOfIntegers: MyList[Int] = new Cons(1, new Cons(2,new Cons(3,Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val ListOfStrings: MyList[String]  = new Cons("Hello", new Cons("Scala", Empty))
  cons.add(7)
  cons.head
  cons.tail
  cons.tail.head
  

println(cons.map((x: Int) => x*2))
  println(cons.map(_*2))
  println(cons.filter((x: Int) => (x%2==0)))
  println(cons.filter(_%2==0))

  
println(listOfIntegers ++ anotherListOfIntegers)
println(listOfIntegers==ClonelistOfIntegers)

listOfIntegers.foreach(x=> println(x))
println(listOfIntegers.sort((x,y)=> y-x))
println(anotherListOfIntegers.zipWith[String, String](ListOfStrings, _ + "-" + _))
println(listOfIntegers.fold(0)(_+_))
println(anotherListOfIntegers.fold(0)(_+_))
  /* println(cons.tail.tail.head)
  println(cons.add(7).head)
  println(cons.tail.tail.head)
  println(cons.isEmpty)
  println(cons.toString) */


def toCurry(f: (Int, Int)=> Int):(Int=> Int => Int)={
    x => y => f(x,y)
  }
  
  def fromCurry(f: (Int=>Int=> Int)): (Int,Int)=> Int =
    (x,y) => f(x)(y)
    
    
    // FunctionX
    def compose[A,B,T](f: A=> B, g: T=> A): T=> B =
      x=> f(g(x))
      
      def andThen[A,B,C](f: A=> B, g: B=> C): A=> C =
      x=> g(f(x))
      
      def superAdder2: (Int=> Int=> Int) = toCurry(_+_)
      def add4= superAdder2(4)
      println(add4(17))
      
      val simpleAdder = fromCurry(superAdder2)
      println(simpleAdder(4,17))
      
      val add2 = (x: Int) => x+2
      val times3 = (x:Int) => x*3
      
      val composed = compose(add2,times3)
      val ordered = andThen(add2,times3)
      println(composed(4))
      println(ordered(4))
      
      val combinations = for {
        n <- listOfIntegers
        string <- ListOfStrings
      } yield n +"-"+ string
      
      println(combinations)
} 