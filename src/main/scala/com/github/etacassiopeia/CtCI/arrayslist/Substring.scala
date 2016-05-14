package com.github.etacassiopeia.CtCI.arrayslist

/**
  * <h1>Substring</h1>
  * Assume you have a method isSubstring which checks if one word is a substring of another.
  * Given two string ,S1 and S2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 12/05/16
  */
object Substring {
  def main(args: Array[String]) {
    println(isRotation("waterbottle", "erbottlewat"))
  }

  def isRotation(s1: String, s2: String): Boolean = isSubstring2(s2 + s2, s1)

  def isSubstring(s1: String, s2: String): Boolean = {
    if (s1.length >= s2.length) {
      s1.contains(s2)
    } else
      false
  }

  def indexOf(s: String, c: Char, startFrom: Int): Int = {
    for (i <- s.indices.drop(startFrom)) {
      if (s.charAt(i) == c)
        return i
    }
    -1
  }
  
  def isSubstring2(s1: String, s2: String, startFrom: Int = 0): Boolean = {
    if (s1.length < s2.length)
      return false

    val firstChar = s2.charAt(0)
    val i = indexOf(s1, firstChar, startFrom)
    if (i != -1 && s1.length - i >= s2.length) {
      for (j <- s2.indices.drop(1)) {
        if (s1.charAt(j + i) != s2.charAt(j))
          return isSubstring2(s1, s2, i + 1)
      }
      true
    } else
      false
  }
}
