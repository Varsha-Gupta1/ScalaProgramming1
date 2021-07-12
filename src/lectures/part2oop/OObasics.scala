package lectures.part2oop

object OObasics extends App{
val person = new Person("John",26)
println(person.age)
println(person.x)
person.greet("Daniel")
person.greet()
val author = new Writer("Dan","Brown",1970)
//val writer = new Writer("Dan","Brown",1970)
val novel = new Novel("Angels and Daemons",2010,author)

author.fullName()
println(novel.authorAge())
println(novel.isWrittenBy(author))
println(novel.copy(2012))
val counter = new Counter(0)
counter.inc.print
counter.inc.inc.inc.print
counter.inc(10).print
}

//constructor
class Person(name: String, val age: Int) {
  //body
  val x = 2
  println(1+3)
  
  //method
  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")
  //overloading - methods with same name but different signature
  def greet(): Unit = println(s"Hi, I am $name") //name or this.name will be same here
  
  //multiple constructors
  def this(name: String) = this(name,0)
  def this() = this("John Doe")
  
}

class Writer(val firstName: String, val surname: String, val year: Int){
  def fullName():Unit= println("Full Name: "+firstName+" "+surname)
}

class Novel(name: String, yearOfRelease: Int, author: Writer){
  def authorAge(): Int= yearOfRelease - author.year
  println("copy"+ this.author)
  def isWrittenBy(author: Writer): Boolean = author == this.author
  
  def copy(newYear: Int) : Novel = {
    println("New Year: " + newYear)
    new Novel(name,newYear,author)
  }
}

class Counter(val n: Int){
  def inc() ={
    println("incrementing")
    new Counter(n+1)
  }
  def dec() = {
    println("decrementing")
    new Counter(n-1)
  }
  
  def inc(x: Int) : Counter ={
  if (x==0) this 
  else  inc.inc(x-1)
  }
  
  def dec(x: Int): Counter = {
    if (x==0) this
    else dec.dec(x-1)
  }
  
  def print() = println(n)
}
//class parameter are NOT FIELDS


