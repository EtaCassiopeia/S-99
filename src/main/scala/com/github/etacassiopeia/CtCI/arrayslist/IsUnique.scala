package com.github.etacassiopeia.CtCI.arrayslist

/**
  * <h1>IsUnique</h1>
  * if a string has all unique characters
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 11/05/16 
  */
object IsUnique {

  var num: Long = 0l

  def main(args: Array[String]) {
    println(isUnique("mohsen"))
    println(isUnique("mohsenm"))
  }

  def isUnique(s: String): Boolean = {
    s.map(n => n - 'a') forall (n => {
      if (checkBit(num, n)) {
        false
      } else {
        num = setBit(num, n)
        true
      }
    })
  }

  def checkBit(num: Long, i: Int): Boolean = {
    (num & (1 << i)) != 0
  }

  def setBit(num: Long, i: Int): Long = {
    num | (1 << i)
  }
}
