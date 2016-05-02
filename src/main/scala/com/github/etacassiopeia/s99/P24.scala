package com.github.etacassiopeia.s99

/**
  * <h1>P24</h1>
  * Lotto: Draw N different random numbers from the set 1..M
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 2/05/16 
  */
object P24 {
  def main(args: Array[String]) {
    println(lotto(6, 49))
  }

  def lotto(n: Int, m: Int): List[Int] = {
    import P23.randomSelect

    val list = List.range(1, m)

    randomSelect(n, list)
  }
}
