package com.github.etacassiopeia.s99.list

/**
  * <h1>P12</h1>
  * Decode a run-length encoded list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 30/04/16 
  */
object P12 {
  def main(args: Array[String]) {
    println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
    println(decodeWithMap(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
    println(decodeWithFoldRight(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
    println(decodeWithFoldLeft(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
  }

  def decodeWithFoldRight[T](list: List[(Int, T)]) = list.foldRight(List[T]()) {
    case ((count, value), l) => List.fill(count)(value) ::: l
  }

  def decodeWithFoldLeft[T](list: List[(Int, T)]) = list.foldLeft(List[T]()) {
    case (l, (count, value)) => l ::: List.fill(count)(value)
  }

  def decode[T](list: List[(Int, T)]): List[T] = list collect {
    case (count, value) => List.fill(count)(value)
  } flatMap (e => e)

  def decodeWithMap[T](list: List[(Int, T)]): List[T] = list map {
    case (count, value) => List.fill(count)(value)
  } flatMap (e => e)

}
