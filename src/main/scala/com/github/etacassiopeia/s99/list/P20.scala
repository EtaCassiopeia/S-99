package com.github.etacassiopeia.s99.list

/**
  * <h1>P20</h1>
  * Remove Kth element fom a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 1/05/16 
  */
object P20 {
  def main(args: Array[String]) {
    println(removeAt(1, List('a, 'b, 'c, 'd)))
  }

  def removeAt[T](i: Int, list: List[T]): (List[T], T) = {

    def inline(in: Int, l: List[T], mem: List[T]): (List[T], T) = {
      l match {
        case head :: tail if in > 0 => inline(in - 1, tail, head +: mem)
        case head :: tail => (mem ::: tail, head)
        case Nil => throw new NoSuchElementException
      }
    }

    inline(i, list, List[T]())
  }
}
