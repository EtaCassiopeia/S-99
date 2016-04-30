package com.github.etacassiopeia.s99

/**
  * <h1>P14</h1>
  * Duplicate the elements of a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 30/04/16 
  */
object P14 {
  def main(args: Array[String]) {
    println(duplicate(List('a, 'b, 'c, 'c, 'd)))
  }

  def duplicate[T](list: List[T]): List[T] = list match {
    case Nil => List[T]()
    case head :: tail => head :: head :: duplicate(tail)
  }
}
