package com.github.etacassiopeia.s99

/**
  * <h1>P01</h1>
  * Find the last element of a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 28/04/16 
  */
object P01 {
  def main(args: Array[String]) {
    val result = last(List(1, 2, 3, 4, 5, 8))
    println(result)

    //val result2 = last(List.empty[Int])
  }

  def last[T](list: List[T]): T = list match {
    case head :: Nil => head
    case head :: tail => last(tail)
    case _ => throw new NoSuchElementException
  }
}
