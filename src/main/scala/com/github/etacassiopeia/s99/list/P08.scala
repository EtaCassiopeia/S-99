
package com.github.etacassiopeia.s99.list

/**
  * <h1>P08</h1>
  * Eliminate consecutive duplicates of list elements
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 28/04/16 
  */
object P08 {
  def main(args: Array[String]) {
    println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(recursiveCompress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(foldLeftCompress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(foldRightCompress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }


  def foldRightCompress[T](list: List[T]): List[T] = {
    list.foldRight(List[T]()) {
      case (e, List()) => List(e)
      case (e, l) if l.head != e => e :: l
      case (e, l) => l
    }
  }

  def foldLeftCompress[T](list: List[T]): List[T] = {
    list.foldLeft(List.empty[T]) {
      case (List(), e) => List(e)
      case (l, e) if l.last != e => l :+ e
      case (l, e) => l
    }
  }

  def recursiveCompress[T](list: List[T]): List[T] = {
    list match {
      case head :: Nil => head :: Nil
      case head :: tail if (head == tail.head) => recursiveCompress(tail)
      case head :: tail => head :: recursiveCompress(tail)
    }
  }

  def compress[T](list: List[T]): List[T] = {

    def memorizedCompress(l: List[T], lastElement: Option[T]): List[T] = {
      l match {
        case head :: tail if !lastElement.isDefined => head :: memorizedCompress(tail, Some(head))
        case head :: tail if head != lastElement.get => head :: memorizedCompress(tail, Some(head))
        case head :: tail => memorizedCompress(tail, Some(head))
        case Nil => Nil
      }
    }

    memorizedCompress(list, None)
  }
}
