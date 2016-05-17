package com.github.etacassiopeia.s99.list

/**
  * <h1>P25</h1>
  * Generate a random permutation of the elements of a list
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 2/05/16 
  */
object P25 {

  def main(args: Array[String]) {
    println(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
  }

  def randomPermute[T](list: List[T]): List[T] = {
    import P23.randomSelect

    randomSelect(list.size, list)
  }
}
