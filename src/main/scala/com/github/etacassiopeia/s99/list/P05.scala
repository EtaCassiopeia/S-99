package com.github.etacassiopeia.s99.list

/**
  * <h1>P05</h1>
  * Reverse a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 28/04/16 
  */
object P05 {
  def main(args: Array[String]): Unit = {
    println(reverse(List(1, 1, 2, 3, 4, 8)))
  }

  def reverse[T](list: List[T]): List[T] = {

    def internal(currentList: List[T], newList: List[T]): List[T] = currentList match {
      case Nil => newList
      case head :: tail => internal(tail, head :: newList)
    }

    internal(list, List.empty[T])
  }
}
