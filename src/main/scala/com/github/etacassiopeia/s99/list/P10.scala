package com.github.etacassiopeia.s99.list

/**
  * <h1>P10</h1>
  * Run-length encoding of a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 28/04/16 
  */
object P10 {
  def main(args: Array[String]) {
    println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  def encode[T](list: List[T]): List[(Int, T)] = {

    def counter(l: List[T], mem: List[T]): List[(Int, T)] = {
      l match {
        case Nil => List((mem.size, mem.head))
        case head :: tail if mem.isEmpty || mem.head == head => counter(tail, head +: mem)
        case l => (mem.size, mem.head) +: counter(l, List.empty[T])
      }
    }

    counter(list, List.empty[T])
  }

}
