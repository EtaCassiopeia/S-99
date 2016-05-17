package com.github.etacassiopeia.s99.list

/**
  * <h1>P17</h1>
  * Split a list into two list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 30/04/16 
  */
object P17 {
  def main(args: Array[String]) {
    println(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def split[T](n: Int, list: List[T]): (List[T], List[T]) = {

    def mem(n: Int, list: List[T], first: List[T]): (List[T], List[T]) = {
      list match {
        case head :: tail if n > 0 => mem(n - 1, tail, first :+ head)
        case l => (first, l)
      }
    }

    mem(n, list, List[T]())
  }
}
