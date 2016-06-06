package com.github.etacassiopeia.s99.btree

/**
  * <h1>P56</h1>
  * Symmetric binary trees.
  * Let us call a binary tree symmetric if you can draw a vertical line through the root node and then the right subtree
  * is the mirror image of the left subtree.
  * Add an isSymmetric method to the Tree class to check whether a given binary tree is symmetric.
  * Hint: Write an isMirror method first to check whether one tree is the mirror image of another.
  * We are only interested in the structure, not in the contents of the nodes.
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 6/06/16 
  */
object P56 {
  def main(args: Array[String]) {
    println(Node('a', Node('b'), Node('c')).isSymmetric)
    println(Node('a', Node('b'), Node('c', End, Node('d))).isSymmetric)
    print(Node('a').isSymmetric)
  }
}
