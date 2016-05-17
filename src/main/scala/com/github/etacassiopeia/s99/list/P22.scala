package com.github.etacassiopeia.s99.list

/**
  * <h1>P22</h1>
  * Create a list containing all integers within a given range
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 2/05/16 
  */
object P22 {
  def main(args: Array[String]) {
    println(range(4, 9))
    println(recursiveRange(4, 9))
  }

  def range(start: Int, end: Int): List[Int] = {
    for (i <- List.range(start, end + 1)) yield i
  }

  def recursiveRange(start: Int, end: Int): List[Int] = {
    (start, end) match {
      case (s, e) if s <= e => s :: recursiveRange(s + 1, e)
      case _ => Nil
    }
  }
}
