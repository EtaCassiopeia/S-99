package com.github.etacassiopeia.s99

/**
  * <h1>P06</h1>
  * Find out whether a list is a palindrome
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 28/04/16 
  */
object P06 {
  def main(args: Array[String]) {
    println(isPalindrome(List(1, 2, 3, 2, 1)))

    println(+:.unapply(List(1, 2, 3, 2, 1)) match {
      //res0: Option[(Int,List[Int])] = Some(1,(List(1, 2, 3, 2)))
      case Some((x, l)) => :+.unapply(l) //res1: Some((List(2, 3, 2),1))
      case _ =>
    })
  }

  def isPalindrome[T](list: List[T]): Boolean = list match {
    //case x +: l :+ y => {println(l); x == y && isPalindrome(l);} //two different operator mention that <l> is a list
    case +:(x, :+(l, y)) => x == y && isPalindrome(l) //infix notation
    case _ => true
  }
}
