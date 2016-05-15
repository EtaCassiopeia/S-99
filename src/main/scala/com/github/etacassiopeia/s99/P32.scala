package com.github.etacassiopeia.s99

/**
  * <h1>P32</h1>
  * Determine the greatest common divisor of two positive integer number
  * Use Euclid's algorithm.
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 14/05/16 
  */
object P32 {
  def main(args: Array[String]) {
    println(gcd(36, 63))
    println(gcd(1, 63))
    //println(gcd(-36, 63))
    //println(gcd(0, 63))
  }

  def gcd(a: Int, b: Int): Int = {
    def inline(m: Int, n: Int): Int = n match {
      case 0 => m
      case _ => inline(n, m % n)
    }

    if (a <= 0 || b <= 0)
      throw new NoSuchElementException

    if (a < b)
      inline(b, a)
    else
      inline(a, b)
  }
}
