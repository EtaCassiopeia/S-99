package com.github.etacassiopeia.s99

/**
  * <h1>S99Int</h1>
  * The S99Int 
  *
  * @author Mohsen Zainalpour
  * @version 1.0
  * @since 4/05/16 
  */

class S99Int(val start: Int) {

  import S99Int._

  def isPrime: Boolean =
    (start > 1) && (primes takeWhile {
      _ <= Math.sqrt(start)
    } forall {
      start % _ != 0
    })

}

object S99Int {
  implicit def int2S99Int(i: Int): S99Int = new S99Int(i)

  val primes = 2 #:: (Stream.from(3, 2) filter {
    _.isPrime
  })
}
