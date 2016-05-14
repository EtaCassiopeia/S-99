package com.github.etacassiopeia.CtCI.arrayslist

/**
  * <h1>Permutation</h1>
  * Given two strings, write a method to decide if one is a permutation of the other
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 12/05/16 
  */
object Permutation {
  def main(args: Array[String]) {
    println(isPermutation("carrot", "tarroc"))
    println(isPermutationByCounting("carrot", "tarroc"))
    println(isPermutation("car", "tarroc"))
    println(isPermutationByCounting("car", "tarroc"))
  }

  def isPermutation(str1: String, str2: String): Boolean = {
    //sort and then examine elements
    str1.sorted.sameElements(str2.sorted)
  }

  def isPermutationByCounting(str1: String, str2: String): Boolean = {
    if (str1.length != str2.length)
      return false

    val list = new Array[Int](128)

    str1.foreach(c => list(c) = list(c) + 1)
    str2.forall(c => {
      list(c) = list(c) - 1
      list(c) >= 0
    })
  }
}
