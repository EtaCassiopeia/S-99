package com.github.etacassiopeia.s99.btree

/**
  * <h1>P57</h1>
  * Binary search trees(dictionaries)
  * Write a function to add an element to a binary search tree.
  * Hint: The abstract definition of addValue in Tree should be def addValue[U >:T < %Ordered[U]](c:U):Tree[U].
  * The >:T is because addValue's parameters need to be contravariant in T.
  * (conceptually, we're adding nodes above existing nodes.
  * In order for the subnodes to be of type T or any subtype, the upper nodes must be of type T or any supertype.)
  * The <% Ordered[U] allows us to use the < operator on the values in the tree.
  *
  * Use that function to construct a binary tree from a list of integers.
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 6/06/16 
  */
object P57 {
  def main(args: Array[String]) {

  }
}
