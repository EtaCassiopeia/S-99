package com.github.etacassiopeia.s99

/**
  * <h1>P16</h1>
  * Drop every Nth element from a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 30/04/16 
  */
object P16 {
  def main(args: Array[String]) {
    println(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(dropByGrouped(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def drop[T](n: Int, list: List[T]): List[T] = {
    val reservedN = n

    def dropNth(n: Int, list: List[T]): List[T] = {
      list match {
        case Nil => Nil
        case head :: tail if n > 1 => head +: dropNth(n - 1, tail)
        case head :: tail => dropNth(reservedN, tail)
      }
    }

    dropNth(n, list)
  }

  def dropByGrouped[T](n: Int, list: List[T]): List[T] = {
    list.grouped(n) flatMap {
      case e => e.take(n - 1)
    } toList
  }
}
