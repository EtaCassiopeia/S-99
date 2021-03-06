package com.github.etacassiopeia.s99.arithmetic

/**
  * <h1>P33</h1>
  * Determine whether two positive integer number are coprime
  * Two number are coprime if their greatest common divisor equals 1
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 14/05/16 
  */
object P33 {
  def main(args: Array[String]) {
    import P32.gcd
    import S99Int._

    println(35.isCoprimeTo(64))
    println(gcd(35, 64))
  }
}
