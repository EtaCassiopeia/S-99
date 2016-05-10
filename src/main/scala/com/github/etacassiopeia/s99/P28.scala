package com.github.etacassiopeia.s99

/**
  * <h1>P28</h1>
  * Sorting a list of lists according to length of subsets
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 4/05/16 
  */
object P28 {
  def main(args: Array[String]) {
    println(lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
    println(lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
  }

  def lsort[T](list: List[List[T]]): List[List[T]] =
    list.map(x => (x.length, x))
      .sortBy(_._1).map(x => x._2)

  def lsortFreq[T](list: List[List[T]]) = {
    list.map(x => (x.length, x))
      .groupBy(_._1).toList
      .map(x => (x._2.length, x._2.map(x => x._2)))
      .sortWith((x, y) => x._1 < y._1)
      .foldLeft(List[List[T]]())((b, c) => b ::: c._2)
  }
}
