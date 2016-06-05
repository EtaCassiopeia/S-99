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
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = s"N{(${value.toString}) ${left.toString}<-  ->${right.toString}}:$height"

  override def height: Int = Math.max(left.height + 1, right.height + 1)

  override def isBalanced: Boolean = Math.abs(left.height - right.height) <= 1
}

case object End extends Tree[Nothing] {
  override def toString = "N(.)"

  override def height: Int = 0

  override def isBalanced: Boolean = true
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
