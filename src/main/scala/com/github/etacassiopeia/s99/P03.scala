package com.github.etacassiopeia.s99

/**
  * <h1>P03</h1>
  * Find the Kth element of a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 28/04/16 
  */
object P03 {

  def main(args: Array[String]): Unit = {
    val result = nth(2, List(1, 1, 2, 3, 4, 8))
    //val result = nth(7, List(1, 1, 2, 3, 4, 8))
    //val result = nth(1, List.empty[Int])
    println(result)
  }

  def nth[T](index: Int, list: List[T]): T = {
    list match {
      case Nil => throw new NoSuchElementException
      case head :: tail if index == 0 => head
      case head :: tail => nth(index - 1, tail)
    }
  }

}
