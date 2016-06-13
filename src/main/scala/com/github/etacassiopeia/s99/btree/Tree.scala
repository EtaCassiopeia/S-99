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

  // Suppose that U<:T, Due to the fact that we define T in covariant position (Tree[+T]),
  // we will have Tree[U] <: Tree[T] (End class : Nothing<:String).
  // If we use isMirrorOf(other: Tree[T]) we will get an error like this : covariant type T occurs in contravariant position
  // The solution is that, allow any superclass as well: isMirrorOf[S >: T](other: Tree[S]) as method parameter.
  // Now if T changes to U, it's no big deal: a superclass of T is also a superclass of U
  def isMirrorOf[S >: T](other: Tree[S]): Boolean

  //def addValue[U >: T <% Ordered[U]]: Tree[U]
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = s"N{(${value.toString}) ${left.toString}<-  ->${right.toString}}:$height"

  override def height: Int = Math.max(left.height + 1, right.height + 1)

  override def isBalanced: Boolean = Math.abs(left.height - right.height) <= 1

  override def isSymmetric: Boolean = left.isMirrorOf(right)

  override def isMirrorOf[S >: T](other: Tree[S]): Boolean = (this, other) match {
    case (Node(v1, lNode1, rNode1), Node(v2, lNode2, rNode2)) => lNode1.isMirrorOf(rNode2) && rNode1.isMirrorOf(lNode2)
    case _ => false
  }
}

case object End extends Tree[Nothing] {
  override def toString = "N(.)"

  override def height: Int = 0

  override def isBalanced: Boolean = true

  override def isSymmetric: Boolean = true

  override def isMirrorOf[S >: Nothing](other: Tree[S]): Boolean = other match {
    case End => true
    case _ => false
  }
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
