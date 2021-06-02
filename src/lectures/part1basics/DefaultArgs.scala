package lectures.part1basics

object DefaultArgs extends App{
  def factorialTailrec(n: Int, accumulator: Int = 1): Int={
    if (n==1) accumulator
    else factorialTailrec(n-1, n*accumulator)
  }
  val fact10= factorialTailrec(10)
  println(fact10)
  
  def savePicture(format: String= "jpg", width: Int=1920, height: Int=1080) : Unit = println("Saving pictures")
  savePicture(width=800)
  
  /*
   1. pass in every leading arguement
   2. name the arguements
   */
  
  savePicture(width=800,height=100,format="bmp")
}