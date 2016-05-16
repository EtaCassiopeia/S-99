package com.github.etacassiopeia.s99

/**
  * <h1>P40</h1>
  * Goldbach's conjectures
  * Goldbach's conjectures says that every positive even number
  * greater than 2 is the sum of two prime numbers. E.g. 28=5+23
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 16/05/16 
  */

import S99Int._

object P40 {
  def main(args: Array[String]) {


    println(28.goldbach)
    println(28.goldbach2)

    val start=System.nanoTime()
    println(s"${10090.goldbach} : ${System.nanoTime()-start}")
    println(s"${10090.goldbach2} : ${System.nanoTime()-start}")
  }
}
