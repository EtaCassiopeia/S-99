package com.github.etacassiopeia.CtCI.arrayslist

/**
  * <h1>SetToZero</h1>
  * Write an algorithm such that if an element in an M*N matrix is 0, its entire row and column are set to 0
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 12/05/16
  */
object SetToZero {
  def main(args: Array[String]) {
    val matrix = Array(Array(0, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 0))
    print(matrix)
    val changed = set(matrix)
    println("-----------------")
    print(changed)
  }

  def print(matrix: Array[Array[Int]]) = {
    (for {
      line <- matrix
      s = line.mkString("\t")
    } yield s).foreach(println)
  }

  def deepClone(src: Array[Array[Int]], dst: Array[Array[Int]]): Unit = {
    src.zipWithIndex.foreach { row =>
      row._1.zipWithIndex.foreach { column =>
        dst(row._2)(column._2) = src(row._2)(column._2)
      }
    }
  }

  def set(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    //if we do not use a temporary array, eventually all of the cells will turn to zero
    val tmp: Array[Array[Int]] = Array.ofDim(matrix.length, matrix(0).length)
    //Array.copy(matrix, 0, tmp, 0, matrix.length) //it preserves references
    deepClone(matrix, tmp)

    matrix.zipWithIndex.foreach { row =>
      row._1.zipWithIndex.foreach { column =>
        if (column._1 == 0) {
          for (r <- matrix.indices)
            tmp(r)(column._2) = 0
          for (c <- row._1.indices)
            tmp(row._2)(c) = 0
        }
      }
    }

    tmp
  }
}
