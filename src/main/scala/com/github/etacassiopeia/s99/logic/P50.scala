package com.github.etacassiopeia.s99.logic

import scala.collection.mutable

/**
  * <h1>P50</h1>
  * Huffman code
  * We suppose a set of symbols with their frequencies, given a list of (S,F) Tuples. E.g. (("a",45),("b",13),("c",12),
  * ("d,",16),("e",9),("f",5)).
  * Our objective is to construct a list of (S,C) Tuples, where C is the huffman code word for the symbol S.
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 17/05/16
  */

sealed trait Tree[A] extends Comparable[Tree[A]] {
  val frequency: Int

  override def compareTo(o: Tree[A]): Int = frequency - o.frequency

  def toCode: List[(A, String)] = toCodePrefixed("")

  def toCodePrefixed(prefix: String): List[(A, String)]
}

class LeafNode[A](symbol: A, symbolFrequency: Int) extends Tree[A] {
  override val frequency: Int = symbolFrequency

  override def toString: String = s"LeafNode($symbol,$frequency)"

  def toCodePrefixed(prefix: String): List[(A, String)] = List((symbol, prefix))
}

class InnerNode[A](leftNode: Tree[A], rightNode: Tree[A]) extends Tree[A] {
  override val frequency: Int = leftNode.frequency + rightNode.frequency

  override def toString: String = s"InnerNode($frequency -> $leftNode,$rightNode)"

  def toCodePrefixed(prefix: String): List[(A, String)] =
    leftNode.toCodePrefixed(prefix + "0") ::: rightNode.toCodePrefixed(prefix + "1")
}

object :: {
  def unapply[A](queue: mutable.PriorityQueue[Tree[A]]): Option[(Tree[A], mutable.PriorityQueue[Tree[A]])] = {
    if (queue.isEmpty) None
    else Some(queue.head -> queue.tail)
  }
}

object P50 {
  def main(args: Array[String]) {

    val freqList = List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))

    implicit val ord = Ordering[Tree[String]].reverse
    val pq = scala.collection.mutable.PriorityQueue[Tree[String]](freqList map (x => new LeafNode[String](x._1, x._2)): _*)

    val tree = P50.huffmanTree(pq)
    println(tree)
    println(tree.toCode)
  }

  def huffmanTree[A](queue: mutable.PriorityQueue[Tree[A]], tree: Tree[A] = null): Tree[A] = {
    queue match {
      case first :: second :: tail if tail.nonEmpty =>
        val t = new InnerNode[A](first, second)
        huffmanTree(tail += t, t)
      case first :: second :: tail =>
        new InnerNode[A](first, second)
      case _ => tree
    }
  }
}
