package com.github.etacassiopeia.s99

/**
  * <h1>P13</h1>
  * Run-length encoding of a list (direct solution)
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 30/04/16 
  */
object P13 {

  def main(args: Array[String]) {
    println(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  def encodeDirect[T](list: List[T]): List[Any] = {

    def encode(l: List[T], mem: List[T]): List[Any] = {
      l match {
        case Nil => List((mem.size, mem.head))
        case head :: tail if mem.isEmpty || head == mem.head => encode(tail, head +: mem)
        case l => (mem.size, mem.head) +: encode(l, List.empty[T])
      }
    }

    encode(list, List.empty[T])
  }
}
