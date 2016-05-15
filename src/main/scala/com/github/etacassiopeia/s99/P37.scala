package com.github.etacassiopeia.s99

/**
  * <h1>P37</h1>
  *
  * Calculate Euler`s totient function phi(m) (improved)
  * if the list of the prime factors of a number m is known int the form of problem 36 then the function
  * phi(,) can be efficiently calculated as follows:
  * Let[[p1,m1],[p2,m2],[p3,m3],...] be the list of prime factors ( and their multiplicities) of a given number m.
  * then phi(m) can be calculated with the following formula:
  *
  * phi(m) = (p_1-1)*p_1^(m_1-1) * (p_2-1)*p_2^(m_2-1) * (p_3-1)*p_3^(m_3-1) * ...
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 15/05/16 
  */
object P37 {
  def main(args: Array[String]) {
    import S99Int._

    println(10.totient)
  }
}
