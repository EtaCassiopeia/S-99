package com.github.etacassiopeia.s99.list

/**
  * <h1>P15</h1>
  * Duplicate the elements of a list a given number of times
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 30/04/16 
  */
object P15 {
  def main(args: Array[String]) {
    println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
    println(duplicateNUsingFill(3, List('a, 'b, 'c, 'c, 'd)))
  }

  def duplicateNUsingFill[T](n: Int, list: List[T]): List[T] = {
    list flatMap {
      case e => List.fill(n)(e)
    }
  }

  def duplicateN[T](n: Int, list: List[T]): List[T] = list match {
    case Nil => Nil
    case head :: tail => (for (e <- List.range(0, n)) yield head) ::: duplicateN(n, tail)
  }
}
