package com.github.etacassiopeia.CtCI.arrayslist

/**
  * <h1>Compress</h1>
  * write a method to perform basic string compression using the counts of repeated characters
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 12/05/16 
  */


object Compress {

  object + {
    def unapply(str: String): Option[(Char, String)] = {
      if (str.isEmpty) None
      else Some(str.head -> str.tail)
    }
  }

  def main(args: Array[String]) {
    println(compress("aabcccccbaaa"))
    println(compress("a"))
    println(compress(""))
  }

  def compress(str: String): String = {

    def inline(list: List[(Char, Int)], newStr: String, lastChar: Option[Char], count: Int): List[(Char, Int)] = {
      newStr match {
        case head + tail if tail.isEmpty => (head, count) :: list
        case head + tail if lastChar.isEmpty || head == lastChar.get => inline(list, tail, Some(head), count + 1)
        case head + tail => inline((lastChar.get, count) :: list, tail, Some(head), 1)
        case _ => list
      }
    }

    val result = inline(List[(Char, Int)](), str, None, 1)
    val s = result.foldLeft(new StringBuilder())((sb, x) => sb.append(x._1).append(x._2)).toString()

    if (s.length < str.length)
      s
    else
      str

  }


}