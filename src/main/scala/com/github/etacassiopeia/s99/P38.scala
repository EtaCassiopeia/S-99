package com.github.etacassiopeia.s99

/**
  * <h1>P39</h1>
  * Compare the two methods of calculating Euler's totient function
  * Use the solution of problems P34 and P37 to compare the algorithm. Try to calculate Phi(10090) as an example
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 16/05/16 
  */
object P38 {
  def main(args: Array[String]) {
    import S99Int._
    var start = System.nanoTime()
    println(s"${10090.totient} : ${System.nanoTime() - start}")

    start = System.nanoTime()
    println(s"${10090.totientImproved} : ${System.nanoTime() - start}")
  }
}
