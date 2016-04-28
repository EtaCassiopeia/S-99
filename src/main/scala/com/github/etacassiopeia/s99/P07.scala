package com.github.etacassiopeia.s99

/**
  * <h1>P07</h1>
  * Flatten a nested list structure
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 28/04/16 
  */
object P07 {
  def main(args: Array[String]) {
    println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
  }

  //  def flatten(list: List[Any]): List[Any] = list flatMap {
  //    case ms: List[_] => flatten(ms)
  //    case e => List(e)
  //  }

  def flatten(list: List[Any]): List[Any] = list match {
    case (x: List[_]) :: tail => flatten(x) ::: flatten(tail)
    case x :: tail => x :: flatten(tail)
    case Nil => Nil
  }
}
