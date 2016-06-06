package com.github.etacassiopeia.s99.btree

/**
  * <h1>Binary Tree</h1>
  * A binary tree is either empty or it is composed of a root element and two successors,
  * which are binary trees themselves
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 17/05/16
  */

abstract sealed class Tree[+T] {
  def height: Int

  def isBalanced: Boolean

  def isSymmetric: Boolean

  def isMirrorOf[T](other: Tree[T]): Boolean
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = s"N{(${value.toString}) ${left.toString}<-  ->${right.toString}}:$height"

  override def height: Int = Math.max(left.height + 1, right.height + 1)

  override def isBalanced: Boolean = Math.abs(left.height - right.height) <= 1

  override def isSymmetric: Boolean = left.isMirrorOf(right)

  override def isMirrorOf[T](other: Tree[T]): Boolean = (this, other) match {
    case (Node(v1, lNode1, rNode1), Node(v2, lNode2, rNode2)) => lNode1.isMirrorOf(rNode2) && rNode1.isMirrorOf(lNode2)
    case _ => false
  }
}

case object End extends Tree[Nothing] {
  override def toString = "N(.)"

  override def height: Int = 0

  override def isBalanced: Boolean = true

  override def isSymmetric: Boolean = true

  override def isMirrorOf[T](other: Tree[T]): Boolean = other match {
    case End => true
    case _ => false
  }
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
