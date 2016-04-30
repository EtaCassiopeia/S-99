package com.github.etacassiopeia.s99

/**
  * <h1>P11</h1>
  * Modified run-length encoding
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 30/04/16 
  */
object P11 {
  def main(args: Array[String]) {
    println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(encodeModifiedUsingP10(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  def encodeModified[T](list: List[T]): List[Any] = {
    import P09.pack

    pack(list) map {
      case l if l.size == 1 => l.head
      case e => (e.size, e.head)
    }
  }

  def encodeModifiedUsingP10[T](list: List[T]): List[Any] = {
    import P10.encode

    encode(list) map {
      case (count, value) if count == 1 => value
      case e => e
    }
  }

  def encodeDirect[T](list: List[T]): List[Any] = {

    def encode(l: List[T], mem: List[T]): List[Any] = {
      l match {
        case Nil => if (mem.size == 1) List(mem.head) else List((mem.size, mem.head))
        case head :: tail if mem.isEmpty || head == mem.head => encode(tail, head +: mem)
        case l => if (mem.size == 1) mem.head +: encode(l, List.empty[T]) else (mem.size, mem.head) +: encode(l, List.empty[T])
      }
    }

    encode(list, List.empty[T])
  }
}
