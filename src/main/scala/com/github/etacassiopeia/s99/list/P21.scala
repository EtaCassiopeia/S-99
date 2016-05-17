package com.github.etacassiopeia.s99.list

/**
  * <h1>P21</h1>
  * Insert an element at a given position into a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 2/05/16 
  */
object P21 {

  def main(args: Array[String]) {
    println(insertAt('new, 1, List('a, 'b, 'c, 'd)))
    println(insertAt('new, 0, List('a, 'b, 'c, 'd)))
    println(insertAt('new, 3, List('a, 'b, 'c, 'd)))
    println(insertAt('new, 4, List('a, 'b, 'c, 'd)))
  }

  def insertAt[T](e: T, position: Int, list: List[T]): List[T] = {
    if (position >= list.length)
      throw new NoSuchElementException

    list match {
      case head :: tail if position == 0 => (e :: head :: Nil) ::: tail
      case head :: tail => head :: insertAt(e, position - 1, tail)
    }
  }
}
