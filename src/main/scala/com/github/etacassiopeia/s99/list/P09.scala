package com.github.etacassiopeia.s99.list

/**
  * <h1>P09</h1>
  * Pack consecutive duplicates of list elements into sublists
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 28/04/16 
  */
object P09 {
  def main(args: Array[String]) {
    println(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  def pack[T](list: List[T]): List[List[T]] = {

    def subPack(l: List[T], mem: List[T]): List[List[T]] = {
      l match {
        case Nil => List(mem)
        case head :: tail if mem.isEmpty || mem.last == head => subPack(tail, head :: mem)
        case l => mem +: subPack(l, List.empty[T])
      }
    }

    subPack(list, List.empty[T])

  }
}
