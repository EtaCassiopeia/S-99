package com.github.etacassiopeia.s99

/**
  * <h1>P35</h1>
  * Determine the prime factors of a given positive integer
  * Construct a flat list containing the prime factors in ascending order
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 14/05/16 
  */
object P35 {
  def main(args: Array[String]) {
    import S99Int._
    println(315.primeFactors)
    println(75.primeFactors)
    println(12.primeFactors)
    //println(0.primeFactors)
  }
}
