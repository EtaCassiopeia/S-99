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
  }

  def isPalindrome[T](list: List[T]): Boolean = list match {
    case x +: l :+ y => x==y && isPalindrome(l)   //two different operator mention that <l> is a list
    case _ => true
  }
}
