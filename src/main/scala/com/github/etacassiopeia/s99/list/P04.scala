package com.github.etacassiopeia.s99.list

/**
  * <h1>P04</h1>
  * Find the number of elements of a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 28/04/16 
  */
object P04 {
  def main(args: Array[String]): Unit = {
    println(length(List(1, 1, 2, 3, 4, 8)))
    println(length(List.empty[Int]))
  }

  def length[T](list: List[T]): Int = {

    def internal(acc: Int, l: List[T]): Int = l match {
      case Nil => acc
      case head :: tail => internal(acc + 1, tail)
    }

    internal(0, list)
  }
}
