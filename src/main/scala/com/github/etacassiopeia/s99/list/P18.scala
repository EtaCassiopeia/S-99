package com.github.etacassiopeia.s99.list

/**
  * <h1>P18</h1>
  * Extract a slice from a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 1/05/16 
  */
object P18 {
  def main(args: Array[String]): Unit = {
    println(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(recursiveSlice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def slice[T](start: Int, end: Int, list: List[T]): List[T] = {
    list.zipWithIndex.filter {
      case (v, index) => index >= start && index < end
    }.map(_._1)
  }

  def recursiveSlice[T](start: Int, end: Int, list: List[T]): List[T] = {

    def slicer(list: List[T], i: Int): List[T] = {
      list match {
        case Nil => Nil
        case head :: tail if i >= start && i < end => head :: slicer(tail, i + 1)
        case head :: tail => slicer(tail, i + 1)
      }
    }

    slicer(list, 0)
  }
}
