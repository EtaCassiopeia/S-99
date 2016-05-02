package com.github.etacassiopeia.s99

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
  }

  def insertAt[T](e: T, position: Int, list: List[T]): List[T] = {
    list match {
      case head :: tail if position > 0 => (head :: e :: Nil) ::: tail
      case head :: tail => head :: insertAt(e, position - 1, tail)
    }
  }
}
