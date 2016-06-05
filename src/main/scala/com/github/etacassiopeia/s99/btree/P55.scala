package com.github.etacassiopeia.s99.btree

/**
  * <h1>P55</h1>
  * Construct completely balanced binary tree
  * In a completely balanced binary tree, the following property holds for every node: The number of nodes
  * in its left subtree and the number of in its right subtree are almost equal, which means their difference
  * is not greater than one
  *
  * Define an object named Tree, Write a function Tree.cBalanced to construct completely balanced trees
  * for a given number of nodes. The function should generate all solutions.
  * The function should take as parameters the number of nodes and a single value to put in all of them
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 06/03/16
  */
object P55 {
  def main(args: Array[String]) {
    //println(Tree.cBalanced(4, "x"))
    Tree.cBalanced(4, "x") foreach (t => {
      println(t)
      println(t.isBalanced)
    })
  }

  object Tree {
    def cBalanced[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
      case n if n < 1 => List(End)
      case n if n % 2 == 1 =>
        for {
          l <- cBalanced(n / 2, value)
          r <- cBalanced(n / 2, value)
          n = Node(value, l, r)
        } yield n
      case n if n % 2 == 0 =>
        val shortSubTree = cBalanced((n - 1) / 2, value)
        val longSubTree = cBalanced((n - 1) / 2 + 1, value)
        (for {
          l <- shortSubTree
          r <- longSubTree
          n = Node(value, l, r)
        } yield n) ::: (for {
          l <- shortSubTree
          r <- longSubTree
          m = Node(value, r, l)
        } yield m)
    }
  }

}