package com.github.etacassiopeia.s99

/**
  * <h1>P02</h1>
  * Find the last but one element of a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 28/04/16 
  */
object P02 {

  def main(args: Array[String]): Unit = {
    val result = penultimate(List(1, 1, 2, 3, 5, 8))
    //val result2 = penultimate(List.empty[Int])
    val result3 = penultimate(List(1))
    println(result3)
  }

  def penultimate[T](list: List[T]): T = list match {
    case pen :: _ :: Nil => pen
    case _ :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }
}
