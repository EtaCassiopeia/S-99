package com.github.etacassiopeia.s99

/**
  * <h1>P39</h1>
  * The P39 
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 16/05/16 
  */
object P39 {
  def main(args: Array[String]) {
    println(listPrimesInRange(7, 31))
  }

  def listPrimesInRange(s: Int, e: Int): List[Int] = {
    primes.dropWhile(_ < s).takeWhile(_ <= e).toList
  }

  def isPrime(x: Int): Boolean = {
    primes.takeWhile {
      _ <= Math.sqrt(x)
    } forall (x % _ != 0)
  }

  val primes: Stream[Int] = 2 #:: (Stream.from(3, 2) filter (isPrime(_)))
}
