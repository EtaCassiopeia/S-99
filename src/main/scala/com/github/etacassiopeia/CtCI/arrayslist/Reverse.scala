package com.github.etacassiopeia.CtCI.arrayslist

/**
  * <h1>Reverse</h1>
  * Reverse a null terminated string
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 11/05/16 
  */
object Reverse {
  def main(args: Array[String]) {
    println(reverse("Hello World!"))
    println(reverseUsingArray("Hello World!"))
  }

  def reverse(str: String): String = {
    str.foldRight(new StringBuilder)((s, sb) => sb.append(s)).toString
  }

  def reverseUsingArray(str: String): String = {
    val lastIndex = str.length - 1
    val tmp = new Array[Char](lastIndex + 1)

    str.zipWithIndex foreach (x => tmp(lastIndex - x._2) = x._1)

    new String(tmp)
  }
}
