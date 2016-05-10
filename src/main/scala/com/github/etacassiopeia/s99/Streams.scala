package com.github.etacassiopeia.s99

/**
  * <h1>Fibonacci</h1>
  * Recursive Streams : Fibonacci , Factorial , PI
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 4/05/16 
  */
object Streams {

  def main(args: Array[String]) {
    import scala.math.BigInt
    lazy val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map(x => {
      x._1 + x._2
    })

    lazy val N: Stream[BigInt] = Stream.cons(BigInt(1), N.map(_ + 1))

    lazy val fibsCons: Stream[BigInt] = Stream.cons(BigInt(0), Stream.cons(BigInt(1), fibsCons.zip(fibsCons.tail).map(x => x._1 + x._2)))

    lazy val fac: Stream[BigInt] = Stream.cons(BigInt(1), fac.zip(N).map(a => a._1 * a._2))

    lazy val piOver4: Stream[Double] = Stream.cons(1d, N.map(a => (1 - (a.toDouble % 2) * 2) / (2 * a.toDouble + 1)))

    def estimatePi(n: Int): Double = piOver4.take(n).sum * 4

    def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)

    println(fibs.take(5).mkString(" "))
    println(fibsCons.take(5).mkString(" "))
    println(fibFrom(0, 1).take(5).mkString(" "))

    println(fac.take(5).mkString(" "))

    println("Pi estimate: %s".format(estimatePi(5000)))

  }
}
