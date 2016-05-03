package com.github.etacassiopeia.s99

/**
  * <h1>P26</h1>
  * Generate the combination of K distinct objects chosen from the N elements of a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 3/05/16 
  */
object P26 {

  def main(args: Array[String]) {
    println(combinationsLoop(3, List('a, 'b, 'c, 'd, 'e, 'f)))
    println(combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)))

    println(combinationsLoop(3, List.range(1, 13)).length)
    println(combinations(3, List.range(1, 13)).length)
  }

  def combinationsLoop[T](n: Int, list: List[T]): List[List[T]] = {
    for {
      e1 <- list
      e2 <- list.takeWhile(x => x != e1)
      e3 <- list.takeWhile(x => x != e1 && x != e2)
    } yield List(e1, e2, e3)
  }

  def combinations[T](n: Int, list: List[T]): List[List[T]] = (n, list) match {
    case (1, l) => l.foldLeft(List[List[T]]())((r, c) => List(c) :: r)
    case (i, l) if l.length.equals(i) => l :: Nil
    case (i, l) => combinations(i - 1, l.tail).map(x =>
      l.head :: x) ::: combinations(i, l.tail)
  }

}
