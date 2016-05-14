package com.github.etacassiopeia.CtCI.arrayslist

/**
  * <h1>Rotate</h1>
  * The Rotate 
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 12/05/16 
  */
object Rotate {
  def main(args: Array[String]) {
    val matrix = Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12), Array(13, 14, 15, 16))
    print(matrix)
    println("------------------")
    rotate(matrix)
    print(matrix)
  }

  def print(matrix: Array[Array[Int]]): Unit = {
    (for {
      row <- matrix
      s = row.mkString("\t")
    } yield s).foreach(println)
  }


  def rotate(matrix: Array[Array[Int]]): Unit = {
    val N = matrix.length
    for (ring <- 0 until (N / 2)) {
      val farthest = N - ring - 1
      for (i <- ring until farthest) {
        val tmp = matrix(ring)(i)
        matrix(ring)(i) = matrix(farthest - i + ring)(ring)
        matrix(farthest - i + ring)(ring) = matrix(farthest)(farthest - i + ring)
        matrix(farthest)(farthest - i + ring) = matrix(i)(farthest)
        matrix(i)(farthest) = tmp
      }
    }
  }
}