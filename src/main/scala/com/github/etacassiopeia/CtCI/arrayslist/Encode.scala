package com.github.etacassiopeia.CtCI.arrayslist

import scala.reflect.ClassTag

/**
  * <h1>Encode</h1>
  * write a method to replace all spaces in a string with '%2b'
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 12/05/16 
  */
object Encode {
  def main(args: Array[String]) {
    println(encode("Mr John Smith!    "))
    println(encodeUsingArrayList("Mr John Smith!    "))
    println(encodeUsingArrayList2("Mr John Smith!    "))
  }

  def encode(str: String): String = {
    str.foldLeft(new StringBuilder()) {
      case (sb, c) if c == ' ' => sb.append("%2b")
      case (sb, c) => sb.append(c)
    }.toString()
  }

  def encodeUsingArrayList(str: String): String = {
    str.foldLeft(new ArrayList[Char]()) {
      case (sb, c) if c == ' ' => "%2b".foreach(sb.add); sb
      case (sb, c) => sb.add(c); sb
    }.toString()
  }

  def encodeUsingArrayList2(str: String): String = {
    str.foldLeft(new ArrayList2[Char]()) {
      case (sb, c) if c == ' ' => "%2b".foreach(sb.add); sb
      case (sb, c) => sb.add(c); sb
    }.toString()
  }

  //Error : cannot find class tag for element type T
  //The standard solution to this is simply to pass an implicit classtag argument
  class ArrayList[T <: Char](implicit m: ClassTag[T]) {
    val growSize = 10
    var numCurrentElements = 0
    var array = new Array[T](growSize)

    def add(value: T): Unit = {
      if (numCurrentElements >= size)
        array = resizeArray()

      array(numCurrentElements) = value
      numCurrentElements += 1
    }

    private def size(): Int =
      array.length

    private def resizeArray(): Array[T] = {
      array.zipWithIndex.foldLeft(new Array[T](array.length + growSize))((a, e) => {
        a(e._2) = e._1
        a
      })
    }

    def trimToSize: Array[T] = {
      val trimmed = new Array[T](numCurrentElements)
      Array.copy(array, 0, trimmed, 0, numCurrentElements)
      trimmed
    }

    override def toString: String = trimToSize.mkString("")
  }

  /*
  Java's arrays (unlike generics) contain, at runtime, information about its component type.
   So you must know the component type when you create the array.
    Since you don't know what T is at runtime, you can't create the array.
   */
  class ArrayList2[T] {
    val growSize = 10
    var numCurrentElements = 0
    var array = new Array[Any](growSize)

    def add(value: T): Unit = {
      if (numCurrentElements >= size)
        array = resizeArray()

      array(numCurrentElements) = value
      numCurrentElements += 1
    }

    private def size(): Int =
      array.length

    private def resizeArray(): Array[Any] = {
      array.zipWithIndex.foldLeft(new Array[Any](array.length + growSize))((a, e) => {
        a(e._2) = e._1
        a
      })
    }

    private def trimToSize: Array[Any] = {
      val trimmed = new Array[Any](numCurrentElements)
      Array.copy(array, 0, trimmed, 0, numCurrentElements)
      trimmed
    }

    override def toString: String = trimToSize.mkString("")
  }

}
