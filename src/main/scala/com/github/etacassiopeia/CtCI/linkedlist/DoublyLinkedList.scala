package com.github.etacassiopeia.CtCI.linkedlist

/**
  * <h1>DoublyLinkedList</h1>
  * The DoublyLinkedList
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 9/06/16
  */

abstract sealed class Node[T] {
  def insertAfter(value: T): Node[T]

  def insertBefore(value: T): Node[T]
}

case class DoublyLinkedNode[T](var prev: Node[T], var next: Node[T], value: T) extends Node[T] {

  override def insertAfter(value: T): Node[T] = {
    val n = new DoublyLinkedNode(this, next, value)
    this.next = n
    n
  }

  override def insertBefore(value: T): Node[T] = {
    val n = new DoublyLinkedNode(prev, this, value)
    this.prev = n
    n
  }

  override def toString = value.toString
}

object DoublyLinkedNode {
  def apply[T](value: T): DoublyLinkedNode[T] = new DoublyLinkedNode(Node.empty[T], Node.empty[T], value)
}

object Node {
  def empty[T]: Node[T] = Empty[T]()
}

case class Empty[T]() extends Node[T] {
  override def insertAfter(value: T): Node[T] = DoublyLinkedNode(value)

  override def toString = "Empty"

  override def insertBefore(value: T): Node[T] = DoublyLinkedNode(value)
}

class DoublyLinkedList[T] {
  private var firstNode: Node[T] = Node.empty[T]
  private var lastNode: Node[T] = Node.empty[T]

  def addToTail(value: T): Unit = {
    val n = lastNode.insertAfter(value)
    lastNode = n

    firstNode = firstNode match {
      case a: Empty[T] => lastNode
      case _ => firstNode
    }
  }

  def addToHead(value: T): Unit = {
    val n = firstNode.insertBefore(value)
    firstNode = n
    lastNode = lastNode match {
      case a: Empty[T] => firstNode
      case _ => lastNode
    }
  }

  def remove(value: T): Unit = {

    def removeNode(n: DoublyLinkedNode[T]): Unit = {
      n.prev match {
        case d: DoublyLinkedNode[T] => d.next = n.next
        case _ =>
      }
      n.next match {
        case d: DoublyLinkedNode[T] => d.prev = n.prev
        case _ =>
      }
    }

    def inlineRemove(n: Node[T]): Unit = {
      n match {
        case d: DoublyLinkedNode[T] if d.value == value => removeNode(d)
        case d: DoublyLinkedNode[T] => inlineRemove(d.next)
        case _ =>
      }
    }

    firstNode match {
      case d: DoublyLinkedNode[T] if d.value == value =>
        d.next match {
          case n: DoublyLinkedNode[T] =>
            n.prev = Empty[T]()
            firstNode = n
          case _ => firstNode = Node.empty[T]
        }
      case d: DoublyLinkedNode[T] => inlineRemove(d.next)
      case _ =>
    }
  }

  def toList: List[T] = {
    def concat(n: Node[T], l: List[T]): List[T] = {
      n match {
        case d: DoublyLinkedNode[T] => concat(d.next, d.value +: l)
        case _ => l
      }
    }

    concat(firstNode, List[T]())
  }
}

object DoublyLinkListTest {
  def main(args: Array[String]) {
    val doublyLinkList = new DoublyLinkedList[String]()
    doublyLinkList.addToTail("A")
    doublyLinkList.addToTail("B")

    doublyLinkList.addToHead("C")
    doublyLinkList.addToHead("D")

    doublyLinkList.remove("C")
    doublyLinkList.remove("D")

    println(doublyLinkList.toList.mkString(","))
  }
}
