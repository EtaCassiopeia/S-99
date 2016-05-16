package com.github.etacassiopeia.s99

/**
  * <h1>P41</h1>
  * A list of Goldbach compositions.
  * Given a range if integers by its lower and upper limit,
  * print a list of all even numbers and their Goldbach composition
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 16/05/16 
  */

import S99Int._

object P41 {
  def main(args: Array[String]) {
    printGoldbachList(9 to 20)
    printGoldbachListLimited(1 to 2000, 50)
  }

  def goldbachList(r: Range): List[(Int, (Int, Int))] = {
    r.filter(x => (x > 2) && (x % 2 == 0)).map((x) => (x, x.goldbach)) toList
  }

  def printGoldbachList(r: Range): Unit = {
    print(goldbachList(r))
  }

  def printGoldbachListLimited(r: Range, limit: Int): Unit = {
    print(goldbachList(r).filter {
      case (n, gn@(a, b)) => a > limit && b > limit
    })
  }

  def print(list: List[(Int, (Int, Int))]): Unit = list.map {
    case (n, gb@(a, b)) => s"$n = $a + $b "
  } foreach println
}
