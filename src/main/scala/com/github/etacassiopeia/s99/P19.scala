package com.github.etacassiopeia.s99

/**
  * <h1>P19</h1>
  * Rotate a list N places to the left
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 1/05/16 
  */
object P19 {
  def main(args: Array[String]) {
    println(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def rotate[T](n: Int, list: List[T]): List[T] = {

    def mem(i: Int, l: List[T], newList: List[T]): List[T] = {
      l match {
        case head :: tail if i > 0 => mem(i - 1, tail, newList :+ head)
        case e => e ::: newList
      }
    }

    mem(if (n > 0) n else list.size + n, list, List[T]())
  }
}
