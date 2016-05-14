package com.github.etacassiopeia.s99

import scala.util.Random

/**
  * <h1>P23</h1>
  * Extract a given number of randomly selected elements from a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 2/05/16 
  */
object P23 {

  def main(args: Array[String]) {
    println(randomSelect(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h)))
  }

  def randomSelect[T](n: Int, list: List[T]): List[T] = {
    if (n > list.length)
      throw new NoSuchElementException

    val indexes = Random.shuffle(list.indices.toList).take(n)
    for (i <- indexes) yield list(i)
  }
}
